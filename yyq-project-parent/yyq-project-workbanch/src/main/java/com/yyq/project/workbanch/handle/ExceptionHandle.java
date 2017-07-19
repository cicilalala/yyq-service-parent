package com.yyq.project.workbanch.handle;

import com.yyq.base.support.dto.Result;
import com.yyq.base.support.exception.BaseException;
import com.yyq.base.support.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof BaseException) {
           BaseException baseException = (BaseException) e;
           return ResultUtil.error(baseException.getCode(), baseException.getMessage());
        } else {
            log.info("系统错误：", e);
            return ResultUtil.error();
        }
    }
}
