package com.sugo.http;


import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by chenxl on 2018/2/28.
 * 创建Api服务
 * 包含Get、POST、PUT、Delete请求类型
 */


public interface ApiService {

    //处理get请求
    @GET
    Call<String> get(@Url String url,
                     @HeaderMap Map<String, Object> headers);


    //处理有一个或多个参数的get请求
    @GET
    Call<String> get(@Url String url,
                     @QueryMap Map<String, Object> params,
                     @HeaderMap Map<String, Object> headers);


    //处理application/x-www-form-urlencoded提交的请求
    @FormUrlEncoded
    @POST
    Call<String> postWithForm(@Url String url,
                              @FieldMap Map<String, Object> params,
                              @HeaderMap Map<String, Object> headers);


    //处理application/json提交的请求
    @POST
    Call<String> postWithRow(@Url String url,
                             @Body String body,
                             @HeaderMap Map<String, Object> headers);


    //处理put请求
    @PUT
    Call<String> put(@Url String url,
                     @Body String body,
                     @HeaderMap Map<String, Object> headers);


    //处理delete请求
    @DELETE
    Call<String> delete(@Url String url,
                        @HeaderMap Map<String, Object> headers);


    //处理有一个或多个参数的delete请求
    @DELETE
    Call<String> delete(@Url String url,
                        @QueryMap Map<String, Object> params,
                        @HeaderMap Map<String, Object> headers);

}
