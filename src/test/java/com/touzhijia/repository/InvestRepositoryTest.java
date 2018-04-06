package com.touzhijia.repository;

import com.touzhijia.Listener.AssertionListener;
import com.touzhijia.domain.entity.Invest;
import com.touzhijia.domain.entity.InvestRecord;
import com.touzhijia.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


/**
 * Created by chenxl on 2018/3/31.
 */


@SpringBootTest
@Listeners({AssertionListener.class})
public class InvestRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private InvestRepository investRepository ;

    @Autowired
    private  InvestRecordRepository investRecordRepository ;


    @Test
    public void checkInvestWithStatusEqualsTwo() throws Exception {
        //20180330185
        String debtId = "20180330185" ;
        List<Invest> invests = investRepository.findByDebtId(debtId);
        List<InvestRecord> investRecords = investRecordRepository.findByDebtId(debtId);
        CheckUtils.checkInvest(invests,investRecords);
    }

    @Test
    public void checkInvestWithTransferredStatusEqualsThree() throws Exception {
        String debtId = "20180121844" ;
        List<Invest> invests = investRepository.findByRelationIdOrderByCreateAtDesc(debtId);
        List<InvestRecord> investRecords = investRecordRepository.findByDebtIdOrderByCreateAtDesc(debtId);
        CheckUtils.checkInvest(invests,investRecords);
    }

    @Test
    public void checkInvestWithTransfer() throws Exception {
        //T2018032900042(我想要的收益为0，还款中，状态为2)
        //T2018032900014(我想要的收益不为0 ，流标，状态为-1)
        //T2018032900046(我想要的收益不为0，还款中，状态为2)
        String debtId = "T2018032900046" ;
        List<Invest> invests = investRepository.findByRelationId(debtId);
        List<InvestRecord> investRecords = investRecordRepository.findByDebtId(debtId);
        CheckUtils.checkInvest(invests,investRecords);
    }

    @Test
    public void checkInvestId() throws Exception {
        String id = "941460" ;
        Invest invest = investRepository.findOne(id);
        InvestRecord investRecord = investRecordRepository.findOne(Long.parseLong(id));
        List<Invest> invests = Arrays.asList(invest);
        List<InvestRecord> investRecords = Arrays.asList(investRecord);
        CheckUtils.checkInvest(invests,investRecords);
        System.out.println(Invest.InvestChannel.AUTO.ordinal());
    }


}