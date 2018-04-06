package com.touzhijia.domain.enums;

/**
 * Created by chenxl on 2018/3/1.
 */
public enum ResultEnum {
    SUCCESS(1,"success"),
    FAIL(0,"error") ,
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
