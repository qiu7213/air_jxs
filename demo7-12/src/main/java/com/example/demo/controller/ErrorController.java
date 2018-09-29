package com.example.demo.controller;

import com.example.demo.constant.Constant;
import com.example.demo.constant.ResponeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class ErrorController {

    @Autowired
    ResponeMessage message;

    public ResponeMessage ErrorReq(){
        message.setCode(Constant.LOGIN_FAIL3);
        message.setMsg(Constant.LOGIN_FAIL3_INFO);

         return message;
    }
}
