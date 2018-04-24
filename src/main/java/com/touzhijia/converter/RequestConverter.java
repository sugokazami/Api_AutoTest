package com.touzhijia.converter;

import com.touzhijia.domain.dto.RequestDTO;
import com.touzhijia.domain.entity.TestRecord;
import com.touzhijia.function.ParametersFactory;
import com.touzhijia.utils.MapConverterUtils;
import com.touzhijia.utils.StringUtils;

/**
 * 请求转换类 TestRecord --> RequestDTO
 * 在该类中处理请求参数替换
 * Created by chenxl on 2018/4/6.
 */

public class RequestConverter {

    public static RequestDTO testStepToRequestDTO(TestRecord testRecord) {

        RequestDTO requestDTO = new RequestDTO();

        if (testRecord == null) {
            return requestDTO;
        }

        requestDTO.setMethod(testRecord.getRequestMethod());

        if (StringUtils.isNotEmpty(testRecord.getRequestPath()) && testRecord.getRequestPath().contains("${")) {
            requestDTO.setUrl(ParametersFactory.replaceCommonParam(testRecord.getRequestPath()));
        } else {
            requestDTO.setUrl(testRecord.getRequestPath());
        }

        if (StringUtils.isNotEmpty(testRecord.getRequestHeaders()) && testRecord.getRequestHeaders().contains("${")) {
            requestDTO.setHeaders(MapConverterUtils.JsonToMap(ParametersFactory.replaceCommonParam(testRecord.getRequestHeaders())));
        } else {
            requestDTO.setHeaders(MapConverterUtils.JsonToMap(testRecord.getRequestHeaders()));
        }

        if (StringUtils.isNotEmpty(testRecord.getRequestBody()) && testRecord.getRequestBody().contains("${")) {
            requestDTO.setBody(ParametersFactory.replaceCommonParam(testRecord.getRequestBody()));
        } else {
            requestDTO.setBody(testRecord.getRequestBody());
        }

        if (StringUtils.isNotEmpty(testRecord.getRequestParams()) && testRecord.getRequestParams().contains(("${"))) {
            requestDTO.setParams(MapConverterUtils.JsonToMap(ParametersFactory.replaceCommonParam(testRecord.getRequestParams())));
        } else {
            requestDTO.setParams(MapConverterUtils.JsonToMap(testRecord.getRequestParams()));
        }

        return requestDTO;
    }

}
