package com.touzhijia.utils;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Map<String,Object>转换工具类
 * Created by chenxl on 2018/4/1.
 */
public class MapConverterUtils {

    private static final Logger logger = LoggerFactory.getLogger(MapConverterUtils.class);


    public static Map<String, Object> JsonToMap(String jsonStr) {
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        if (StringUtils.isNotEmpty(jsonStr)) {
            try {
                map = gson.fromJson(jsonStr, map.getClass());
            } catch (Exception e) {
                logger.info("把Json字符串转换成Map出错", e);
                return map;
            }
        } else {
            return map;
        }
        return map;
    }

}
