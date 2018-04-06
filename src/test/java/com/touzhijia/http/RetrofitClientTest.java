package com.touzhijia.http;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by sugo on 2018/4/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetrofitClientTest {
    @Test
    public void testGetApiService() throws Exception {
        RetrofitClient.setBaseUrl("http://a.io.tzj/net/");
        RetrofitClient.getApiService().get("ext.bid.svc/api/notice/send") ;
    }

}