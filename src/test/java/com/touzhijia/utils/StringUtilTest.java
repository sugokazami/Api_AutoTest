package com.touzhijia.utils;

import org.junit.Test;

/**
 * Created by chenxl on 2018/3/16.
 */
public class StringUtilTest {
    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void isNotEmpty() throws Exception {
    }

    @Test
    public void getSubString() throws Exception {
        String string = "Chenxinliang" ;
        int n = StringUtils.getSubString(string, "n");
        System.out.println(n);
    }
}