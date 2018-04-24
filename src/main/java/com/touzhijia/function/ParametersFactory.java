package com.touzhijia.function;

import com.touzhijia.domain.entity.TestRecord;
import com.touzhijia.domain.entity.TestStep;
import com.touzhijia.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从请求返回的Body信息中提取参数，并替换
 * Created by chenxl on 2018/3/13.
 */

@Slf4j
public class ParametersFactory {

    /**
     * 全局公共参数池
     */
    private static Map<String, String> parameterMap = new HashMap<>();


    /**
     * 替换符号，如果请求数据中包含"${}",则会用公共参数中的数据来替换
     */
    private static Pattern replaceParamPattern = Pattern.compile("\\$\\{(.*?)\\}");


    /**
     * 从请求返回的body信息中提取参数
     *
     * @param testRecord 测试步骤
     */
    public static void saveCommonParam(TestRecord testRecord) throws IOException {

        if (testRecord != null) {
            //获得需要提取参数的表达式
            String transferParams = testRecord.getTransferParams();
            String responseBody = testRecord.getResponseBody();
            if (transferParams != null && responseBody != null) {
                String[] paramList = transferParams.split(",");
                //从请求信息中提取相应的参数
                for (int i = 0; i < paramList.length; i++) {
                    String param = paramList[i];
                    if (param.contains("=")) {
                        String key = param.substring(0, param.indexOf("=")).trim();
                        String expression = param.substring(param.indexOf("=") + 1, param.length()).trim();
                        //通过表达式提取具体参数的值
                        JsonAnalysis jsonAnalysis = new JsonAnalysis();
                        String value = jsonAnalysis.JSONPath(responseBody, expression);
                        setParameterMap(key, value);
                    }
                }
            }
        }
    }

    /**
     * 在执行过程中如果判断含有占位符，则会将该值替换为公共参数里面的值
     *
     * @param param 替换符
     * @return
     */
    public static String replaceCommonParam(String param) {
        if (StringUtils.isEmpty(param)) {
            return "";
        }

        Matcher matcher = replaceParamPattern.matcher(param);

        while (matcher.find()) {
            String replaceKey = matcher.group(1);
            String value = getCommonParam(replaceKey);
            param = param.replace(matcher.group(), value);
        }

        return param;
    }


    /**
     * 获取公共参数池中的参数值
     *
     * @param key
     * @return
     */
    public static String getCommonParam(String key) {
        if (StringUtils.isNotEmpty(key) && getParameterMap().containsKey(key)) {
            return getParameterMap().get(key) == null ? "" : getParameterMap().get(key);
        }
        return "";
    }

    /**
     * 获取公共参数池
     *
     * @return
     */
    public static Map<String, String> getParameterMap() {
        return parameterMap;
    }

    /**
     * 将提取的参数存储到公共参数池中
     *
     * @param key
     * @param value
     */
    public static void setParameterMap(String key, String value) {
        parameterMap.put(key, value);
    }
}
