package com.sugo.assertion;

import com.alibaba.fastjson.JSON;
import com.sugo.domain.entity.CheckBean;
import com.sugo.domain.entity.TestRecord;
import com.sugo.function.JsonAnalysis;
import com.sugo.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * 返回值校验
 * Created by chenxl on 2018/3/16.
 */

@Slf4j
public class ResponseChecker {


    private TestRecord testRecord;

    private ArrayList<CheckBean> checkList = new ArrayList<>();

    public ResponseChecker(TestRecord testRecord) {
        this.testRecord = testRecord;
    }

    /**
     * 校验返回值
     *
     * @param checkStr 校验值
     * @param json     返回值
     * @return 校验结果
     */

    @SuppressWarnings("unchecked")
    public boolean checkValue(String checkStr, String json) {

        boolean result = false;

        if (StringUtils.isNotEmpty(json) && StringUtils.isNotEmpty(checkStr) && checkStr.contains("$.")) {

            try {
                if (checkStr.contains(">") || checkStr.contains("<") || checkStr.contains("=") || checkStr.contains(":")) {
                    if (checkStr.contains(">")) {
                        String expression = checkStr.substring(0, checkStr.indexOf(">"));
                        String checkName = expression.substring(expression.lastIndexOf(".") + 1);
                        double expectValue = Double.parseDouble(checkStr.substring(checkStr.indexOf(">") + 1, checkStr.length()));
                        double actualValue = Double.parseDouble(parse(json, expression));
                        CheckBean<Double> checkBean = null;

                        if (actualValue > expectValue) {
                            result = true;
                            checkBean = new CheckBean<>(checkName, actualValue, expectValue, "字段校验通过");
                        } else {
                            result = false;
                            checkBean = new CheckBean<>(checkName, actualValue, expectValue, "字段校验失败");
                        }
                        checkList.add(checkBean);
                    }

                    if (checkStr.contains("<")) {
                        String expression = checkStr.substring(0, checkStr.indexOf("<"));
                        String checkName = expression.substring(expression.lastIndexOf(".") + 1);
                        double expectValue = Double.parseDouble(checkStr.substring(checkStr.indexOf("<") + 1, checkStr.length()));
                        double actualValue = Double.parseDouble(parse(json, expression));
                        CheckBean<Double> checkBean = null;

                        if (actualValue < expectValue) {
                            result = true;
                            checkBean = new CheckBean<>(checkName, actualValue, expectValue, "字段校验通过");
                        } else {
                            checkBean = new CheckBean<>(checkName, actualValue, expectValue, "字段校验失败");
                            return false;
                        }
                        checkList.add(checkBean);
                    }

                    if (checkStr.contains("=")) {
                        if (!checkStr.contains("\"") && StringUtils.getSubString(checkStr, ":") < 2) {
                            String expression = checkStr.substring(0, checkStr.indexOf("="));
                            String checkName = expression.substring(expression.lastIndexOf(".") + 1);
                            double expectValue = Double.parseDouble(checkStr.substring(checkStr.indexOf("=") + 1, checkStr.length()));
                            double actualValue = Double.parseDouble(parse(json, expression));
                            CheckBean<Double> checkBean = null;

                            if (actualValue == expectValue) {
                                result = true;
                                checkBean = new CheckBean<>(checkName, actualValue, expectValue, "字段校验通过");
                                log.info("实际结果:{},期望结果:{}", actualValue, expectValue);
                            } else {
                                checkBean = new CheckBean<>(checkName, actualValue, expectValue, "字段校验失败");
                                result = false;
                                log.info("实际结果:{},期望结果:{}", actualValue, expectValue);
                            }
                            checkList.add(checkBean);
                        }
                    }

                    if (checkStr.contains(":")) {
                        String expression = checkStr.substring(0, checkStr.indexOf(":"));
                        String checkName = expression.substring(expression.lastIndexOf(".") + 1);
                        String expectValue = checkStr.substring(checkStr.indexOf(":") + 1, checkStr.length());
                        String actualValue = parse(json, expression);
                        CheckBean<Double> checkBean = null;

                        if (expectValue.equals(actualValue)) {
                            result = true;
                            checkBean = new CheckBean(checkName, actualValue, expectValue, "字段校验通过");
                            log.info("实际结果:{},期望结果:{}", actualValue, expectValue);
                        } else {
                            result = false;
                            checkBean = new CheckBean(checkName, actualValue, expectValue, "字段校验失败");
                            log.info("实际结果:{},期望结果:{}", actualValue, expectValue);
                        }
                        checkList.add(checkBean);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }
        } else {
            log.info("请求结果验证失败：期望结果为空或期望结果获取失败~~~");
            result = false;
        }
        testRecord.setCheckList(JSON.toJSONString(checkList));
        return result;
    }


    /**
     * 校验请求响应码
     *
     * @param checkCode
     * @param status
     * @return
     */
    public boolean checkCode(Integer checkCode, Integer status) {

        boolean result = false;

        if (checkCode != null && status != null) {
            if (checkCode == status) {
                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }


    public String parse(String json, String expression) {
        JsonAnalysis jsonAnalysis = new JsonAnalysis();

        return jsonAnalysis.JSONPath(json, expression) == null ? "" : jsonAnalysis.JSONPath(json, expression);
    }
}
