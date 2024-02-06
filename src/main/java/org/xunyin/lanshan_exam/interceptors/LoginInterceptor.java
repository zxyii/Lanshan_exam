package org.xunyin.lanshan_exam.interceptors;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.xunyin.lanshan_exam.Utils.JwtUtil;
import org.xunyin.lanshan_exam.Utils.ThteadLocalUtil;
import org.xunyin.lanshan_exam.pojo.Response;

import java.util.Map;
import java.util.Objects;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
      String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            ThteadLocalUtil.set(claims);
            return true;
        } catch (Exception e) {
            Response.error("未登录");
            response.setStatus(404);
            return false;
        }
    }
}
