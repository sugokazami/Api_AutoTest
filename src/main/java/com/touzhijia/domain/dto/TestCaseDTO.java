package com.touzhijia.domain.dto;


import com.touzhijia.domain.entity.TestStep;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxl on 2018/3/16.
 */
@Data
public class TestCaseDTO {

    /**
     * 测试用例编号
     */
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


    /**
     * 测试结果
     */
    private Integer testResult ;

    /**
     * 测试步骤
     */
    private List<TestStep> testStepList = new ArrayList<>() ;
}
