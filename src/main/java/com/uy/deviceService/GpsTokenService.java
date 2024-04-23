package com.uy.deviceService;

import com.alibaba.fastjson.JSONObject;
import com.uy.redis.RedisTemplateUtils;
import com.uy.util.HttpUtils;
import com.uy.util.MD5Utils;
import com.uy.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class GpsTokenService {

//    @Value("${figps.appid}")
    private String appid = "上海心源";

//    @Value("${figps.sigatures}")
    private String sigatures = "kaeeRHg5SgX!1oCXfR0q$4qsKxpS9etW";

//    @Value("${figps.url}")
    private String url = "https://open.figps.com/api";

    private static final String TOKEN_KEY = "jshwchj_gips_token";

    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

    /**
     * 保存token
     * @param token
     */
    public void saveToken(String token) {
//        System.out.println("save token:"+token);
        log.info("save token:"+token);
        redisTemplateUtils.set(TOKEN_KEY,token,60*120);
    }

    /**
     * 获取token
     * @return
     */
    public String getToken() {

        if (redisTemplateUtils.hasKey(TOKEN_KEY)) {
            return redisTemplateUtils.get(TOKEN_KEY).toString();
        }

        String token = fetchThirdPartyToken();
        saveToken(token);
        return token;
    }

    /**
     * 获取第三方token
     * @return
     */
    private String fetchThirdPartyToken(){
        String result = "" ;

        String url = this.url+"/auth";

        long time = System.currentTimeMillis() / 1000; // 获取当前的UNIX时间戳

        String signature = MD5Utils.generateMD5(sigatures);
        signature = MD5Utils.generateMD5(signature+time);

        String jsonParam = "{\"appid\":\"上海心源\", \"time\":" + time + ",\"signature\":\"" + signature + "\"}";

        try {
            String json = HttpUtils.sendPostRequest(url,jsonParam);
            JSONObject jsonObject = JSONObject.parseObject(json);

            String code = jsonObject.getString("code");

            if(code == null || !"0".equals(code)){
                log.error("用户认证失败,错误码为："+code+",错误信息为："+jsonObject.getString("result"));
            }

            result = jsonObject.getString("accessToken");
        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 每隔105分钟刷新一次token
     */
    @Scheduled(cron = "0 */105 * * * ?")
    public void refreshToken() {
        String token = fetchThirdPartyToken();
        saveToken(token);
    }


}
