package com.touzhijia.assertion;

import com.touzhijia.domain.entity.TestRecord;
import com.touzhijia.domain.entity.TestStep;
import com.touzhijia.function.ParametersFactory;
import com.touzhijia.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 返回值校验类
 * Created by chenxl on 2018/4/13.
 */

@Slf4j
public class Assertion {

    public static boolean assertEquals(TestRecord testRecord) {

        if (StringUtils.isEmpty(testRecord.getCheckString())) {
            // TODO: 2018/4/13
        }

        ResponseChecker checker = new ResponseChecker(testRecord);
        String[] checkStrings = testRecord.getCheckString().split(",");
        boolean result = true;
        for (int i = 0; i < checkStrings.length; i++) {
            if (checkStrings[i].contains("${")) {
                checkStrings[i] = ParametersFactory.replaceCommonParam(checkStrings[i]);
            }
            boolean checkValue = checker.checkValue(checkStrings[i], testRecord.getResponseBody());
            if (checkValue) {
                log.info("【检查点" + (i + 1) + "】验证成功");
                log.info("-------------------------------");
            } else {
                log.info("【检查点" + (i + 1) + "】验证失败");
                log.info("-------------------------------");
            }
            if (checkValue == false) {
                result = false;
            }
        }
        return result;
    }
}
