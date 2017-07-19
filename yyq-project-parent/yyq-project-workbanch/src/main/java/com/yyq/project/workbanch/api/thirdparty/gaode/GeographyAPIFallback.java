package com.yyq.project.workbanch.api.thirdparty.gaode;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Created by yangyunqi on 2017/7/18.
 */
@Component
public class GeographyAPIFallback implements GeographyAPI {

    @Override
    public JSONObject getUserLocationInfo() {
        return null;
    }
}
