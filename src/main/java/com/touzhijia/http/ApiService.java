package com.touzhijia.http;


import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * Created by chenxl on 2018/2/28.
 * 创建Api服务服务
 * 包含Get、POST、PUT、Delete请求类型
 */


public interface ApiService {

    //path路径（包含参数）
    @GET("{url}")
    Call<String> get(@Path("url") String url) ;

    //Query中有一个或多个键值对
    @GET("{url}")
    Call<String> get(@Path("url") String url ,
                     @QueryMap Map<String,Object> params) ;

    //处理form表单提交的请求
    @FormUrlEncoded
    @POST("{url}")
    Call<String> postRow(@Path("url") String url ,
                         @FieldMap Map<String,Object> params) ;

    @POST("{url}")
    Call<String> post(@Path("url") String url ,
                      @Body String body) ;

}
