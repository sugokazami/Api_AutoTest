package com.touzhijia.function;

import com.touzhijia.domain.entity.TestStep;
import com.touzhijia.function.ParametersFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by chenxl on 2018/3/13.
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ParametersFactoryTest {
    @Test
    public void getParameter() throws Exception {
        String boby = "{\n" +
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

        TestStep testStep = new TestStep();
        testStep.setResponseBody(boby) ;
        testStep.setTransferParams("category = $.store.book[0].category ");
        ParametersFactory.saveCommonParam(testStep);
        Map<String, String> parameterMap = ParametersFactory.getParameterMap();
        for (String key: parameterMap.keySet()) {
            assertEquals("category",key);
            assertEquals("reference",parameterMap.get(key));
        }
    }

    @Test
    public void getParameterMap() throws Exception {

        String boby = "{\n" +
                "    \"id\": \"201803013244\",\n" +
                "    \"debtId\": 201803013244,\n" +
                "    \"uid\": \"majun\",\n" +
                "    \"createAt\": \"2018-03-13 09:54:16\",\n" +
                "    \"rate\": 12,\n" +
                "    \"amount\": 30000,\n" +
                "    \"repaymentWay\": 1,\n" +
                "    \"period\": 6,\n" +
                "    \"periodUnit\": \"月\",\n" +
                "    \"title\": null,\n" +
                "    \"description\": \"test\",\n" +
                "    \"borrowerDescription\": \"借款人以一辆别克 英朗 2012款 XT 1.6L 自动时尚版为抵，****申请短期借     （车辆信息）客户贵州人迁户成都，本地自有房产。客户为表填单位副总，电核OK。  鉴于客户稳定性良好，有一定还款能力，确认住址GPS轨迹正常，同意办理。   （个人借款尽职调查结论）\",\n" +
                "    \"status\": false,\n" +
                "    \"extra\": \"{\\\"id\\\":5656,\\\"amount\\\":873629.07,\\\"averageRate\\\":10.6884,\\\"transferRate\\\":8.01,\\\"detail\\\":[{\\\"id\\\":17293,\\\"platform\\\":\\\"投哪网\\\",\\\"title\\\":\\\"企业借款XCSJB160718160009\\\",\\\"amount\\\":373329.07,\\\"period\\\":30,\\\"rate\\\":9.6,\\\"reward\\\":0,\\\"cost\\\":0}]}\",\n" +
                "    \"mandataryUid\": null,\n" +
                "    \"mandataryFee\": null,\n" +
                "    \"loanType\": 1,\n" +
                "    \"relationId\": null,\n" +
                "    \"version\": 0,\n" +
                "    \"transferDebtId\": null,\n" +
                "    \"transferInvestId\": null,\n" +
                "    \"interestAmount\": null\n" +
                "}" ;

        TestStep testStep = new TestStep();
        testStep.setResponseBody(boby) ;
        testStep.setTransferParams("debtId = $.debtId");
        ParametersFactory.saveCommonParam(testStep);
        Map<String, String> parameterMap = ParametersFactory.getParameterMap();
        for (String key: parameterMap.keySet()) {
            System.out.println(key);
            System.out.println(parameterMap.get(key));
        }
    }

    @Test
    public void setParameterMap() throws Exception {
        ParametersFactory.setParameterMap("Hello","World");
        Map<String, String> parameterMap = ParametersFactory.getParameterMap();
        for (String key: parameterMap.keySet()) {
            System.out.println(key);
            System.out.println(parameterMap.get(key));
        }
    }

    @Test
    public void replaceCommonParam(){
        Map<String, String> parameterMap = ParametersFactory.getParameterMap();
        parameterMap.put("bug_id","20134567") ;
        parameterMap.put("telephone","13072759893") ;
        parameterMap.put("clientIP","touzhijia") ;
        String commonParam = ParametersFactory.replaceCommonParam("{\n" +
                "  \"telephone\": ${telephone},\n" +
                "  \"password\": ${bug_id},\n" +
                "  \"device\": \"pc\",\n" +
                "  \"platform\": ${clientIP},\n" +
                "  \"clientIP\": \"10.255.1.112\"\n" +
                "}");
        log.info(commonParam);
    }

    @Test
    public void parseTest(){
        String json = "{\n" +
                "\tbase: \"CNY\",\n" +
                "\tdate: \"2018-03-15\",\n" +
                "\trates: {\n" +
                "\t\tAUD: 0.20182,\n" +
                "\t\tBGN: 0.25085,\n" +
                "\t\tBRL: 0.52047,\n" +
                "\t\tCAD: 0.20554,\n" +
                "\t\tCHF: 0.14992,\t\n" +
                "\t}\n" +
                "}";

        JsonAnalysis jsonAnalysis = new JsonAnalysis() ;
        System.out.println(jsonAnalysis.parse(json,null));

    }

}