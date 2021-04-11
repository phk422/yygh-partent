package com.phk.yygh.common.exception;

import com.phk.yygh.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/4/11
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        return Result.fail();
    }


    // 手动设置异常
    @ExceptionHandler(YyghException.class)
    @ResponseBody
    public Result error(YyghException e) {
        return Result.fail(e.getMessage());
    }

}
