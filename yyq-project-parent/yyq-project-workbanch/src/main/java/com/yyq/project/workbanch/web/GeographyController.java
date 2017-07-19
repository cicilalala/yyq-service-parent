package com.yyq.project.workbanch.web;

import com.alibaba.fastjson.JSONObject;
import com.yyq.base.support.dto.Result;
import com.yyq.base.support.utils.ResultUtil;
import com.yyq.project.workbanch.service.GeographyService;
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
@Api(value = "地理信息", description = "地理信息")
public class GeographyController {

    @Autowired
    private GeographyService geographyService;

    @RequestMapping(value = "getUserLocationInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获得用户地理位置信息", httpMethod = "GET", response = Result.class, notes = "获得用户地理位置信息")
    public Result getUserLocationInfo() {
        return ResultUtil.success(geographyService.getUserLocationInfo());
    }
}

