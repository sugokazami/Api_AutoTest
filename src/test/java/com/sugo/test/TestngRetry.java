package com.sugo.test;

import com.sun.tools.internal.jxc.ConfigReader;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**用例执行失败重试机制
 * Created by chenxl on 2018/4/10.
 */
public class TestngRetry implements IRetryAnalyzer {
    private static Logger logger = Logger.getLogger(TestngRetry.class);
    private int retryCount = 1;
    private static int maxRetryCount;
    private static ConfigReader config;

//    static {
//
//        //外围文件配置最大运行次数
//        config = new ConfigReader(TestngListener.CONFIG);
//        maxRetryCount = config.getMaxRunCount();
//        logger.info("maxRunCount=" + (maxRetryCount));
//    }

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount <= maxRetryCount) {
            String message = "running retry for '" + result.getName() + "' on class " +

                    this.getClass().getName() + " Retrying " + retryCount + " times";
            logger.info(message);
            Reporter.setCurrentTestResult(result);
            Reporter.log("RunCount=" + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }
}