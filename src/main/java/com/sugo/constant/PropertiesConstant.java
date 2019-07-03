package com.sugo.constant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class PropertiesConstant implements InitializingBean {


    @Value("${end_point}")
    private String end_point ;

    @Value("${access_key}")
    private String access_key ;

    @Value("${secret_key}")
    private String secret_key ;

    @Value("${bucket_name}")
    private String bucket_name ;

    @Value("${file_path}")
    private String file_path ;


    public static String END_POINT ;

    public static String ACCESS_KEY ;

    public static String SECRET_KEY ;

    public static String BUCKET_NAME ;

    public static String FILE_PATH ;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = this.end_point ;
        ACCESS_KEY = this.access_key ;
        SECRET_KEY = this.secret_key ;
        BUCKET_NAME = this.bucket_name ;
        FILE_PATH = this.file_path ;
    }
}
