package com.example.demo.service;

import com.example.demo.custom.PlaceCustom;
import com.example.demo.mapper.PlaceMapper;
import com.example.demo.po.Place;
import com.example.demo.vo.UserPalceInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceMapper placeMapper;


    public List<PlaceCustom> userPlaceInfo(Integer id) {
        System.out.println(" -- id : " +id);
        return placeMapper.userPlaceInfo2(id);
    }



    public List<PlaceCustom> findPlaceByUserID(Integer id) {
        System.out.println(" -- id findPlaceByUserID : " +id);
        List<PlaceCustom> p= placeMapper.findPlaceByUserID(id);
        return p;
    }
}
