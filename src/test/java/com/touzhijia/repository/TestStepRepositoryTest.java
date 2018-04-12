package com.touzhijia.repository;

import com.touzhijia.domain.entity.TestStep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenxl on 2018/3/8.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestStepRepositoryTest {


    @Autowired
    private TestStepRepository testStepRepository;

    @Test
    public void saveTestCase() {
        TestStep testStep = new TestStep();
        testStep.setStepName("借款人注册");
        testStep.setCaseId(1);
        testStep.setRequestPath("user_account.svc/api/accounts");
        testStep.setRequestMethod("post with row");
        testStep.setRequestBody("{\"telephone\":\"13073803569\",\"password\":\"cxl111111\",\"device\":\"pc\",\"platform\":\"touzhijia\",\"clientIP\":\"10.255.1.112\"}");
        testStep.setNeedTransfer(1);
        testStep.setTransferParams("b_username=$.username");
        testStepRepository.save(testStep);


        TestStep testStep1 = new TestStep();
        testStep1.setStepName("申请");
        testStep1.setCaseId(1);
        testStep1.setRequestPath("core.bid.svc/api/loans");
        testStep1.setRequestMethod("post with row");
        testStep1.setRequestBody("{\"uid\":\"${b_username}\",\"amount\":\"5000\",\"borrowPeriod\":\"1\",\"borrowPeriodUnit\":\"月\"," +
                "\"rate\":12, \"description\":\"哈哈哈\",\"loanType\":\"PERSON\",\"repaymentType\":\"ONE_TIME\"," +
                "\"title\":\"债权申请\"" +
                "}");
        testStep1.setNeedTransfer(1);
        testStep1.setTransferParams("loanId=$.id");
        testStepRepository.save(testStep1);


        TestStep testStep2 = new TestStep();
        testStep2.setStepName("配置");
        testStep2.setCaseId(1);
        testStep2.setRequestPath("core.bid.svc/api/debts/package");
        testStep2.setRequestMethod("post with row");
        testStep2.setRequestBody("{\"loanId\":\"${loanId_id}\",\"categoryId\":8}");
        testStep2.setNeedTransfer(1);
        testStep2.setTransferParams("debtId=$.id");
        testStepRepository.save(testStep2);


        TestStep testStep3 = new TestStep();
        testStep3.setStepName("审核");
        testStep3.setCaseId(1);
        testStep3.setRequestPath("/api/debts/${debtId}/verify");
        testStep3.setRequestMethod("put");
        testStep3.setRequestBody("{\"operator\":\"system\",\"description\":\"test\"}");
        testStepRepository.save(testStep3);

        TestStep testStep4 = new TestStep();
        testStep4.setStepName("上线");
        testStep4.setCaseId(1);
        testStep4.setRequestPath("api/debts/${debtId}/online");
        testStep4.setRequestMethod("put");
        testStep4.setRequestBody("{\"operator\":\"system\",\"description\":\"test\"\n}");
        testStepRepository.save(testStep4) ;
    }

    @Test
    public void getByCaseId() throws Exception {


    }

}