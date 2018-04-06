package com.touzhijia.utils;

/**
 * Created by chenxl on 2018/3/13.
 */

public class StringUtil {

    /**
     * 判断字符串为空
     * @param string
     * @return
     */
    public static boolean isEmpty(String string){
        return null == string && "".equals(string) ;
    }



    /**
     * 判断字符串不为空
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string){
        return null != string || string.length() > 0 ;
    }


    /**
     * 计算字符串中某个字符出现的个数
     * @param str
     * @param key
     * @return
     */
    public static int  getSubString(String str,String key) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key, index)) != -1) {
            index = index + key.length();
            count++;
        }
        return count;
    }


}
