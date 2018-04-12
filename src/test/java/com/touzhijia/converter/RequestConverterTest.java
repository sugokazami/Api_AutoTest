package com.touzhijia.converter;

import com.touzhijia.domain.dto.RequestDTO;
import com.touzhijia.domain.dto.ResponseDTO;
import com.touzhijia.domain.entity.TestStep;
import com.touzhijia.function.ParametersFactory;
import com.touzhijia.http.ApiService;
import com.touzhijia.http.HttpRequestClient;
import com.touzhijia.http.RetrofitManager;
import com.touzhijia.repository.TestStepRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by chenxl on 2018/4/11.
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RequestConverterTest {
    @Autowired
    private TestStepRepository testStepRepository ;

    @Test
    public void testStepToRequestDTO() throws Exception {
        String baseUrl = "http://a.io.tzj.net/core.bid.svc/";
        TestStep testStep = new TestStep();
        testStep.setStepName("担保人注册");
        testStep.setCaseId(1);
//        testStep.setRequestPath("api/loans/${b_username}");
        testStep.setRequestPath("api/loans");
        testStep.setRequestMethod("post with row");
//        testStep.setRequestParams("{\"type\":\"${b_username}\",\"page\":1}");
        testStep.setRequestBody("{\"uid\":\"${b_username}\",\"amount\":\"5000\",\"borrowPeriod\":\"1\",\"borrowPeriodUnit\":\"月\"," +
                "\"rate\":12, \"description\":\"哈哈哈\",\"loanType\":\"PERSON\",\"repaymentType\":\"ONE_TIME\"," +
                "\"title\":\"债权申请\"" +
                "}");
        testStep.setNeedTransfer(1);
        testStep.setNeedVerifyValue(1);
        testStep.setTransferParams("loadId=$.id");


        Map<String, String> parameterMap = ParametersFactory.getParameterMap();
        parameterMap.put("b_username", "2ZXZTPs08");
        RequestDTO requestDTO = RequestConverter.testStepToRequestDTO(testStep);
        log.info(requestDTO.getUrl());
        log.info(requestDTO.getBody());
//        log.info(requestDTO.getParams().toString());
        HttpRequestClient requestClient = new HttpRequestClient();
        ResponseDTO responseDTO = requestClient.execute(baseUrl, requestDTO);
        testStep.setResponseBody(responseDTO.getBody());
        ParametersFactory.saveCommonParam(testStep);
        log.info(parameterMap.toString());

        TestStep testStep1 = new TestStep();
        testStep1.setRequestPath("api/debts/package");
        testStep1.setRequestMethod("post with row");
        testStep1.setRequestBody("{\"loanId\":\"${loadId}\",\"categoryId\":8}");
        RequestDTO requestDT01 = RequestConverter.testStepToRequestDTO(testStep1);
        HttpRequestClient requestClient01 = new HttpRequestClient();
        ResponseDTO responseDTO01 = requestClient01.execute(baseUrl, requestDT01);

    }

    @Test
    public void testExecute() throws Exception {
        String baseUrl = "http://a.io.tzj.net/" ;
        List<TestStep> testSteps = testStepRepository.findAll();
        for (TestStep testStep:testSteps) {
            RequestDTO requestDTO = RequestConverter.testStepToRequestDTO(testStep);
            HttpRequestClient requestClient = new HttpRequestClient();
            ResponseDTO responseDTO = requestClient.execute(baseUrl, requestDTO);
            testStep.setResponseBody(responseDTO.getBody());
            testStepRepository.save(testStep) ;
            ParametersFactory.saveCommonParam(testStep);
            System.out.println(ParametersFactory.getParameterMap());
        }

    }

}