package com.sugo.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by sugo on 2018/12/20.
 */
public class FileUtils {
    public static String getRootPath(String path) throws FileNotFoundException {
        //获取项目的根目录
        File root = new File(ResourceUtils.getURL("classpath:").getPath()) ;

        if (!root.exists()) {
            root = new File("") ;
        }

        //获取需要的目标目录
        if (StringUtils.isNotEmpty(path)){
            File target = new File(root.getAbsolutePath(),path);
            if (!target.exists()){
                target.mkdirs() ;
            }
            return target.getPath() ;
        }
        return null ;
    }
}
