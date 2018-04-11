package com.touzhijia.converter;

import com.touzhijia.domain.dto.RequestDTO;
import com.touzhijia.domain.entity.TestStep;
import com.touzhijia.utils.MapConverterUtils;

/**请求转换类
 * Created by chenxl on 2018/4/6.
 */

public class ResquestConverter {
    public static RequestDTO testStepToResquestDTO(TestStep testStep){

        RequestDTO requestDTO = new RequestDTO();

        if (testStep == null){
            return requestDTO ;
        }

        requestDTO.setUrl(testStep.getRequestPath());
        requestDTO.setMethod(testStep.getRequestMethod());
        requestDTO.setParams(MapConverterUtils.JsonToMap(testStep.getRequestParams()));

        return requestDTO ;
    }

}
