package com.touzhijia.remote.Interceptors;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by chenxl on 2018/2/28.
 */

@Slf4j
public class LoggingInterceptor implements Interceptor{

   private final Charset UTF8 = Charset.forName("UTF-8") ;

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        RequestBody requestBody = request.body();

        String body = null ;

        if (request.body() != null){
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            MediaType contentType = requestBody.contentType();
            Charset charset = null ;

            if (contentType != null){
                charset = contentType.charset(UTF8) ;
            }

            body = buffer.readString(charset) ;

        }
        log.info("---> 请求方法：{}",request.method()) ;
        log.info("---> 请求地址：{}",request.url());
        log.info("---> 请求信息：{}",body);


        Long star = System.currentTimeMillis() ;
        Response response = chain.proceed(request) ;
        Long end = System.currentTimeMillis() ;

        ResponseBody responseBody = response.body();
        String stringBody = null ;

        if (response.isSuccessful()){
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE) ;
            Buffer buffer = source.buffer();

            MediaType contentType = responseBody.contentType();
            Charset charset = null ;

            if (contentType != null){
                charset = contentType.charset(UTF8) ;
            }

            stringBody = buffer.clone().readString(charset);

        }

        log.info("<--- 响应状态：{}",response.code()) ;
        log.info("<--- 响应地址：{}",response.request().url());
        log.info("<--- 响应内容：{}",stringBody);
        log.info("<--- 响应时间：{}",(end-star)+ "毫秒");

        return response;
    }
}
