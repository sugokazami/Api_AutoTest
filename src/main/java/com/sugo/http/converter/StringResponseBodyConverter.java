package com.sugo.http.converter;

import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;


/**
 * Created by chenxl on 2018/2/28.
 * 将响应数据解析ResponseBody成String
 */

public class StringResponseBodyConverter implements Converter<ResponseBody, String> {

    @Override
    public String convert(ResponseBody value) throws IOException {
        try {
            return value.string();
        } finally {
            value.close();
        }
    }
}