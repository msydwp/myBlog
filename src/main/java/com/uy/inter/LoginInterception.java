package com.uy.inter;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.uy.pojo.TUser;
import com.uy.redis.RedisTemplateUtils;
import com.uy.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class LoginInterception implements HandlerInterceptor {

    //存放鉴权信息的Header名称，默认是Authorization
    final String httpHeaderName = "Token";
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisTemplateUtils redisTemplateUtils ;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取token
        String token = request.getHeader(httpHeaderName);

        if (StringUtils.isBlank(token)) {
            returnNoLogin(response);
            return false;
        }

        // 从redis中拿token对应user
        if (verificationToken(token)) {
            returnNoLogin(response);
            // token续期
            redisTemplate.expire(token, 30, TimeUnit.MINUTES);
            return false;
        }

        // 放行
        return true;
    }

    //token验证登陆
    public Boolean verificationToken(String token){
        log.info("verificationToken...");
        if(redisTemplateUtils.hasKey(token)){
            //判断该token是否存在
            TUser tUser = (TUser) redisTemplateUtils.get(token);
            //token续费 30分钟
            redisTemplateUtils.expire(token, 30);
            return true;
        }

        return false ;
    }

    //token验证登陆
    public Boolean verificationUser(String token){
        log.info("verificationUser...");
        if(redisTemplateUtils.hasKey(token)){
            //判断该token是否存在
            TUser tUser = (TUser) redisTemplateUtils.get(token);

            //token续费 30分钟
            redisTemplateUtils.expire(token, 30);
            // 判断用户是否存在
            return true;
        }

        return false ;
    }


    /**
     * 返回未登录的错误信息
     * @param response ServletResponse
     */
    private void returnNoLogin(HttpServletResponse response) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        // 设置返回401 和响应编码
        response.setStatus(401);
        response.setContentType("Application/json;charset=utf-8");
        // 构造返回响应体
        Result<String> result = Result.<String>builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .message("未登陆，请先登陆 !")
                .build();
        String resultString = JSON.toJSONString(result);
        outputStream.write(resultString.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("执行了TestInterceptor的postHandle方法");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
