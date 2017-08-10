package com.yyq.project.product.VO;

import com.yyq.project.product.enums.ResultEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by yangyunqi on 2017/8/3.
 */
@Data
@Accessors(chain = true)
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVO(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public ResultVO(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
}
