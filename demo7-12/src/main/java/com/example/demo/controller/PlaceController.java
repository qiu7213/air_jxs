package com.example.demo.controller;


import com.example.demo.custom.PlaceCustom;
import com.example.demo.po.Place;
import com.example.demo.service.PlaceService;
import com.example.demo.service.PlaceServiceImpl;
import com.example.demo.vo.UserPalceInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    PlaceServiceImpl placeService;

    @RequestMapping("/userPlaceInfo2/{id}")
    @ResponseBody
    public List<PlaceCustom> userPlaceInfo(@PathVariable("id") Integer id){
        id = 5;
        System.out.println(" -- id : " +id);
        List<PlaceCustom> place = placeService.userPlaceInfo(id);
        return place;

    }

    @RequestMapping("/findPlaceByUserID/{id}")
    @ResponseBody
    public List<PlaceCustom> findPlaceByUserID(Integer id){
        id = 5;
        return placeService.findPlaceByUserID(id);
    }

}
