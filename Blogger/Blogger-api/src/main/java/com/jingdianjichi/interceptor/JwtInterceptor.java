package com.jingdianjichi.interceptor;



import com.jingdianjichi.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Role;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

/**
 * @Description: jwt拦截器
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        System.out.println("请求里的token=" + token);
        // 如果不是映射到方法直接通过
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("无token，请重新登录");
        }
        Claims claims=null;
        try {
             claims = JwtUtil.parserJwt(token);
            System.out.println(claims);
        } catch (Exception e) {
            throw new RuntimeException("token失效");
        }
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        Role annotation = method.getAnnotation(Role.class);
        if (annotation != null){
            Integer i = claims.get("userRole", Integer.class);
            if (i<=annotation.value()){
                return true;
            }else {
                throw new RuntimeException("您没有权限");
            }
        }
        return true;
    }
}
