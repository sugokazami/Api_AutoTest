package com.touzhijia;

import com.touzhijia.http.ApiService;
import com.touzhijia.http.RetrofitManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Response;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApiAutoApplicationTests {

    @Test
    public void testPost() {
        String json = "{\"telephone\": \"13803623948\",\"password\": \"cxl111111\",\"device\": \"pc\",\"platform\": \"touzhijia\",\"clientIP\": \"10.255.1.112\"}";
        ApiService apiService = RetrofitManager.getInstance().create("http://a.io.tzj.net/", ApiService.class);

        try {
            Response<String> response = apiService.postWithRow("user_account.svc/api/accounts", json).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
