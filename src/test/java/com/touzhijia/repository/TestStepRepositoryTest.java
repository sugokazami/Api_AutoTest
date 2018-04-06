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
        testStep.setRequestPath("http://a.io.tzj.net/user_account.svc/api/accounts");
        testStep.setRequestMethod("POST");
        testStep.setRequestParams("{\n" +
                "  \"telephone\": \"13072753648\",\n" +
                "  \"password\": \"cxl111111\",\n" +
                "  \"device\": \"pc\",\n" +
                "  \"platform\": \"touzhijia\",\n" +
                "  \"clientIP\": \"10.255.1.112\"\n" +
                "}");
        testStep.setNeedTransfer(1);
        testStep.setNeedVerifyValue(1);
        testStep.setTransferParams("telephone=$.telephone");
        testStep.setVerifyCode(200);
        testStep.setCheckString("$.telephone:13072753648");
        testStepRepository.save(testStep) ;
    }

    @Test
    public void getByCaseId() throws Exception {

    }

}