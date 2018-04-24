package com.touzhijia.repository;

import com.touzhijia.domain.entity.TestRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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
        testRecord1.setRequestBody("{\"telephone\":\"13072758062\",\"password\":\"cxl111111\",\"device\":\"pc\",\"platform\":\"touzhijia\",\"clientIP\":\"10.255.1.112\"}");
        testRecord1.setNeedTransfer(true);
        testRecord1.setTransferParams("username=$.username");
        testRecord1.setNeedVerifyValue(true);
        testRecord1.setCheckString("$.password:cxl111111");
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
    public void getByCaseId() throws Exception {
    }

}