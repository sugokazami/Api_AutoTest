package com.sugo.converter;

import com.sugo.domain.entity.TestRecord;
import com.sugo.domain.entity.TestStep;

/**
 * 请求转换类 TestStep --> TestRecord
 * Created by chenxl on 2018/4/18.
 */

public class ApiConverter {

    public static TestRecord testStepToApiRecord(TestStep testStep) {
        TestRecord testRecord = new TestRecord();
        testRecord.setCaseId(testStep.getCaseId());
        testRecord.setRequestPath(testStep.getRequestPath());
        testRecord.setRequestMethod(testStep.getRequestMethod());
        testRecord.setRequestParams(testStep.getRequestParams());
        testRecord.setRequestBody(testStep.getRequestBody());
        testRecord.setNeedTransfer(testStep.isNeedTransfer());
        testRecord.setTransferParams(testStep.getTransferParams());
        testRecord.setNeedVerifyValue(testStep.isNeedVerifyValue());
        testRecord.setCheckString(testStep.getCheckString());

        return testRecord;
    }
}
