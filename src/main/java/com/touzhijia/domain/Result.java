package com.touzhijia.domain;

import lombok.Data;

/**
 * Created by chenxl on 2018/3/1.
 * 请求返回统一格式
 */

@Data
public class Result<T> {

    /**
     * 响应业务状态,业务码
     */
    private Integer code ;

    /**
     * 响应消息
     */
    private String msg ;

    /**
     * 响应中的数据
     */
    private T data ;
}
