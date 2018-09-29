package com.example.demo.custom;

import com.example.demo.po.Place;

public class PlaceCustom extends Place {


    // 添加用户的信息
    String UserName;
    String phone;
    String address;


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
