package com.sugo.utils;

import com.sugo.domain.Result;
import com.sugo.domain.enums.ResultEnum;

/**
 * Created by chenxl on 2018/3/1.
 * 请求返回工具类
 */
public class ResultUtils {

    /**
     * 请求处理成功，有返回数据
     * @param object 请求返回数据对象
     * @return
     */
    public static Result success (Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }

    /**
     * 请求处理成功，没有返回数据
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 请求处理失败
     * @param code 失败返回错误码
     * @param message 失败返回错误信息
     * @return
     */
    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result ;
    }

}
