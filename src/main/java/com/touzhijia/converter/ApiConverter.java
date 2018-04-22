package com.touzhijia.converter;

import com.touzhijia.domain.entity.ApiRecord;
import com.touzhijia.domain.entity.TestStep;

/**
 * 请求转换类 TestStep --> ApiRecord
 * Created by chenxl on 2018/4/18.
 */

public class ApiConverter {

    public static ApiRecord testStepToApiRecord(TestStep testStep) {
        ApiRecord apiRecord = new ApiRecord();
        apiRecord.setCaseId(testStep.getCaseId());
        apiRecord.setRequestPath(testStep.getRequestPath());
        apiRecord.setRequestMethod(testStep.getRequestMethod());
        apiRecord.setRequestParams(testStep.getRequestParams());
        apiRecord.setRequestBody(testStep.getRequestBody());
        apiRecord.setNeedTransfer(testStep.isNeedTransfer());
        apiRecord.setTransferParams(testStep.getTransferParams());
        apiRecord.setNeedVerifyValue(testStep.isNeedVerifyValue());
        apiRecord.setCheckString(testStep.getCheckString());

        return apiRecord;
    }
}
