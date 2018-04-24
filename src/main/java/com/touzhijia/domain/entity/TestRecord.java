package com.touzhijia.domain.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 接口请求记录表
 * Created by chenxl on 2018/4/18.
 */

@Entity
@Data
@Table(name = "test_record")
@DynamicInsert
@DynamicUpdate
public class TestRecord extends InterfaceInfo {

    /**
     * 测试任务编号
     */
    private Integer taskId;

    /**
     * 测试用例编号
     */
    private Integer caseId;

    /**
     * 测试步骤名称
     */
    private String stepName;

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
    private TestResult testResult;


    /**
     * 测试结果
     */
    public enum TestResult {
        False,
        PASS,;
    }
}
