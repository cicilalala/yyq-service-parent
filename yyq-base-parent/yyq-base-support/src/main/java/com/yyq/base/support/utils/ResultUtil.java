package com.yyq.base.support.utils;

import com.yyq.base.support.dto.Result;
import com.yyq.base.support.enums.ResultEnum;

/**
 * Created by yangyunqi on 2017/7/18.
 */
public class ResultUtil {

    public static Result success() {
        return new Result(ResultEnum.SUCCESS);
    }

    public static Result success(Integer code, String message) {
        return new Result<>(code, message);
    }

    public static Result<Object> success(Object object) {
        return new Result<>(ResultEnum.SUCCESS, object);
    }

    public static Result<Object> success(Integer code, String message, Object object) {
        return new Result<>(code, message, object);
    }

    public static Result error() {return new Result(ResultEnum.UNKNOW_ERROR);}

    public static Result error(ResultEnum resultEnum) {return new Result(resultEnum);}

    public static Result error(Integer code, String message) {
        return new Result(code, message);
    }
}
