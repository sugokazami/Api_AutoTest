package com.touzhijia.http;

import com.touzhijia.converter.ResponseConverter;
import com.touzhijia.domain.dto.RequestDTO;
import com.touzhijia.domain.dto.ResponseDTO;
import com.touzhijia.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

import java.io.IOException;

/**
 * 请求客户端，能够处理get、post、delete、put请求
 * Created by chenxl on 2018/4/1.
 */

@Slf4j
public class HttpRequestClient {

    private static final String GET = "get";

    private static final String POST_WITH_ROW = "post with row";

    private static final String POST_WITH_PARAMS = "post with params";

    private static final String DELETE = "delete";

    private static final String PUT = "put";

    /**
     * 执行API请求
     *
     * @param baseUrl
     * @param request
     */
    public ResponseDTO execute(String baseUrl, RequestDTO request) {
        ResponseDTO responseDTO;
        try {
            if (GET.equals(request.getMethod())) {
                if (request.getParams().size() > 0) {
                    responseDTO = this.executeGetWithParams(baseUrl, request);
                } else {
                    responseDTO = this.executeGet(baseUrl, request);
                }
            } else if (POST_WITH_ROW.equals(request.getMethod())) {
                responseDTO = this.executePostWithRow(baseUrl, request);
            } else if (POST_WITH_PARAMS.equals(request.getMethod())) {
                responseDTO = this.executePostWithParams(baseUrl, request);
            } else if (DELETE.equals(request.getMethod())) {
                if (request.getParams() != null) {
                    responseDTO = this.executeDeleteWithParams(baseUrl, request);
                } else {
                    responseDTO = this.executeDelete(baseUrl, request);
                }
            } else if (PUT.equals(request.getMethod())) {
                responseDTO = this.executePut(baseUrl, request);
            } else {
                log.info("未知的请求方式");
                throw new RuntimeException("未知的请求方式");
            }

        } catch (IOException e) {
//            log.info("请求执行异常,请求路径:{},请求方法:{},异常信息:{}", request.getUrl(), request.getMethod(), e.getMessage());
//            e.printStackTrace();
            throw new RuntimeException("请求执行异常");
        }

        return responseDTO;
    }


    /**
     * 处理get请求
     *
     * @param baseUrl
     * @param request
     */
    public ResponseDTO executeGet(String baseUrl, RequestDTO request) throws IOException {

        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return null;
        }

        Response<String> response = ApiServiceClient.getApiService(baseUrl)
                .get(request.getUrl(), request.getHeaders())
                .execute();

        return ResponseConverter.responseToResponseDTO(response);
    }


    /**
     * 处理有一个或多个参数的get请求
     *
     * @param baseUrl
     * @param request
     */
    public ResponseDTO executeGetWithParams(String baseUrl, RequestDTO request) throws IOException {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return null;
        }

        Response<String> response = ApiServiceClient.getApiService(baseUrl)
                .get(request.getUrl(), request.getParams(), request.getHeaders())
                .execute();

        return this.converter(response);
    }


    /**
     * 处理application/x-www-form-urlencoded提交的请求
     *
     * @param baseUrl
     * @param request
     */
    public ResponseDTO executePostWithParams(String baseUrl, RequestDTO request) throws IOException {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return null;
        }

        Response<String> response = ApiServiceClient.getApiService(baseUrl)
                .postWithForm(request.getUrl(), request.getParams(), request.getHeaders())
                .execute();

        return this.converter(response);
    }


    /**
     * 处理application/json提交的请求
     *
     * @param baseUrl
     * @param request
     */
    public ResponseDTO executePostWithRow(String baseUrl, RequestDTO request) throws IOException {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return null;
        }

        Response<String> response = ApiServiceClient.getApiService(baseUrl)
                .postWithRow(request.getUrl(), request.getBody(), request.getHeaders())
                .execute();

        return this.converter(response);

    }


    /**
     * 处理put请求
     *
     * @param baseUrl
     * @param request
     */
    public ResponseDTO executePut(String baseUrl, RequestDTO request) throws IOException {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return null;
        }

        Response<String> response = ApiServiceClient.getApiService(baseUrl)
                .put(request.getUrl(), request.getBody(), request.getHeaders())
                .execute();

        return this.converter(response);
    }


    /**
     * 处理delete请求
     *
     * @param baseUrl
     * @param request
     */
    public ResponseDTO executeDelete(String baseUrl, RequestDTO request) throws IOException {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return null;
        }

        Response<String> response = ApiServiceClient.getApiService(baseUrl)
                .delete(request.getUrl(), request.getHeaders())
                .execute();

        return this.converter(response);
    }


    /**
     * 处理delete请求
     *
     * @param baseUrl
     * @param request
     */
    public ResponseDTO executeDeleteWithParams(String baseUrl, RequestDTO request) throws IOException {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return null;
        }

        Response<String> response = ApiServiceClient.getApiService(baseUrl)
                .delete(request.getUrl(), request.getParams(), request.getHeaders())
                .execute();

        return this.converter(response);
    }


    /**
     * 将Response转换为ResponseDTO
     *
     * @param response
     * @return
     */
    public ResponseDTO converter(Response<String> response) {
        return ResponseConverter.responseToResponseDTO(response);
    }
}
