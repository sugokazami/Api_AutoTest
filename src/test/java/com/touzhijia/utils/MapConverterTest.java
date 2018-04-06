package com.touzhijia.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


/**
 * Created by chenxl on 2018/4/6.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MapConverterTest {

    @Test
    public void JsonToMap(){
        String jsonStr = "{\"telephone\": \"13803623948\",\"password\": \"cxl111111\",\"device\": \"pc\",\"platform\": \"touzhijia\",\"clientIP\": \"10.255.1.112\"}" ;
        Map<String, Object> map = MapConverterUtils.JsonToMap(jsonStr);
        System.out.println(map.get("password"));
    }

}