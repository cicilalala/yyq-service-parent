package com.yyq.project.workbanch.service;

import com.alibaba.fastjson.JSONObject;
import com.yyq.project.workbanch.api.thirdparty.gaode.GeographyAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yangyunqi on 2017/6/30.
 */
@Service
public class GeographyService {

     @Autowired
     private GeographyAPI geographyAPI;

     public JSONObject getUserLocationInfo() {
         return geographyAPI.getUserLocationInfo();
     }
}
