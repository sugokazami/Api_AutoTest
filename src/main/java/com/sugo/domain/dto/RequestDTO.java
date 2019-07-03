package com.sugo.domain.dto;


import lombok.Data;

import java.util.Map;

/**
 * HTTP请求类
 * Created by chenxl on 2018/4/6.
 */

@Data
public class RequestDTO {

    /**
     * API请求URL
     */
    private String url;


    /**
     * API请求方法
     */
    private String method;


    /**
     * API请求正文：params
     * application/x-www-form-urlencoded
     */
    private Map<String, Object> params;


    /**
     * API请求正文：body
     * application/json
     */
    private String body;


    /**
     * API请求头信息
     */
    private Map<String, Object> headers;

}
