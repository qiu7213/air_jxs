package com.example.demo.interceptor;

import com.example.demo.config.RedisComponent;
import com.example.demo.controller.ErrorController;
import com.example.demo.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor  implements HandlerInterceptor{

    //拦截器加载的时间点在springcontext之前，所以在拦截器中注入自然为null
    @Autowired
    RedisComponent redisComponent;

    @Autowired
    ErrorController erroeController;

    // 处理器执行前方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("[MyInterceptor]   -->1   preHandle()  ------------------------------------------------- >"+request.getRequestURL()+ " ------- "+request.getSession().getServletContext().getRealPath("/") );
        String cookieToken =  CookieUtil.getCookie(request,"token");
        System.out.println("[MyInterceptor]  cookie :  "+cookieToken);
        String value = redisComponent.getLogin(cookieToken);
        System.out.println( request.getContextPath() + "/index.html" +"    -----     "+request.getRequestURI());
        if(null != value){
                System.out.println("redisComponent.getLogin(cookie) : " +value);
                return true;

        }else{
            System.out.println("redisComponent.getLogin(cookie) = null : " +value);response.setCharacterEncoding("utf-8");
            erroeController.ErrorReq();
            //response.getWriter().write("please login");
            //response.sendRedirect(request.getContextPath() + "/index.html");
            return false;
        }
//        if(null == cookie){
//            response.sendRedirect(request.getContextPath() + "/index.html");
//        }else{
//            String value = null;
//            RedisComponent redis = new RedisComponent();
//            value = redisComponent.getLogin(cookie);
//            if(null == value){
//                response.sendRedirect(request.getContextPath() + "/index.html");
//            }
//            System.out.println("preHandle : " +value);
//        }

    }

    //处理器处理后方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("[MyInterceptor]   -->2   postHandle()  :"+request.getRequestURL());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("[MyInterceptor]   -->3   afterCompletion() :"+request.getRequestURL());
    }
}
