package com.touzhijia.domain.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenxl on 2018/3/7.
 * 测试任务实体类
 */

@Entity
@Data
@Table(name = "test_task")
@DynamicUpdate
@DynamicInsert
public class TestTask implements Serializable {

    public static final long serialVersionUID = 1L ;

    /**
     * 测试任务编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId ;


    /**
     * 测试任务名称
     */
    private String taskName ;


    /**
     * 测试用例编号
     */
    private Integer caseId ;


    /**
     * 测试任务状态
     */
    private Integer taskStatus ;


    /**
     * 主机域名或IP地址+端口号
     */
    private String BasicUrl ;


    /**
     * 是否设置定时任务
     */
    private Integer isSetTimeTask ;


    /**
     * 定时任务的状态
     */
    private Integer setTimeTaskStatus;


    /**
     * 定时任务开始时间
     */
    private Date startTime ;


    /**
     * 测试任务耗时
     */
    private String runTime ;


    /**
     * 测试用例通过数量
     */
    private Integer pass ;


    /**
     * 测试用例失败数量
     */
    private Integer fail ;

    /**
     * 测试用例总数
     */
    private Integer sum ;

    /**
     * 测试用例通过率
     */
    private Integer passRate ;


    /**
     * 测试任务创建人
     */
    private String createUser ;


    /**
     * 创建时间
     */
    private Date createTime ;

    /**
     * 更新时间
     */
    private Date updateTime ;

}
