package com.touzhijia.http.request;

import com.touzhijia.domain.dto.RequestDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by chenxl on 2018/4/1.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class HttpRequestClientTest {
    @Test
    public void execute() throws Exception {
        HttpRequestClient httpRequestClient = new HttpRequestClient();
        String baseUrl = "https://api.douban.com/" ;
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setUrl("v2/book/1220562");
        requestDTO.setMethod("get");
        httpRequestClient.execute(baseUrl,requestDTO);
    }

    @Test
    public void executeGet() throws Exception {
    }

}