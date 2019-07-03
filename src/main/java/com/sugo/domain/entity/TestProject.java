package com.sugo.domain.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenxl on 2018/3/1.
 * 测试项目实体类
 */

@Entity
@Data
@Table(name = "test_project")
@DynamicUpdate
@DynamicInsert
public class TestProject implements Serializable{

    public static final long serialVersionUID = 1L ;

    /**
     * 测试项目编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId ;

    /**
     * 测试项目名称
     */
    private String projectName ;

    /**
     * 创建人
     */
    private String createUser ;

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 更新时间
     */
    private Date updateTime = new Date() ;

}
