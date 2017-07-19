package com.yyq.thirdparty.gaode.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yangyunqi on 2017/7/18.
 */

@Slf4j
@Service
public class GeographyService {

    private static final String KEY = "c83f94d07a1d6a5e004b1b60274aae73";
    private static final String BASE_URL = "http://restapi.amap.com/v3/";

    @Autowired
    private RestTemplate restTemplate;

    public JSONObject getUserLocationInfo() {
        JSONObject gpi = getGPI();
        String status = gpi.getString("status");
        if ("1".equals(status)) {
            Integer adcode = gpi.getInteger("adcode");
            return getWeatherInfo(adcode);
        } else {
            throw new RuntimeException("CAN NOT GET GPI");
        }
    }

    private JSONObject getGPI() {

        StringBuilder url = new StringBuilder();
        url.append(BASE_URL);
        url.append("ip");
        url.append("?key=");
        url.append(KEY);
        log.info("reqURL={}", url);
        return restTemplate.getForObject(url.toString(), JSONObject.class);
    }

    private JSONObject getWeatherInfo(Integer adcode) {

        StringBuilder url = new StringBuilder();
        url.append(BASE_URL);
        url.append("weather/weatherInfo");
        url.append("?key=");
        url.append(KEY);
        url.append("&city=");
        url.append(adcode);
        log.info("reqURL={}", url);
        return restTemplate.getForObject(url.toString(), JSONObject.class);
    }
}
