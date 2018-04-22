package com.touzhijia.repository;

import com.touzhijia.domain.entity.TestCase;
import com.touzhijia.domain.entity.TestStep;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by chenxl on 2018/3/1.
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCaseRepositoryTest {


    @Autowired
    private TestCaseRepository testCaseRepository ;

    @Test
    public void testCase(){
        TestCase testCase = new TestCase();
        testCase.setCaseName("登录");
        testCase.setProjectId(1);
        testCase.setCaseDescription("完成登录操作");
        //testCase.setTestResult(0);
        TestCase save = testCaseRepository.save(testCase);
        System.out.println(save);
    }

    @Test
    public void testFind(){
        List<TestCase> testCaseLists = testCaseRepository.findAll();
        assertNotEquals(0,testCaseLists.size());
        for (TestCase testCase: testCaseLists) {
            log.info(testCase.toString());
        }
    }

    @Test
    public void testGetByProjectId(){
        List<TestCase> testCaseLists = testCaseRepository.getByProjectId(1001);
        assertNotEquals(0,testCaseLists.size());
        for (TestCase testCase: testCaseLists) {
            testCaseRepository.save(testCase) ;
        }
    }
}