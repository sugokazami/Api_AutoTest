package com.sugo.function;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.sugo.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 解析、分解Json
 * Created by chenxl on 2018/3/13.
 */
@Slf4j
public class JsonAnalysis {

    /**
     * @param json       json字符串
     * @param expression JsonPath表达式
     * @return
     */
    public String JSONPath(String json, String expression) {

        Object value;

        if (json != null && expression != null) {
            try {
                value = JSONPath.read(json, expression);
                return value == null ? null : value.toString();
            } catch (Exception e) {
                //JSONPath表达式不正确导致无法进行解析，比如JSONPath语法错误:集合中只有5个元素，想取得第6个元素的值，此时会报该错误 ;
                log.info("解析出错，错误信息:{}",e.getMessage());
                e.printStackTrace();
            }
        }

        return null;

    }


    /**
     * @param json   Json
     * @param parent 父节点
     * @return
     */
    public Map<String, Object> parse(Object json, String parent) {
        String jsonStr = String.valueOf(json);

        if (StringUtils.isEmpty(jsonStr)) {
            log.info("【解析异常】：json为空");
            return null;
        }

        Map<String, Object> map = new HashMap<>();

        if (jsonStr.startsWith("{") && jsonStr.endsWith("}")) {
            JSONObject jsonObject = JSON.parseObject(jsonStr);
            Set<Map.Entry<String, Object>> items = jsonObject.entrySet();

            if (items == null && items.size() < 1) {
                log.info("【解析异常】：jsonObject为空");
                return map;
            }

            parent = parent ==null || "".equals(parent) ? "" : parent + ".";

            for (Map.Entry<String, Object> item : items) {
                Map<String, Object> temp = parse(item.getValue(), parent + item.getKey());

                if (temp != null && temp.size() > 0) {
                    map.putAll(temp);
                }
            }

        } else if (jsonStr.startsWith("[") && jsonStr.endsWith("]")) {
            JSONArray jsonArray = JSON.parseArray(jsonStr);

            if (jsonArray == null || jsonArray.size() < 1) {
                log.info("【解析异常】：jsonArray为空");
                return map;
            }

            String tempParent;
            int index = 0;

            for (Object child : jsonArray.toArray()) {
                tempParent = parent == null || "".equals(parent) ? "" : parent + "[" + index + "]";
                Map<String, Object> temp = parse(child, tempParent);

                if (temp != null && temp.size() > 0) {
                    map.putAll(temp);
                }
                index++;
            }
        } else {
            if (parent != null) {
                map.put(parent, json);
            } else {
                map.put("", json);
            }
        }
        return map;
    }
}
