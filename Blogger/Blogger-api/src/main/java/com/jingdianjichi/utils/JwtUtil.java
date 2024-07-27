package com.jingdianjichi.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class JwtUtil {

    private static long expire_time =  3600 * 1000; // 2秒是做测试用的（设置一个钟 1000 * 60 * 60 * 1）
    private static String sign = "AsldjlJDLKKJSDKLFJlksjlkjlkSDL"; // 加密签名密钥

    /**
     * 创建token返回
     *
     * @return
     */
    public static String createToken(Map<String, Object> map) {
        // 创建一个JwtBuilder对象
        JwtBuilder jwtBuilder = Jwts.builder();
        // jwtToken -> abc.def.xyz
        String jwtToken = jwtBuilder
                // Header:头部
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // PayLoad:载荷（用户信息，就是需要保存的数据）
                .claim("userId", map.get("userId"))
                .claim("userName", map.get("userName"))
                .claim("userRole",map.get("userRole"))
                .setSubject("user-info") // 这个载荷的名称
                // Token的过期时间
                .setExpiration(new Date(System.currentTimeMillis() + expire_time)) // 从当前系统时间往后存活一小时
                // id字段
                .setId(UUID.randomUUID().toString())
                // 设置加密算法和签名
                .signWith(SignatureAlgorithm.HS256, sign)
                // 使用”."连接成一个完整的字符串
                .compact();
        return jwtToken;
    }

    /**
     * 获取解析的用户信息
     *
     * @param token
     * @return Claims
     */
    public static Claims parserJwt(String token) {
        if (token == null || token.trim().length() == 0) {
            return null;
        }
        Jws<Claims> jws = Jwts.parser().setSigningKey(sign).parseClaimsJws(token);
        return jws.getBody(); // 存储的用户信息
    }

    /**
     * 获取解析的用户ID
     *
     * @param token
     * @return
     */
    public static String parserJwtById(String token) {
        if (token == null || token.trim().length() == 0) {
            return "";
        }
        Jws<Claims> jws = Jwts.parser().setSigningKey(sign).parseClaimsJws(token);
        return (String) jws.getBody().get("userId"); // 存储的用户信息
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static boolean checkToken(String token) {
        if (token == null || token.trim().length() == 0) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(sign).parseClaimsJws(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}