package com.touzhijia.http;

/**
 * 封装ApiService实体类，同一个baseUrl共用一个Retrofit实例
 * Created by chenxl on 2018/4/1.
 */


public class ApiServiceClient {
    public static ApiService getApiService(String baseUrl) {
        return RetrofitManager.getInstance().create(baseUrl, ApiService.class);
    }
}
