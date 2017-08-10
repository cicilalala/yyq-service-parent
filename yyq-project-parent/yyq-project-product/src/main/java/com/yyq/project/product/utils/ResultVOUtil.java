package com.yyq.project.product.utils;

import com.yyq.project.product.VO.ResultVO;
import com.yyq.project.product.enums.ResultEnum;

/**
 * Created by yangyunqi on 2017/8/3.
 */
public class ResultVOUtil {

    public static ResultVO success() {
        return new ResultVO(ResultEnum.SUCCESS);
    }

    public static ResultVO success(Integer code, String message) {
        return new ResultVO(code, message);
    }

    public static ResultVO success(Object object) {
        return new ResultVO(ResultEnum.SUCCESS, object);
    }

    public static ResultVO success(Integer code, String message, Object object) {
        return new ResultVO(code, message, object);
    }

    public static ResultVO error() {
        return new ResultVO(ResultEnum.UNKNOW_ERROR);
    }

    public static ResultVO error(ResultEnum resultEnum) {
        return new ResultVO(resultEnum);
    }

    public static ResultVO error(Integer code, String message) {
        return new ResultVO(code, message);
    }
}
