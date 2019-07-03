package com.sugo.utils;

import org.junit.Test;

/**
 * Created by chenxl on 2018/3/16.
 */
public class StringUtilTest {
    @Test
    public void isEmpty() throws Exception {
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
    }

    @Test
    public void isNotEmpty() throws Exception {
        System.out.println(StringUtils.isNotEmpty(null));
        System.out.println(StringUtils.isNotEmpty(""));
    }

    @Test
    public void getSubString() throws Exception {
        String string = "Chenxinliang" ;
        int n = StringUtils.getSubString(string, "n");
        System.out.println(n);
    }
}