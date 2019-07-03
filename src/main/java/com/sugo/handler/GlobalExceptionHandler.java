package com.sugo.handler;

import com.sugo.domain.Result;
import com.sugo.domain.enums.ResultEnum;
import com.sugo.exception.BusinessException;
import com.sugo.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenxl on 2018/3/1.
 * 统一异常处理类
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 系统异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception exception){
        log.info("系统异常：{}", exception.getMessage());
        log.info("", exception);
        return ResultUtils.error(ResultEnum.SYSTEM_ERROR.getCode(), ResultEnum.FAIL.getMessage() + ": " + exception.getMessage());
    }

    /**
     * 业务异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result businessExceptionHandler(BusinessException exception){
        log.info("业务异常：{}", exception.getMessage());
        log.info("", exception);
        return ResultUtils.error(exception.getCode(), exception.getMessage());
    }

    /**
     * 数据校验绑定异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result validExceptionHandler(MethodArgumentNotValidException exception){
        log.info("数据校验异常：{}", exception.getMessage());
        log.info("", exception);
        return ResultUtils.error(ResultEnum.FAIL.getCode(), exception.getBindingResult().getFieldError().getDefaultMessage());
    }
}
