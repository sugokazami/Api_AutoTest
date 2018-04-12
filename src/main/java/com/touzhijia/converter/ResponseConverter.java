package com.touzhijia.converter;

import com.touzhijia.domain.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

import java.io.IOException;

/**
 * 请求响应转换类Retrofit--Response -- > ResponseDTO
 * Created by chenxl on 2018/4/1.
 */

@Slf4j
public class ResponseConverter {

    public static ResponseDTO responseToResponseDTO(Response<String> response) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (response == null) {
            return responseDTO;
        }

        responseDTO.setCode(response.code());
        responseDTO.setMessage(response.message());

        if (response.isSuccessful()) {
            responseDTO.setBody(response.body());
        } else {
            try {
                responseDTO.setBody(response.errorBody().string());
            } catch (IOException e) {
                log.info("请求错误信息IO异常，错误信息,{}",e.getMessage());
                e.printStackTrace();
                throw new RuntimeException("请求错误信息IO异常") ;
            }
            log.info("请求错误 --- > 错误码:{},  错误信息:{}",responseDTO.getCode(),responseDTO.getBody());
        }

        return responseDTO;
    }
}
