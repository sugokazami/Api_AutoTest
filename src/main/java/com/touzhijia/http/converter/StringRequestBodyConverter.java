package com.touzhijia.http.converter;

/**
 * Created by chenxl on 2018/3/1.
 */

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

import java.io.IOException;
/**
 * Created by chenxl on 2018/2/28.
 * 将String类型请求数据解析成RequestBody类型
 */

public class StringRequestBodyConverter implements Converter<String, RequestBody> {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");


    @Override
    public RequestBody convert(String value) throws IOException {

        return RequestBody.create(MEDIA_TYPE, value);
    }
}
