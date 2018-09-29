package com.example.demo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CookieUtil {


    public static String getCookie(HttpServletRequest request, String cookieName){

        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void writeCookie(HttpServletResponse response, String cookieName, String value){
        //  在cookie值中不能使用分号（;）、逗号（,）、等号（=）以及空格，否则会出现异常
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }


    /**
     * cookie中有特殊字符需编码才能通过；
     * 在cookie值中不能使用分号（;）、逗号（,）、等号（=）以及空格
     * @param response
     * @param cookieName
     * @param value
     */
    public static void writeCookieURLEncoder(HttpServletResponse response, String cookieName, String value){
        try {
            //  在cookie值中不能使用分号（;）、逗号（,）、等号（=）以及空格，否则会出现异常
            //  用 URLEncoder 编码，前台JavaScript 使用 decodeURI(data) 解码
            value =  URLEncoder.encode(value,"UTF-8");
            // JS :decodeURI 无法解码  %3A    %2C
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writeCookie(response,cookieName,value);
    }

}
