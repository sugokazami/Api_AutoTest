package com.touzhijia.utils;

import com.touzhijia.function.JsonAnalysis;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by chenxl on 2018/3/13.
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class JsonAnalysisTest {

    @Test
    public void JSONPathTest() throws Exception {
        String json = "{\n" +
                "\t\"store\": {\n" +
                "\t\t\"book\": [{\n" +
                "\t\t\t\"category\": \"reference\",\n" +
                "\t\t\t\"author\": \"NigelRees\",\n" +
                "\t\t\t\"title\": \"SayingsoftheCentury\",\n" +
                "\t\t\t\"price\": 8.95\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"category\": \"fiction\",\n" +
                "\t\t\t\"author\": \"EvelynWaugh\",\n" +
                "\t\t\t\"title\": \"SwordofHonour\",\n" +
                "\t\t\t\"price\": 12.99\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"category\": \"fiction1\",\n" +
                "\t\t\t\"author\": \"HermanMelville\",\n" +
                "\t\t\t\"title\": \"MobyDick\",\n" +
                "\t\t\t\"isbn\": \"0-553-21311-3\",\n" +
                "\t\t\t\"price\": 8.99\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"category\": \"fiction23\",\n" +
                "\t\t\t\"author\": \"32J.R.R.Tolkien\",\n" +
                "\t\t\t\"title\": \"TheLordoftheRings\",\n" +
                "\t\t\t\"isbn\": \"0-395-19395-8\",\n" +
                "\t\t\t\"price\": 22.99\n" +
                "\t\t}],\n" +
                "\t\t\"bicycle\": {\n" +
                "\t\t\t\"color\": \"red\",\n" +
                "\t\t\t\"price\": 19.95\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}" ;
        JsonAnalysis jsonAnalysis = new JsonAnalysis();
        String value = jsonAnalysis.JSONPath(null,"$.store") ;

        log.info(value);

        //assertEquals("qinshu",value);
    }

}