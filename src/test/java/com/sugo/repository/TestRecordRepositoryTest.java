package com.sugo.repository;

import com.sugo.domain.entity.TestRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by chenxl on 2018/4/24.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRecordRepositoryTest {

    @Autowired
    private TestRecordRepository testRecordRepository;

    @Test
    public void save() throws Exception {
        TestRecord testRecord1 = new TestRecord();
        testRecord1.setTaskId(1);
        testRecord1.setStepName("注册");
        testRecord1.setCaseId(2);
        testRecord1.setRequestPath("user_account.svc/api/accounts");
        testRecord1.setRequestMethod("post with row");
        testRecord1.setRequestBody("{\"telephone\":\"13072758062\",\"password\":\"cxl111111\",\"device\":\"pc\",\"platform\":\"sugo\",\"clientIP\":\"10.255.1.112\"}");
        testRecord1.setNeedTransfer(true);
        testRecord1.setTransferParams("username=$.username");
        testRecord1.setNeedVerifyValue(true);
        testRecord1.setCheckString("$.username:${username}");
        testRecordRepository.save(testRecord1);


        TestRecord testRecord2 = new TestRecord();
        testRecord2.setTaskId(1);
        testRecord2.setStepName("用户登录");
        testRecord2.setCaseId(2);
        testRecord2.setRequestPath("v3/user/login");
        testRecord2.setRequestMethod("post with row");
        testRecord2.setRequestBody("{\"username\":\"${username}\",\"password\":\"cxl111111\"}");
        testRecord2.setNeedTransfer(true);
        testRecord2.setTransferParams("X-Auth-Token=$.token");
        testRecord2.setNeedVerifyValue(true);
        testRecord2.setCheckString("$.uid:${username}");
        testRecordRepository.save(testRecord2);


        TestRecord testRecord3 = new TestRecord();
        testRecord3.setTaskId(1);
        testRecord3.setStepName("理财券列表");
        testRecord3.setCaseId(2);
        testRecord3.setRequestPath("v3/account/vouchers");
        testRecord3.setRequestMethod("get");
        testRecord3.setRequestHeaders("{\"X-Auth-Token\":\"${X-Auth-Token}\"}");
        testRecord3.setNeedVerifyValue(true);
        testRecord3.setCheckString("$.totalSize=5,$.list[0].title:30元投资券,$.list[1].title:50元投资券,$.list[2].title:8元投资券,$.list[3].title:100元投资券,$.list[4].title:2%加息券");
        testRecordRepository.save(testRecord3);


    }


    @Test
    public void saveAccount() throws Exception {
        TestRecord testRecord = new TestRecord();
        testRecord.setTaskId(1);
        testRecord.setStepName("用户注册");
        testRecord.setCaseId(3);
        testRecord.setRequestPath("user_account.svc/api/accounts");
        testRecord.setRequestMethod("post with row");
        testRecord.setRequestBody("{\"telephone\":\"13072758002\",\"password\":\"cxl111111\",\"device\":\"pc\",\"platform\":\"sugo\",\"clientIP\":\"10.255.1.112\"}");
        testRecord.setNeedTransfer(true);
        testRecord.setTransferParams("username=$.username,telephone=$.telephone");
        testRecord.setNeedVerifyValue(true);
        testRecord.setCheckString("$.username:${username}");
        testRecordRepository.save(testRecord);

        TestRecord testRecord1 = new TestRecord();
        testRecord1.setTaskId(1);
        testRecord1.setStepName("投之家-开通存管账户");
        testRecord1.setCaseId(3);
        testRecord1.setRequestPath("account.deposit.svc/api/accounts");
        testRecord1.setRequestMethod("post with row");
        testRecord1.setRequestBody("{\"failUrl\": \"http://merchant.tzj.cc/borrower/client/register/record/guarantee?uid=mall-izGCGUnyQj\",\"successUrl\": \"http://merchant.tzj.cc/borrower/client/home/personal?uid=mall-izGCGUnyQj\",\"roleType\":\"1\",\"uid\": \"${username}\",\"userIp\": \"10.255.3.114\"}");
        testRecord1.setNeedTransfer(true);
        testRecord1.setTransferParams("orderId=$.orderId");
        testRecord1.setNeedVerifyValue(true);
        testRecord1.setCheckString("$.uid:${username}");
        testRecordRepository.save(testRecord1);

        TestRecord testRecord2 = new TestRecord();
        testRecord2.setTaskId(1);
        testRecord2.setStepName("发送短信");
        testRecord2.setCaseId(3);
        testRecord2.setRequestPath("ecpg/requestSMS");
        testRecord2.setRequestMethod("get");
        testRecord2.setRequestParams("{\"orderid\":\"${orderId}\",\"phone\":\"${telephone}\"}");
        testRecord2.setNeedTransfer(false);
        testRecord2.setNeedVerifyValue(false);
        testRecordRepository.save(testRecord2);

        TestRecord testRecord3 = new TestRecord();
        testRecord3.setTaskId(4);
        testRecord3.setStepName("上饶银行-开通存管账户");
        testRecord3.setCaseId(3);
        testRecord3.setRequestPath("ecpg/open/submit");
        testRecord3.setRequestMethod("post with params");
        testRecord3.setRequestParams("{\"name\":\"陈小清\",\"idNo\":\"421122199008010807\",\"exAcctNo\":\"6214850272720807\",\"encpin\":\"QnSLjFYMS79Sbkk4I6THCvelcUAHVPRhgOaJeJ2HAGTgjSrTO4xGf3QzWLKt+LLKspzH4XPT2fxe82NlLzLNNQ3qxuE5rWn7Tc5Iu1BZxRGUVWfej3tt/MQZry4Q7KNXdUy7mZOG3uRKov/4zA1DxOFw+WcfdWIHnn9WdTXu+JnCLpnfiNXEPJZ1P8iD/MfB9ixTw4bx5W81g9r1aWx/jCnkuaTc7JicSQM1u6to3BB8u055KIv1aOZ+i4LTHnfbBgrPTpg2RExLZSc+t72HtRqAZ4T3dQa2lMMpi7NMUTCRY91ymEAbL2P65/FzR87nzQxTJPsGFHchJ1fEPQxHIa6Sib6T8EOMlt/t3bfcEFIlnLbBssbK+X89XkZWgWsk+1VBx66T5UdrFpddE2rpNoo3LUXqB/he03w/rh1nD3G3jrHKfQiJYWnz0ynCamTtWR5bNXZhIFrKN6QixdsOyQ==\",\"code\":\"123456\",\"orderid\":\"${orderId}\"}");
        testRecord3.setNeedTransfer(false);
        testRecord3.setNeedVerifyValue(false);
        testRecordRepository.save(testRecord3);

    }

}