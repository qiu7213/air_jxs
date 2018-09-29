package com.example.demo.constant;

public enum MessageCodeEnum {


    SUCCESS(1),
    FAIL(-1);

    private Integer code;

    



      MessageCodeEnum(Integer code){
        this.code = code;
    }




}
