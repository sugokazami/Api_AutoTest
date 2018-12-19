package com.touzhijia.utils;

import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.*;

/**
 * Created by sugo on 2018/12/20.
 */
public class FileUtilsTest {
    @Test
    public void testGetRootPath() throws Exception {
        String rootPath = FileUtils.getRootPath("static");
        URL url = this.getClass().getClassLoader().getResource("application.properties");
        System.out.println(url.getFile());
        System.out.println(rootPath);
    }

}