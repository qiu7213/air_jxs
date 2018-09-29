package com.example.demo.mapper;


import com.example.demo.custom.PlaceCustom;
import com.example.demo.po.Place;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface PlaceMapper {

    public List<PlaceCustom> userPlaceInfo2(Integer id);



    public List<PlaceCustom> findPlaceByUserID(Integer id);
}
