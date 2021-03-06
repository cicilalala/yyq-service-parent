package com.yyq.base.api.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by yangyunqi on 2017/7/18.
 */
public class BaseModel<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Map<String, Object> toMap() {
        return toJSONObject();
    }

    public Map<String, Object> toMap(boolean ordered) {
        return toJSONObject(ordered);
    }

    public JSONObject toJSONObject() {
        return toJSONObject(false);
    }

    public JSONObject toJSONObject(boolean ordered) {
        JSONObject jsonObject = new JSONObject(ordered);
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getName().equals("serialVersionUID")) {
                    continue;
                }
                field.setAccessible(true);
                Object value = field.get(this);
                jsonObject.put(field.getName(), value);
            } catch (Exception e) {
                throw new RuntimeException("convert JsonObject error", e);
            }
        }
        return jsonObject;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        try {
            return toJSONString();
        } catch (Exception e) {

        }

        return this.toString();
    }

    @SuppressWarnings("unchecked")
    public T cloneBean() {
        return (T) JSON.toJavaObject(toJSONObject(), this.getClass());
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public T populate(Map map) {
        JSONObject jsonObject = toJSONObject();
        jsonObject.putAll(map);
        return (T) JSON.toJavaObject(jsonObject, this.getClass());
    }
}
