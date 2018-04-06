package com.touzhijia.repository;

import com.touzhijia.Listener.AssertionListener;
import com.touzhijia.domain.entity.Debt;
import com.touzhijia.domain.entity.DebtBorrow;
import com.touzhijia.utils.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by chenxl on 2018/3/30.
 */

@SpringBootTest
@Listeners({AssertionListener.class})
public class DebtRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private DebtRepository debtRepository;

    @Autowired
    private DebtBorrowRepository debtBorrowRepository;

    //状态为-5的数据对比
    @Test
    public void checkByStatusAndUid() throws Exception {
//        对比单个用户的数据
//        List<Debt> debts = debtRepository.findByStatusAndCategoryIdAndUid(-5, 8, "mall-srmNCFdmxu");
//        List<DebtBorrow> debtBorrows = debtBorrowRepository.findByStatusAndTypeAndUid(-5, 8, "mall-srmNCFdmxu");
//        CheckUtils.checkDebt(debts, debtBorrows);

        //过滤debt和debt_borrow表中的符合条件的前十条数据来进行对比
        List<Debt> debts = debtRepository.findByStatusAndCategoryId(-5,8);
        List<DebtBorrow> debtBorrows = debtBorrowRepository.findByStatusAndType(-5, 8);
        CheckUtils.checkDebt(debts, debtBorrows);
    }

    //状态为6的数据对比
    @Test
    public void checkByStatusSix() throws Exception {

//        过滤debt和debt_borrow表中的符合条件的前十条数据来进行对比
        List<Debt> debts = debtRepository.findByStatusSixAndCategoryId(6,8);
        List<DebtBorrow> debtBorrows = debtBorrowRepository.findByStatusSixAndType(6, 8);

        CheckUtils.checkDebt(debts, debtBorrows);
    }

    //状态为9/10的数据对比
    @Test
    public void checkByStatusNineAndTen() throws Exception{
        List<Debt> debts = debtRepository.findByStatusTenAndCategoryId(10,8);
        List<DebtBorrow> debtBorrows = debtBorrowRepository.findByStatusNineAndType(9, 8);
        CheckUtils.checkDebt(debts, debtBorrows);
    }
}