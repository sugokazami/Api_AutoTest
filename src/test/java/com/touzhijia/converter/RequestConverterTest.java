package com.touzhijia.converter;

import com.touzhijia.assertion.Assertion;
import com.touzhijia.domain.dto.RequestDTO;
import com.touzhijia.domain.dto.ResponseDTO;
import com.touzhijia.domain.entity.TestRecord;
import com.touzhijia.domain.entity.TestStep;
import com.touzhijia.function.ParametersFactory;
import com.touzhijia.http.HttpRequestClient;
import com.touzhijia.repository.TestRecordRepository;
import com.touzhijia.repository.TestStepRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.touzhijia.domain.entity.TestRecord.TestResult;

import java.util.List;
import java.util.Map;


/**
 * Created by chenxl on 2018/4/11.
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RequestConverterTest {
    @Autowired
    private TestStepRepository testStepRepository;

    @Autowired
    private TestRecordRepository testRecordRepository ;

    private int pass = 0;

    private int fail = 0;

//    @Test
//    public void testStepToRequestDTO() throws Exception {
//        String baseUrl = "http://a.io.tzj.net/core.bid.svc/";
//        TestStep testStep = new TestStep();
//        testStep.setStepName("担保人注册");
//        testStep.setCaseId(1);
////        testStep.setRequestPath("api/loans/${b_username}");
//        testStep.setRequestPath("api/loans");
//        testStep.setRequestMethod("post with row");
////        testStep.setRequestParams("{\"type\":\"${b_username}\",\"page\":1}");
//        testStep.setRequestBody("{\"uid\":\"${b_username}\",\"amount\":\"10\",\"borrowPeriod\":\"1\",\"borrowPeriodUnit\":\"月\"," +
//                "\"rate\":12, \"description\":\"哈哈哈\",\"loanType\":\"PERSON\",\"repaymentType\":\"ONE_TIME\"," +
//                "\"title\":\"债权申请\"" +
//                "}");
//        testStep.setNeedTransfer(true);
//        testStep.setNeedVerifyValue(true);
//        testStep.setTransferParams("loadId=$.id");
//
//
//        Map<String, String> parameterMap = ParametersFactory.getParameterMap();
//        parameterMap.put("b_username", "mall-LEnLvfiEDA");
//        RequestDTO requestDTO = RequestConverter.testStepToRequestDTO(testStep);
//        log.info(requestDTO.getUrl());
//        log.info(requestDTO.getBody());
////        log.info(requestDTO.getParams().toString());
//        HttpRequestClient requestClient = new HttpRequestClient();
//        ResponseDTO responseDTO = requestClient.execute(baseUrl, requestDTO);
//        testStep.setResponseBody(responseDTO.getBody());
//        ParametersFactory.saveCommonParam(testStep);
//        log.info(parameterMap.toString());
//
//        TestStep testStep1 = new TestStep();
//        testStep1.setRequestPath("api/debts/package");
//        testStep1.setRequestMethod("post with row");
//        testStep1.setRequestBody("{\"loanId\":\"${loadId}\",\"categoryId\":8}");
//        RequestDTO requestDT01 = RequestConverter.testStepToRequestDTO(testStep1);
//        HttpRequestClient requestClient01 = new HttpRequestClient();
//        ResponseDTO responseDTO01 = requestClient01.execute(baseUrl, requestDT01);
//        log.info(responseDTO01.toString());
//
//    }

//    @Test
//    public void testExecute() throws Exception {
//        String baseUrl = "http://a.io.tzj.net/";
//        List<TestStep> testSteps = testStepRepository.findAll();
//        for (TestStep testStep : testSteps) {
//            try {
//                RequestDTO requestDTO = RequestConverter.testStepToRequestDTO(testStep);
//                HttpRequestClient requestClient = new HttpRequestClient();
//                ResponseDTO responseDTO = requestClient.execute(baseUrl, requestDTO);
//                testStep.setResponseBody(responseDTO.getBody());
//                testStep.setTestResult(TestResult.PASS);
//            } catch (RuntimeException e) {
//                fail++;
//                log.info("测试失败:{}", testStep.getStepName());
//                testStep.setTestResult(TestResult.False);
//            }
//            testStepRepository.save(testStep);
//            ParametersFactory.saveCommonParam(testStep);
//            log.info(ParametersFactory.getParameterMap().toString());
//        }
//    }

//    @Test
//    public void testCheck01() throws Exception {
//        String baseUrl = "http://a.io.tzj.net/";
//        TestStep testStep = testStepRepository.findOne(1);
//
//        try {
//            RequestDTO requestDTO = RequestConverter.testStepToRequestDTO(testStep);
//            HttpRequestClient httpRequestClient = new HttpRequestClient();
//            ResponseDTO responseDTO = httpRequestClient.execute(baseUrl, requestDTO);
//            testStep.setResponseBody(responseDTO.getBody());
////            ResponseChecker responseChecker = new ResponseChecker();
////            boolean checkValue = responseChecker.checkValue(testStep.getCheckString(), responseDTO.getBody());
//            if (Assertion.assertEquals(testStep)) {
//                log.info("【测试成功】");
//                testStep.setTestResult(TestResult.PASS);
//                pass++;
//            } else {
//                log.info("【测试失败】");
//                testStep.setTestResult(TestResult.False);
//                fail++;
//            }
//
//        } catch (RuntimeException e) {
//            log.info("【测试失败】:{}", testStep.getStepName());
//            testStep.setTestResult(TestResult.False);
//            fail++;
//        }
//        testStepRepository.save(testStep);
//        ParametersFactory.saveCommonParam(testStep);
//        log.info(ParametersFactory.getParameterMap().toString());
//    }

//    @Test
//    public void testCheck02() throws Exception {
//        String baseUrl = "http://a.io.tzj.net/";
//        List<TestStep> testSteps = testStepRepository.findAll();
//        for (int i = 0; i < testSteps.size(); i++) {
//            try {
//                RequestDTO requestDTO = RequestConverter.testStepToRequestDTO(testSteps.get(i));
//                if(requestDTO.getUrl().startsWith("v3")){
//                    baseUrl = "http://api.tzj.net/" ;
//                }
//                HttpRequestClient httpRequestClient = new HttpRequestClient();
//                ResponseDTO responseDTO = httpRequestClient.execute(baseUrl, requestDTO);
//                testSteps.get(i).setResponseBody(responseDTO.getBody());
//                ParametersFactory.saveCommonParam(testSteps.get(i));
//                boolean result = Assertion.assertEquals(testSteps.get(i));
//                if (result) {
//                    log.info("【步骤" + (i + 1) + "测试成功】");
//                    testSteps.get(i).setTestResult(TestResult.PASS);
//                    pass++;
//                } else {
//                    log.info("【步骤" + (i + 1) + "测试失败】");
//                    testSteps.get(i).setTestResult(TestResult.False);
//                    fail++;
//                }
//
//            } catch (RuntimeException e) {
//                log.info("【步骤" + (i + 1) + "测试失败】:{}", testSteps.get(i).getStepName());
//                testSteps.get(i).setTestResult(TestResult.False);
//                pass++;
//            }
////            ParametersFactory.saveCommonParam(testSteps.get(i));
//            testStepRepository.save(testSteps.get(i));
//            Thread.sleep(1000);
//        }
//        log.info("公共参数池:{}", ParametersFactory.getParameterMap().toString());
//        log.info("成功的步骤数:{}", String.valueOf(pass));
//        log.info("失败的步骤数:{}", String.valueOf(fail));
//    }


    @Test
    public void testCheck03() throws Exception {
        String baseUrl = "http://a.io.tzj.net/";
        List<TestRecord> testRecords = testRecordRepository.findAll();
        for (int i = 0; i < testRecords.size(); i++) {
            try {
                RequestDTO requestDTO = RequestConverter.testStepToRequestDTO(testRecords.get(i));
                if(requestDTO.getUrl().startsWith("v3")){
                    baseUrl = "http://api.tzj.net/" ;
                }
                HttpRequestClient httpRequestClient = new HttpRequestClient();
                ResponseDTO responseDTO = httpRequestClient.execute(baseUrl, requestDTO);
                testRecords.get(i).setResponseBody(responseDTO.getBody());
                ParametersFactory.saveCommonParam(testRecords.get(i));
                boolean result = Assertion.assertEquals(testRecords.get(i));
                if (result) {
                    log.info("【步骤" + (i + 1) + "测试成功】");
                    testRecords.get(i).setTestResult(TestResult.PASS);
                    pass++;
                } else {
                    log.info("【步骤" + (i + 1) + "测试失败】");
                    testRecords.get(i).setTestResult(TestResult.False);
                    fail++;
                }

            } catch (RuntimeException e) {
                log.info("【步骤" + (i + 1) + "测试失败】:{}", testRecords.get(i).getStepName());
                testRecords.get(i).setTestResult(TestResult.False);
                pass++;
            }
//            ParametersFactory.saveCommonParam(testSteps.get(i));
            testRecordRepository.save(testRecords.get(i));
            Thread.sleep(1000);
        }
        log.info("公共参数池:{}", ParametersFactory.getParameterMap().toString());
        log.info("成功的步骤数:{}", String.valueOf(pass));
        log.info("失败的步骤数:{}", String.valueOf(fail));
    }
}
