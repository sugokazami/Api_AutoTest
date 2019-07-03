package com.sugo.domain.dto;

import com.sugo.domain.entity.TestCase;
import lombok.Data;

import java.util.List;

/**
 * Created by chenxl on 2018/3/12.
 */

@Data
public class TestProjectDTO {

    private Integer projectId ;

    private String projectName ;

    private String createUser ;

    private List<TestCase> testCaseList ;

}
