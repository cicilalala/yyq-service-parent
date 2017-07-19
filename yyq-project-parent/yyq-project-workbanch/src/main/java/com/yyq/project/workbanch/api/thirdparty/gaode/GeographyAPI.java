package com.yyq.project.workbanch.api.thirdparty.gaode;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@FeignClient(value = "yyq-thirdparty-gaode", path = "gaode", fallback = GeographyAPIFallback.class)
public interface GeographyAPI {

    @RequestMapping(value = "getUserLocationInfo", method = RequestMethod.GET)
    JSONObject getUserLocationInfo();
}
