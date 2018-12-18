package com.touzhijia.constant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class PropertiesConstant implements InitializingBean {

    @Value("${file_url}")
    private String file_url;

    public static String FILE_URL ;

    @Override
    public void afterPropertiesSet() throws Exception {
        FILE_URL = this.file_url ;

    }
}
