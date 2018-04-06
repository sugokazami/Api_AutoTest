package com.touzhijia.test;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.io.IOException;

/**
 * Created by chenxl on 2018/3/15.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class HttpClientTest {

    @Test
    public void responseTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://api.fixer.io/latest?base=CNY";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        String content = EntityUtils.toString(httpResponse.getEntity());
        int code = httpResponse.getStatusLine().getStatusCode();
        log.info("\n响应码：{} , \n响应正文：{}", code, content);
        String except = "{\"base\":\"CNY\",\"date\":\"2018-03-14\",\"rates\":{\"AUD\":0.20034,\"BGN\":0.25046,\"BRL\":0.51536,\"CAD\":0.2048,\"CHF\":0.14988,\"CZK\":3.2587,\"DKK\":0.95395,\"EUR\":0.12806,\"GBP\":0.1135,\"HKD\":1.2419,\"HRK\":0.95312,\"HUF\":39.907,\"IDR\":2174.6,\"ILS\":0.54341,\"INR\":10.27,\"ISK\":15.764,\"JPY\":16.874,\"KRW\":168.27,\"MXN\":2.9425,\"MYR\":0.61727,\"NOK\":1.2259,\"NZD\":0.21582,\"PHP\":8.238,\"PLN\":0.53814,\"RON\":0.59708,\"RUB\":9.0274,\"SEK\":1.2967,\"SGD\":0.20737,\"THB\":4.9309,\"TRY\":0.61371,\"USD\":0.1584,\"ZAR\":1.8631}}";
        log.info("\n期望结果：{}", except);
        assertEquals(except, content);

    }

}
