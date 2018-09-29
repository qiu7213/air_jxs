package com.example.demo.interceptor;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(" ----   [ doFilter ]");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest reqs = (HttpServletRequest) servletRequest;

        response.setHeader("Access-Control-Allow-Origin", reqs.getHeader("Origin"));// 推荐这种
        // 跨域设置  设置具体某个域名，多个用逗号隔开
        //  response.setHeader("Access-Control-Allow-Origin", "https://baidu.com,https://abc.com");

        // Access-Control-Allow-Credentials 该字段可选。它的值是一个布尔值，表示是否允许发送Cookie。默认情况下，Cookie不包括在CORS请求之中。
        // 设为true，即表示服务器明确许可，Cookie可以包含在请求中，一起发给服务器。
        // 这个值也只能设为true，如果服务器不要浏览器发送Cookie，删除该字段即可
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");// *
        response.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,token,X-Requested-With");
        response.setHeader("Access-Control-Max-Age", "3600");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
