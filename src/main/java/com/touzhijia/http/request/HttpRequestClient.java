package com.touzhijia.http.request;

import com.touzhijia.domain.dto.RequestDTO;
import com.touzhijia.http.ApiService;
import com.touzhijia.http.RetrofitManager;
import com.touzhijia.utils.MapConverterUtils;
import com.touzhijia.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 请求客户端，能够处理get、post、delete、put请求
 * Created by chenxl on 2018/4/1.
 */

@Slf4j
public class HttpRequestClient {

    private static final String GET = "get";

    private static final String POST_WITH_ROW = "post with ROW";

    private static final String POST_WITH_PARAMS = "post with params";

    private static final String DELETE = "delete";

    private static final String PUT = "put";

    /**
     * 执行API请求
     *
     * @param baseUrl
     * @param request
     */
    public void execute(String baseUrl, RequestDTO request) {
        if (GET.equals(request.getMethod())) {
            if (StringUtils.isNotEmpty(request.getParam())) {
                this.executeGetWithParams(baseUrl, request);
            } else {
                this.executeGet(baseUrl, request);
            }
        } else if (POST_WITH_ROW.equals(request.getMethod())) {
            this.executePostWithRow(baseUrl, request);
        } else if (POST_WITH_PARAMS.equals(request.getMethod())) {
            this.executePostWithParams(baseUrl, request);
        } else if (DELETE.equals("delete")) {
            if (StringUtils.isNotEmpty(request.getParam())) {
                this.executeDeleteWithParams(baseUrl, request);
            } else {
                this.executeDelete(baseUrl, request);
            }
        } else if (PUT.equals("put")) {
            this.executePut(baseUrl, request);
        } else {
            log.info("未知的请求方式");
            throw new RuntimeException("未知的请求方式");
        }
    }


    /**
     * 处理get请求
     *
     * @param baseUrl
     * @param request
     */
    public void executeGet(String baseUrl, RequestDTO request) {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return;
        }

        RetrofitManager.getInstance()
                .create(baseUrl, ApiService.class)
                .get(request.getUrl());
    }


    /**
     * 处理有一个或多个参数的get请求
     *
     * @param baseUrl
     * @param request
     */
    public void executeGetWithParams(String baseUrl, RequestDTO request) {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return;
        }

        RetrofitManager.getInstance()
                .create(baseUrl, ApiService.class)
                .get(request.getUrl(), MapConverterUtils.JsonToMap(request.getParam()));
    }


    /**
     * 处理application/x-www-form-urlencoded提交的请求
     *
     * @param baseUrl
     * @param request
     */
    public void executePostWithParams(String baseUrl, RequestDTO request) {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return;
        }

        RetrofitManager.getInstance()
                .create(baseUrl, ApiService.class)
                .postWithForm(request.getUrl(), MapConverterUtils.JsonToMap(request.getParam()));
    }


    /**
     * 处理application/json提交的请求
     *
     * @param baseUrl
     * @param request
     */
    public void executePostWithRow(String baseUrl, RequestDTO request) {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return;
        }

        RetrofitManager.getInstance()
                .create(baseUrl, ApiService.class)
                .postWithRow(request.getUrl(), request.getBody());
    }


    /**
     * 处理put请求
     *
     * @param baseUrl
     * @param request
     */
    public void executePut(String baseUrl, RequestDTO request) {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return;
        }

        RetrofitManager.getInstance()
                .create(baseUrl, ApiService.class)
                .put(request.getUrl(), request.getBody());
    }


    /**
     * 处理delete请求
     *
     * @param baseUrl
     * @param request
     */
    public void executeDelete(String baseUrl, RequestDTO request) {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return;
        }

        RetrofitManager.getInstance()
                .create(baseUrl, ApiService.class)
                .delete(request.getUrl());
    }


    /**
     * 处理delete请求
     *
     * @param baseUrl
     * @param request
     */
    public void executeDeleteWithParams(String baseUrl, RequestDTO request) {
        if (StringUtils.isEmpty(baseUrl) && request == null) {
            return;
        }

        RetrofitManager.getInstance()
                .create(baseUrl, ApiService.class)
                .delete(request.getUrl(), MapConverterUtils.JsonToMap(request.getParam()));
    }
}
