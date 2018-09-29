package com.example.demo.service;

import com.example.demo.custom.PlaceCustom;
import com.example.demo.po.Place;
import com.example.demo.vo.UserPalceInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlaceService {

    public List<PlaceCustom> userPlaceInfo(Integer id);

    public List<PlaceCustom> findPlaceByUserID(Integer id);

}
