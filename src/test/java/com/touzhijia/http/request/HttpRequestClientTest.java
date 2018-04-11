package com.touzhijia.http.request;

import com.touzhijia.domain.dto.RequestDTO;
import com.touzhijia.domain.dto.ResponseDTO;
import com.touzhijia.http.HttpRequestClient;
import com.touzhijia.utils.MapConverterUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by chenxl on 2018/4/1.
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class HttpRequestClientTest {
    @Test
    public void executeGet() throws Exception {
        HttpRequestClient httpRequestClient = new HttpRequestClient();
        String baseUrl = "https://api.douban.com/";
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setUrl("v2/book/1220562");
        requestDTO.setMethod("get");
//        ResponseDTO responseDTO = httpRequestClient.executeGet(baseUrl, requestDTO);
        ResponseDTO responseDTO = httpRequestClient.execute(baseUrl, requestDTO);
        log.info(responseDTO.getBody());
    }

    @Test
    public void executeGetWithParams() throws Exception {
        HttpRequestClient httpRequestClient = new HttpRequestClient();
        String baseUrl = "https://www.apiopen.top/";
        String param = "{\"type\":1,\"page\":1}";
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setUrl("satinGodApi");
        requestDTO.setMethod("get");
        requestDTO.setParams(MapConverterUtils.JsonToMap(param));
//        ResponseDTO responseDTO = httpRequestClient.executeGetWithParams(baseUrl, requestDTO);
        ResponseDTO responseDTO = httpRequestClient.execute(baseUrl, requestDTO);
        log.info(responseDTO.getBody());
    }

    @Test
    public void executePostWithRow() throws Exception {
        HttpRequestClient httpRequestClient = new HttpRequestClient();
        String baseUrl = "http://a.io.tzj.net/";
        String json = "{\"telephone\": \"13803623954\",\"password\": \"cxl111111\",\"device\": \"pc\",\"platform\": \"touzhijia\",\"clientIP\": \"10.255.1.112\"}";
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setUrl("user_account.svc/api/accounts");
        requestDTO.setBody(json);
        requestDTO.setMethod("post with row");
        ResponseDTO responseDTO = httpRequestClient.execute(baseUrl, requestDTO);
        log.info(responseDTO.getBody());
    }

//    @Test
//    public void executePostWithParams() throws Exception {
//        HttpRequestClient httpRequestClient = new HttpRequestClient();
//        String baseUrl = "http://a.io.tzj.net/";
//        String json = "{\"telephone\": \"13803623954\",\"password\": \"cxl111111\",\"device\": \"pc\",\"platform\": \"touzhijia\",\"clientIP\": \"10.255.1.112\"}";
//        RequestDTO requestDTO = new RequestDTO();
//        requestDTO.setUrl("user_account.svc/api/accounts");
//        requestDTO.setBody(json);
//        requestDTO.setMethod("post with row");
//        ResponseDTO responseDTO = httpRequestClient.execute(baseUrl, requestDTO);
//        log.info(responseDTO.getBody());
//    }

    @Test
    public void executePutWithRowAndError() throws Exception {
        HttpRequestClient httpRequestClient = new HttpRequestClient();
        String baseUrl = "http://a.io.tzj.net/core.bid.svc/";
        String json = "{" +
                "\"operator\":\"sytem\"," +
                "\"description\":\"test\"" +
                "}";
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setUrl("api/debts/20180413582/online");
        requestDTO.setBody(json);
        requestDTO.setMethod("put");
        httpRequestClient.execute(baseUrl, requestDTO);
    }
}