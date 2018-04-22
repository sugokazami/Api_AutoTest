package com.touzhijia.domain.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import com.touzhijia.domain.entity.TestStep.TestResult ;


/**
 * Created by chenxl on 2018/3/1.
 * 测试用例实体类
 */

@Entity
@Data
@Table(name = "test_case")
@DynamicUpdate
@DynamicInsert
public class TestCase implements Serializable{

    public static final long serialVersionUID = 1L ;

    /**
     * 测试用例编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caseId ;

    /**
     * 测试用例名称
     */
    private String caseName ;


    /**
     * 所属项目名称
     */
    private Integer projectId ;


    /**
     * 测试用例描述
     */
    private String caseDescription ;


//    /**
//     * 测试结果
//     */
//    private TestResult testResult ;

    /**
     * 创建时间
     */
    private Date createTime ;

    /**
     * 更新时间
     */
    private Date updateTime ;

}
