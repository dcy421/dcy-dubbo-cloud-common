package com.dcy.web.handler;

import com.dcy.common.model.ResponseData;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author：dcy
 * @Description: 全局的的异常拦截器（拦截所有的控制器）
 * @Date: 2019/9/6 13:25
 */
@RestControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

    /**
     * 校验异常
     *
     * @param validException
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseData<String> validException(RuntimeException validException) {
        return ResponseData.error(validException.getMessage());
    }
}
