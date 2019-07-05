package com.sugo.repository;

import com.sugo.domain.entity.TestStep;
import com.sugo.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by chenxl on 2018/3/8.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestStepRepositoryTest {


    @Autowired
    private TestStepRepository testStepRepository;

    @Test
    public void saveDebt() {
//        TestStep testStep = new TestStep();
//        testStep.setStepName("借款人注册");
//        testStep.setCaseId(1);
//        testStep.setRequestPath("user_account.svc/api/accounts");
//        testStep.setRequestMethod("post with row");
//        testStep.setRequestBody("{\"telephone\":\"13373803569\",\"password\":\"cxl111111\",\"device\":\"pc\",\"platform\":\"sugo\",\"clientIP\":\"10.255.1.112\"}");
//        testStep.setNeedTransfer(true);
//        testStep.setTransferParams("b_username=$.username");
//        testStepRepository.save(testStep);


        TestStep testStep1 = new TestStep();
        testStep1.setStepId(1);
        testStep1.setStepName("申请");
        testStep1.setCaseId(1);
        testStep1.setRequestPath("core.bid.svc/api/loans");
        testStep1.setRequestMethod("post with row");
        testStep1.setRequestBody("{\"uid\":\"mall-LEnLvfiEDA\",\"amount\":\"10\",\"borrowPeriod\":\"1\",\"borrowPeriodUnit\":\"月\"," +
                "\"rate\":12, \"description\":\"哈哈哈\",\"loanType\":\"PERSON\",\"repaymentType\":\"ONE_TIME\"," +
                "\"title\":\"债权申请\"" +
                "}");
        testStep1.setNeedTransfer(true);
        testStep1.setTransferParams("loanId=$.id");
        testStep1.setNeedVerifyValue(true);
        testStep1.setCheckString("$.uid:mall-LEnLvfiEDa,$.title:债权申请,$.amount=10");
        testStepRepository.save(testStep1);


        TestStep testStep2 = new TestStep();
        testStep2.setStepId(2);
        testStep2.setStepName("配置");
        testStep2.setCaseId(1);
        testStep2.setRequestPath("core.bid.svc/api/debts/package");
        testStep2.setRequestMethod("post with row");
        testStep2.setRequestBody("{\"loanId\":\"${loanId}\",\"categoryId\":8}");
        testStep2.setNeedTransfer(true);
        testStep2.setTransferParams("debtId=$.id");
        testStep2.setNeedVerifyValue(true);
        testStep2.setCheckString("$.categoryId=8,$.amount=10,$.repayAmount=10.06");
        testStepRepository.save(testStep2);


        TestStep testStep3 = new TestStep();
        testStep3.setStepId(3);
        testStep3.setStepName("审核");
        testStep3.setCaseId(1);
        testStep3.setRequestPath("core.bid.svc/api/debts/${debtId}/verify");
        testStep3.setRequestMethod("put");
        testStep3.setRequestBody("{\"operator\":\"system\",\"description\":\"test\"}");
        testStep3.setNeedVerifyValue(true);
        testStep3.setCheckString("$.categoryLabel:天猫,$.repayInterestAmount=0.06");
        testStepRepository.save(testStep3);


        TestStep testStep4 = new TestStep();
        testStep4.setStepId(4);
        testStep4.setStepName("上线");
        testStep4.setCaseId(1);
        testStep4.setRequestPath("core.bid.svc/api/debts/${debtId}/online");
        testStep4.setRequestMethod("put");
        testStep4.setRequestBody("{\"operator\":\"system\",\"description\":\"test\"}");
        testStep4.setNeedVerifyValue(true);
        testStep4.setCheckString("$.categoryLabel:天猫,$.repayInterestAmount=0.06");
        testStepRepository.save(testStep4);
    }

    @Test
    public void saveVouchers() throws Exception {
        TestStep testStep1 = new TestStep();
        testStep1.setStepId(1);
        testStep1.setStepName("注册");
        testStep1.setCaseId(2);
        testStep1.setRequestPath("user_account.svc/api/accounts");
        testStep1.setRequestMethod("post with row");
        testStep1.setRequestBody("{\"telephone\":\"13072758002\",\"password\":\"cxl111111\",\"device\":\"pc\",\"platform\":\"sugo\",\"clientIP\":\"10.255.1.112\"}");
        testStep1.setNeedTransfer(true);
        testStep1.setTransferParams("username=$.username");
        testStep1.setNeedVerifyValue(true);
        testStep1.setCheckString("$.password:cxl111111");
        testStepRepository.save(testStep1);


        TestStep testStep2 = new TestStep();
        testStep2.setStepId(2);
        testStep2.setStepName("用户登录");
        testStep2.setCaseId(2);
        testStep2.setRequestPath("v3/user/login");
        testStep2.setRequestMethod("post with row");
        testStep2.setRequestBody("{\"username\":\"${username}\",\"password\":\"cxl111111\"}");
        testStep2.setNeedTransfer(true);
        testStep2.setTransferParams("X-Auth-Token=$.token");
        testStep2.setNeedVerifyValue(true);
        testStep2.setCheckString("$.uid:${username}");
        testStepRepository.save(testStep2);


        TestStep testStep3 = new TestStep();
        testStep3.setStepId(3);
        testStep3.setStepName("理财券列表");
        testStep3.setCaseId(2);
        testStep3.setRequestPath("v3/account/vouchers");
        testStep3.setRequestMethod("get");
        testStep3.setRequestHeaders("X-Auth-Token:${X-Auth-Token}");
        testStep3.setNeedVerifyValue(true);
        testStep3.setCheckString("$.totalSize=5,$.list[0].title:30元投资券,$.list[1].title:50元投资券,$.list[2].title:8元投资券,$.list[3].title:100元投资券,$.list[4].title:2%加息券");
        testStepRepository.save(testStep3);


        TestStep testStep4 = new TestStep();
        testStep4.setStepId(4);
        testStep4.setStepName("用户购买债权");
        testStep4.setCaseId(2);
        testStep4.setRequestPath("v3/borrows/${debtId}/invest");
        testStep4.setRequestMethod("post with row");
        testStep4.setRequestHeaders("X-Auth-Token:${X-Auth-Token}");
        testStep4.setNeedVerifyValue(true);
        testStep4.setRequestBody("{\"investPart\":${amount} ,\"voucher\": \"\"}");
        testStepRepository.save(testStep4);

    }

    @Test
    public void saveAccount() throws Exception {
        TestStep testStep1 = new TestStep();
        testStep1.setStepId(1);
        testStep1.setStepName("用户注册");
        testStep1.setCaseId(3);
        testStep1.setRequestPath("user_account.svc/api/accounts");
        testStep1.setRequestMethod("post with row");
        testStep1.setRequestBody("{\"telephone\":\"13072758002\",\"password\":\"cxl111111\",\"device\":\"pc\",\"platform\":\"sugo\",\"clientIP\":\"10.255.1.112\"}");
        testStep1.setNeedTransfer(true);
        testStep1.setTransferParams("username=$.username,telephone=$.telephone");
        testStep1.setNeedVerifyValue(true);
        testStep1.setCheckString("$.username:${username}");
        testStepRepository.save(testStep1);

        TestStep testStep2 = new TestStep();
        testStep2.setStepId(2);
        testStep2.setStepName("投之家-开通存管账户");
        testStep2.setCaseId(3);
        testStep2.setRequestPath("account.deposit.svc/api/accounts");
        testStep2.setRequestMethod("post with row");
        testStep2.setRequestBody("{\"failUrl\": \"http://merchant.tzj.cc/borrower/client/register/record/guarantee?uid=mall-izGCGUnyQj\",\"successUrl\": \"http://merchant.tzj.cc/borrower/client/home/personal?uid=mall-izGCGUnyQj\",\"roleType\":\"1\",\"uid\": \"${username}\",\"userIp\": \"10.255.3.114\"}");
        testStep2.setNeedTransfer(true);
        testStep2.setTransferParams("orderId=$.orderId");
        testStep2.setNeedVerifyValue(true);
        testStep2.setCheckString("$.uid:${username}");
        testStepRepository.save(testStep2);

        TestStep testStep3 = new TestStep();
        testStep3.setStepId(3);
        testStep3.setStepName("发送短信");
        testStep3.setCaseId(3);
        testStep3.setRequestPath("ecpg/requestSMS");
        testStep3.setRequestMethod("get");
        testStep3.setRequestParams("{\"orderid\":\"${orderId}\",\"phone\":\"${telephone}\"}");
        testStep3.setNeedTransfer(false);
        testStep3.setNeedVerifyValue(false);
        testStepRepository.save(testStep3);

        TestStep testStep4 = new TestStep();
        testStep4.setStepId(4);
        testStep4.setStepName("上饶银行-开通存管账户");
        testStep4.setCaseId(3);
        testStep4.setRequestPath("ecpg/open/submit");
        testStep4.setRequestMethod("post with params");
        testStep4.setRequestParams("{\"name\":\"陈小清\",\"idNo\":\"421122199008010807\",\"exAcctNo\":\"6214850272720807\",\"encpin\":\"QnSLjFYMS79Sbkk4I6THCvelcUAHVPRhgOaJeJ2HAGTgjSrTO4xGf3QzWLKt+LLKspzH4XPT2fxe82NlLzLNNQ3qxuE5rWn7Tc5Iu1BZxRGUVWfej3tt/MQZry4Q7KNXdUy7mZOG3uRKov/4zA1DxOFw+WcfdWIHnn9WdTXu+JnCLpnfiNXEPJZ1P8iD/MfB9ixTw4bx5W81g9r1aWx/jCnkuaTc7JicSQM1u6to3BB8u055KIv1aOZ+i4LTHnfbBgrPTpg2RExLZSc+t72HtRqAZ4T3dQa2lMMpi7NMUTCRY91ymEAbL2P65/FzR87nzQxTJPsGFHchJ1fEPQxHIa6Sib6T8EOMlt/t3bfcEFIlnLbBssbK+X89XkZWgWsk+1VBx66T5UdrFpddE2rpNoo3LUXqB/he03w/rh1nD3G3jrHKfQiJYWnz0ynCamTtWR5bNXZhIFrKN6QixdsOyQ==\",\"code\":\"123456\",\"orderid\":\"${orderId}\"}");
        testStep4.setNeedTransfer(false);
        testStep4.setNeedVerifyValue(false);
        testStepRepository.save(testStep4);

    }
}