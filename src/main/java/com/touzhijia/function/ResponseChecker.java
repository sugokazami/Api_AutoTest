package com.touzhijia.function;

import com.touzhijia.utils.StringUtils;

/**
 * 返回值校验
 * Created by chenxl on 2018/3/16.
 */

public class ResponseChecker {


    /**
     * 校验返回值
     *
     * @param checkStr 校验值
     * @param json     返回值
     * @return 校验结果
     */
    public boolean checkValue(String checkStr, String json) {

        boolean result = false;

        if (StringUtils.isNotEmpty(json) && StringUtils.isEmpty(checkStr)) {

            try {
                if (checkStr.contains(">") || checkStr.contains("<") || checkStr.contains("=") || checkStr.contains(":")) {
                    if (checkStr.contains(">")) {
                        String expression = checkStr.substring(0, checkStr.indexOf(">"));
                        double expectValue = Double.parseDouble(checkStr.substring(checkStr.indexOf(">") + 1, checkStr.length()));
                        double actualValue = Double.parseDouble(parse(json, expression));

                        if (actualValue > expectValue) {
                            result = true;
                        } else {
                            result = false;
                        }
                    }

                    if (checkStr.contains("<")) {
                        String expression = checkStr.substring(0, checkStr.indexOf("<"));
                        double expectValue = Double.parseDouble(checkStr.substring(checkStr.indexOf("<") + 1, checkStr.length()));
                        double actualValue = Double.parseDouble(parse(json, expression));

                        if (actualValue < expectValue) {
                            result = true;
                        } else {
                            return result;
                        }
                    }

                    if (checkStr.contains("=")) {
                        if (!checkStr.contains("\"") && StringUtils.getSubString(checkStr, ":") < 2) {
                            String expression = checkStr.substring(0, checkStr.indexOf(">"));
                            double expectValue = Double.parseDouble(checkStr.substring(checkStr.indexOf(">") + 1, checkStr.length()));
                            double actualValue = Double.parseDouble(parse(json, expression));

                            if (actualValue == expectValue) {
                                result = true;
                            } else {
                                result = false;
                            }
                        }
                    }

                    if (checkStr.contains(":")) {
                        String expression = checkStr.substring(0, checkStr.indexOf(">"));
                        String expectValue = checkStr.substring(checkStr.indexOf(">") + 1, checkStr.length());
                        String actualValue = parse(json, expression);

                        if (actualValue.equals(expectValue)) {
                            result = true;
                        } else {
                            result = false;
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }
        }
        return result;
    }


    /**
     * 校验请求响应码
     * @param checkCode
     * @param status
     * @return
     */
    public boolean checkCode(Integer checkCode, Integer status) {

        boolean result = false ;

        if (checkCode !=null && status != null){
            if (checkCode == status){
                result = true ;
            }else {
                result = false ;
            }
        }

        return result;
    }


    public String parse(String json, String expression) {
        JsonAnalysis jsonAnalysis = new JsonAnalysis();
        String parse;
        if (json.contains("$.")) {
            parse = jsonAnalysis.JSONPath(json, expression);
            return parse;
        } else {
            return json;
        }
    }
}
