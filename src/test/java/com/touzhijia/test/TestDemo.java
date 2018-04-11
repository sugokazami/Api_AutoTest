package com.touzhijia.test;

import com.touzhijia.utils.Assertion;
import org.testng.annotations.Listeners;
import com.touzhijia.Listeners.AssertionListener ;
import org.testng.annotations.Test;

/**
 * Created by chenxl on 2018/4/1.
 */

@Listeners({AssertionListener.class})
public class TestDemo {
    @Test
    public void testAssert3(){
        Assertion.assertEquals(2, 3, "比较两个数是否相等：");
        Assertion.assertEquals(1, 2, "比较两个数是否相等：");
    }

    @Test
    public void testAssert4(){
        Assertion.assertEquals(4, 3, "比较两个数是否相等：");
        Assertion.assertEquals(2, 2, "比较两个数是否相等：");
    }
}
