package com.example.demo.constant;

import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
public class ResponeMessage<T> implements Serializable{

    private int code;
    private String msg;
    private Object object;
    private String token;





    public ResponeMessage(){

    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
