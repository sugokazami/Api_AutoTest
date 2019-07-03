package com.sugo.domain.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by chenxl on 2018/4/24.
 */

@Data
@MappedSuperclass
public abstract class InterfaceInfo {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    /**
     * 接口请求路径
     */
    private String requestPath;

    /**
     * 接口请求方法
     */
    private String requestMethod;

    /**
     * 接口请求参数
     */
    private String requestParams;

    /**
     * 接口请求头信息
     */
    private String requestHeaders;

    /**
     * 接口请求Body
     */
    private String requestBody;

    /**
     * 是否传递返回值的参数
     * 0 不需要传递   1 需要传递
     */
    private boolean needTransfer;

    /**
     * 是否验证返回值
     * 0 不需要验证  1 需要传递
     */
    private boolean needVerifyValue;

    /**
     * 传递的参数
     */
    private String transferParams;

    /**
     * 验证返回值
     */
    private String checkString;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
