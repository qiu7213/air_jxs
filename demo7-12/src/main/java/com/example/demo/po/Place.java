package com.example.demo.po;

public class Place {

    private Integer id;
    private String placeName;
    private Integer placeState;
    private Integer userId;
    private String creatTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPlaceState() {
        return placeState;
    }

    public void setPlaceState(Integer placeState) {
        this.placeState = placeState;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }


    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
