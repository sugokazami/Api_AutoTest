package com.touzhijia.exception;

import com.touzhijia.domain.enums.ResultEnum;

/**
 * Created by chenxl on 2018/3/1.
 */

public class BusinessException extends RuntimeException {

    private Integer code ;

    public BusinessException(Integer code,String message){
        super(message);
        this.code = code ;
    }

    public BusinessException(ResultEnum resultEnum){
        super(resultEnum.getMessage()) ;
        this.code = resultEnum.getCode() ;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
