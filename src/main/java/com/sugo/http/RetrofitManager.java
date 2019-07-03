package com.sugo.http;

import com.sugo.http.Interceptors.LoggingInterceptor;
import com.sugo.http.converter.StringConverterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

/**
 * Created by chenxl on 2018/2/28.
 * 获得Retrofit实例，代理Api Service
 */

public class RetrofitManager {

    //超时时间
    private static final int DEFAULT_TIME_OUT = 20;

    private static final int DEFAULT_READ_TIME_OUT = 60;

    private OkHttpClient okHttpClient;

    private static class SingletonHolder {
        private static RetrofitManager INSTANCE = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获得OkHttpClient单例
     */
    private RetrofitManager() {
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 获得对应ApiService的实例
     *
     * @param baseUrl
     * @param serviceClass
     * @param <T>
     * @return
     */
    public <T> T create(String baseUrl, Class<T> serviceClass) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(StringConverterFactory.create())
                .build()
                .create(serviceClass);
    }
}
