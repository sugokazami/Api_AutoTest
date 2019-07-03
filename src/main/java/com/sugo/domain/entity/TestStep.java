package com.sugo.domain.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chenxl on 2018/3/1.
 */

@Entity
@Data
@Table(name = "test_step")
@DynamicInsert
@DynamicUpdate
public class TestStep extends InterfaceInfo implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 测试步骤编号
     */
    private Integer stepId;

    /**
     * 测试步骤名称
     */
    private String stepName;

    /**
     * 测试用例编号
     */
    private Integer caseId;
}
