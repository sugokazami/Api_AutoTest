package com.touzhijia.domain.enums;

/**
 * Created by chenxl on 2018/3/1.
 * 自定义响应数据结构
 */
public enum ResultEnum {
    SUCCESS(200, "success"),
    FAIL(500, "error"),
    USERNAME_NOT_NULL(500, "用户名不能为空"),
    USERNAME_EXISTS(500, "该用户名已注册"),
    USERNAME_NOT_EXISTS(500, "用户名不存在"),
    PASSWORD_NOT_NULL(500, "密码不能为空"),
    PASSWORD_INVALID(500, "密码不正确"),


    SYSTEM_ERROR(-1, "未知错误"),;

    private Integer code;

    private String message;

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
