package com.uy.util;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;

public class TokenUtils {

    //设置过期时间
    private static final long EXPIRE_DATE = 1000 * 10 * 60 * 24; // 一天
    //token秘钥
    private static final String TOKEN_SECRET = "TOKENIZING";

    private static final String OPEN_ID = "73749970";

    /**
     * 生成token
     * @param userName 用户名
     * @param openId  小程序open_id
     * @return token
     */
    public static String createToken(String userName, String wechatUserId , String openId) {

        // 过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
        // 获得JWT构造器
        JwtBuilder builder = Jwts.builder();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userName", userName);
        hashMap.put("wechatUserId" , wechatUserId);
        hashMap.put("openId", openId);


        return builder.setSubject("hello")
                .setClaims(hashMap)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
                .compact();
    }

    /**
     * 生成token
     * @param userName 用户名
     * @return token
     */
    public static String createToken(String userName, String wechatUserId) {

        // 过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
        // 获得JWT构造器
        JwtBuilder builder = Jwts.builder();

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userName", userName);
        hashMap.put("wechatUserId" , wechatUserId);

        return builder.setSubject("hello")
                .setClaims(hashMap)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
                .compact();
    }


    /**
     * 解析token
     * @param token token
     * @param key   key
     * @return 结果
     */
    public static String getString(String token, String key) {
        if (StringUtils.isEmpty(token)) return null;
        try {
            Jws<Claims> claimsJws
                    = Jwts.parser() // 构造器
                    .setSigningKey(TOKEN_SECRET) // 加盐
                    .parseClaimsJws(token);
            // 获取token里的信息
            Claims claims = claimsJws.getBody();
            return (String) claims.get(key);
        } catch (Exception e) {
            return null;
        }
    }

    // 获取token的openId
    public static String getOpenId(String token) {
        return getString(token, "openId");
    }

    // 获取userName
    public static String getUserName(String token) {
        return getString(token, "userName");
    }

    // 获取wechatUserId
    public static  String getUserId (String token) {
        return getString(token, "wechatUserId");
    }

}


