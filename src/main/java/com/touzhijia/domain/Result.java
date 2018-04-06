package com.touzhijia.domain;

import lombok.Data;

/**
 * Created by chenxl on 2018/3/1.
 * 请求返回统一格式
 */

@Data
public class Result<T> {

    private Integer code ;

    private String msg ;

    private T data ;
}
