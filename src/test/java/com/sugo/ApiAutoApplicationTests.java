package com.sugo;

import com.sugo.http.ApiService;
import com.sugo.http.RetrofitManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApiAutoApplicationTests {

    @Test
    public void testPost() {
        String json = "{\"telephone\": \"13803623949\",\"password\": \"cxl111111\",\"device\": \"pc\",\"platform\": \"sugo\",\"clientIP\": \"10.255.1.112\"}";
        ApiService apiService = RetrofitManager.getInstance().create("http://a.io.tzj.net/", ApiService.class);

        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Response<String> response = apiService.postWithRow("user_account.svc/api/accounts", json, map).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
