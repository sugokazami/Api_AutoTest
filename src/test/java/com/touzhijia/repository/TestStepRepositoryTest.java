package com.touzhijia.repository;

import com.touzhijia.domain.entity.TestStep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by chenxl on 2018/3/8.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestStepRepositoryTest {


    @Autowired
    private TestStepRepository testStepRepository ;

    @Test
    public void saveTestCase(){
        TestStep testStep = new TestStep();
        testStep.setStepName("担保人注册");
        testStep.setCaseId(1);
        testStep.setRequestPath("api/loans");
        testStep.setRequestMethod("post with row");
        testStep.setResponseBody("{\n" +
                "    \"uid\":\"${b_username}\",\n" +
                "    \"amount\":\"5000\",\n" +
                "    \"borrowPeriod\":\"1\",\n" +
                "    \"borrowPeriodUnit\":\"月\",\n" +
                "    \"rate\":12,\n" +
                "    \"description\":\"哈哈哈\",\n" +
                "    \"loanType\":\"PERSON\",\n" +
                "    \"repaymentType\":\"ONE_TIME\",\n" +
                "    \"title\":\"债权申请\"\n" +
                "}");
        testStep.setNeedTransfer(1);
        testStep.setNeedVerifyValue(1);
        testStepRepository.save(testStep) ;
    }

    @Test
    public void getByCaseId() throws Exception {

    }

}