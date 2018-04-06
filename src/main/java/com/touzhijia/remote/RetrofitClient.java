package com.touzhijia.remote;


import com.touzhijia.remote.Interceptors.LoggingInterceptor;
import com.touzhijia.remote.converter.StringConverterFactory;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenxl on 2018/2/28.
 * 获得Retrofit客户端代理
 */

@Slf4j
public class RetrofitClient {

     private static final OkHttpClient OK_HTTP_CLIENT;

     static {

         long timeout = 60L;

         List<Protocol> protocols = new ArrayList<>() ;
         protocols.add(Protocol.HTTP_1_0) ;
         protocols.add(Protocol.HTTP_2) ;

         OK_HTTP_CLIENT = new OkHttpClient.Builder()
                 .addInterceptor(new LoggingInterceptor())
                 .readTimeout(timeout, TimeUnit.SECONDS)
                 .connectTimeout(timeout,TimeUnit.SECONDS)
                 .protocols(protocols)
                 .build() ;
     }

    public static <T> T getClient(String baseUrl, Class<T> clazz){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OK_HTTP_CLIENT)
                .addConverterFactory(StringConverterFactory.create())
                .build() ;
        return retrofit.create(clazz);
    }

    public static class SingletonHolder{
        private static RetrofitClient retrofitClient = new RetrofitClient() ;
    }

    public  RetrofitClient getInstance(){
        return SingletonHolder.retrofitClient ;
    }
}
