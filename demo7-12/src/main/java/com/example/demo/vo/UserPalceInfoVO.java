package com.example.demo.vo;

import com.example.demo.custom.UserCustom;
import com.example.demo.po.PlaceImg;
import com.example.demo.po.User;
import com.example.demo.custom.PlaceCustom;
import org.springframework.stereotype.Component;

@Component
public class UserPalceInfoVO {

    private UserCustom user;

    private PlaceCustom place;

    private PlaceImg placeImg;


    public UserCustom getUser() {
        return user;
    }

    public void setUser(UserCustom user) {
        this.user = user;
    }

    public PlaceCustom getPlace() {
        return place;
    }

    public void setPlace(PlaceCustom place) {
        this.place = place;
    }

    public PlaceImg getPlaceImg() {
        return placeImg;
    }

    public void setPlaceImg(PlaceImg placeImg) {
        this.placeImg = placeImg;
    }
}
