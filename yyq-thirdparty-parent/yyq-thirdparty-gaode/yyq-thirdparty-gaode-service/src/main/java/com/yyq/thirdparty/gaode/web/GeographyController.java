package com.yyq.thirdparty.gaode.web;

import com.alibaba.fastjson.JSONObject;
import com.yyq.thirdparty.gaode.service.GeographyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@RestController
@RequestMapping("gaode")
@Api(value = "高德API", description = "高德API")
public class GeographyController {

    @Autowired
    private GeographyService geographyService;

    @RequestMapping(value = "getUserLocationInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获得用户地理位置信息", httpMethod = "GET", response = JSONObject.class, notes = "高德API")
    public JSONObject getUserLocationInfo() {
        return geographyService.getUserLocationInfo();
    }
}
