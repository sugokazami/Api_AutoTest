package com.touzhijia.converter;

import com.touzhijia.domain.dto.RequestDTO;
import com.touzhijia.domain.entity.TestStep;
import com.touzhijia.function.ParametersFactory;
import com.touzhijia.utils.MapConverterUtils;
import com.touzhijia.utils.StringUtils;

/**
 * 请求转换类 TestStep --> RequestDTO
 * 在该类中处理请求参数替换
 * Created by chenxl on 2018/4/6.
 */

public class RequestConverter {

    public static RequestDTO testStepToRequestDTO(TestStep testStep) {

        RequestDTO requestDTO = new RequestDTO();

        if (testStep == null) {
            return requestDTO;
        }

        requestDTO.setMethod(testStep.getRequestMethod());

        if (StringUtils.isNotEmpty(testStep.getRequestPath()) && testStep.getRequestPath().contains("${")) {
            requestDTO.setUrl(ParametersFactory.replaceCommonParam(testStep.getRequestPath()));
        } else {
            requestDTO.setUrl(testStep.getRequestPath());
        }

        if (StringUtils.isNotEmpty(testStep.getRequestBody()) && testStep.getRequestBody().contains("${")) {
            requestDTO.setBody(ParametersFactory.replaceCommonParam(testStep.getRequestBody()));
        } else {
            requestDTO.setBody(testStep.getRequestBody());
        }

        if (StringUtils.isNotEmpty(testStep.getRequestParams()) && testStep.getRequestParams().contains(("${"))) {
            requestDTO.setParams(MapConverterUtils.JsonToMap(ParametersFactory.replaceCommonParam(testStep.getRequestParams())));
        } else {
            requestDTO.setParams(MapConverterUtils.JsonToMap(testStep.getRequestParams()));
        }

        return requestDTO;
    }

}
