package com.touzhijia.repository;

import com.touzhijia.domain.entity.TestCase;
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
        testCase.setCaseName("债权上线");
        testCase.setProjectId(1);
        testCase.setCaseDescription("投之家债权申请-配置-审核-上线操作");
        TestCase testCase01 = testCaseRepository.save(testCase);
        System.out.println(testCase01);

        TestCase testCase02 = new TestCase();
        testCase02.setCaseName("理财券列表测试");
        testCase02.setProjectId(1);
        testCase02.setCaseDescription("注册-用户登录-理财券列表操作");
        TestCase testCase03 = testCaseRepository.save(testCase02);
        System.out.println(testCase03);
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