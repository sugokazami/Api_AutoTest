package com.sugo.domain.dto;

import lombok.Data;

/**响应类
 * Created by chenxl on 2018/4/6.
 */

@Data
public class ResponseDTO {

    /**
     * 请求响应码
     */
    private Integer code ;

    /**
     * 请求响应体
     */
    private String body ;

    /**
     * 请求响应信息
     */
    private String message ;

    /**
     * 需要转递的参数
     */
    private String transferParams;

}
