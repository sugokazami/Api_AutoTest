package com.touzhijia.http;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by chenxl on 2018/4/1.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RetrofitManagerTest {
    @Test
    public void testGet() {
        ApiService apiService = RetrofitManager.getInstance().create("http://a.io.tzj.net/", ApiService.class);
        Map<String, Object> map = new HashMap<>();
        try {
            apiService.get("new.partner.svc/api/partner_applys/SLDyeDAYQ/verify", map).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String json = "{\"telephone\": \"13803623948\",\"password\": \"cxl111111\",\"device\": \"pc\",\"platform\": \"touzhijia\",\"clientIP\": \"10.255.1.112\"}";
        ApiService apiService = RetrofitManager.getInstance().create("http://a.io.tzj.net/", ApiService.class);

        Map<String, Object> map = new HashMap<>();
        try {
            apiService.postWithRow("user_account.svc/api/accounts", json, map).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDouBan() {
        ApiService apiService = RetrofitManager.getInstance().create("https://api.douban.com/", ApiService.class);

        Map<String, Object> map = new HashMap<>();

        try {
            apiService.get("v2/book/1220562", map).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}