package com.touzhijia.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * 接口请求记录表
 * Created by chenxl on 2018/4/18.
 */

@Data
public class ApiRecord {

    /**
     * 测试任务编号
     */
    private Integer taskId ;

    /**
     * 测试用例编号
     */
    private Integer caseId;

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
     * 保存的返回值的信息
     */
    private String responseBody;

    /**
     * 请求返回值校验记录
     */
    private String checkList;

    /**
     * 测试结果
     * 0 测试失败   1 测试成功
     */
    private TestStep.TestResult testResult;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
