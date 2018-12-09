package com.touzhijia.domain.enums;

/**
 * Created by chenxl on 2018/3/1.
 * 自定义响应数据结构
 */
public enum ResultEnum {
    SUCCESS(200,"success"),
    FAIL(500,"error") ,
    SYSTEM_ERROR(-1,"未知错误"),

    ;

    private Integer code ;

    private String message ;

    ResultEnum(Integer code) {
        this.code = code;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
