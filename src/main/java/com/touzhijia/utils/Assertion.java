package com.touzhijia.utils;

/**
 * 断言
 * Created by chenxl on 2018/3/31.
 */
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class Assertion {

    public static boolean flag = true;

    public static List<Error> errors = new ArrayList<Error>();

    public static void assertEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }

    public static void assertEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected,message);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }

}