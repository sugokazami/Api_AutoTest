package com.touzhijia.http;


import com.squareup.okhttp.Request;
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
    @GET("{url}")
    Call<String> get(@Path("url") String url);


    //处理有一个或多个参数的get请求
    @GET("{url}")
    Call<String> get(@Path("url") String url,
                     @QueryMap Map<String, Object> params);


    //处理application/x-www-form-urlencoded提交的请求
    @FormUrlEncoded
    @POST("{url}")
    Call<String> postWithForm(@Path("url") String url,
                              @FieldMap Map<String, Object> params);


    //处理application/json提交的请求
    @POST("{url}")
    Call<String> postWithRow(@Path("url") String url,
                             @Body String body);


    //处理put请求
    @PUT("{url}")
    Call<String> put(@Path("url") String url,
                     @Body String body);


    //处理delete请求
    @DELETE("{url}")
    Call<String> delete(@Path("url") String url);


    //处理有一个或多个参数的delete请求
    @DELETE("{url}")
    Call<String> delete(@Path("url") String url,
                        @QueryMap Map<String, Object> params);

}
