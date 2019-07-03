package com.sugo.service;

import com.sugo.domain.entity.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenxl on 2018/4/18.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCaseServiceTest {

    @Autowired
    private TestCaseService testCaseService ;


    @Test
    public void saveTestCase() throws Exception {
        TestCase testCase = new TestCase();
        testCase.setProjectId(1);
        testCase.setCaseName("债权发布");
        testCase.setCaseDescription("发布债权,包括个人和企业债权");
        TestCase testCase1 = testCaseService.saveTestCase(testCase);

        TestCase testCase2 = new TestCase();
        testCase2.setProjectId(1);
        testCase2.setCaseName("债权购买");
        testCase2.setCaseDescription("购买发布的个人、企业债权");
        TestCase testCase3 = testCaseService.saveTestCase(testCase2);


        assertEquals(testCase1.getCaseName(),"债权发布");
        assertEquals(testCase3.getCaseDescription(),"购买发布的个人、企业债权");

    }

    @Test
    public void getByProjectId() throws Exception {
        List<TestCase> testCaseList = testCaseService.getByProjectId(1);

    }

}