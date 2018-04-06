package com.touzhijia.utils;

import static com.touzhijia.common.utils.BigDecimalUtil.divide;

import java.math.BigDecimal;

import java.util.Date;

import java.util.HashMap;

import java.util.Map;


import com.touzhijia.domain.entity.Debt.RepaymentType;

import com.touzhijia.common.utils.DateUtil;


public class InterestUtil {


    public static final String PERIOD_UNIT_DAY = "天";

    public static final int BORROW_YEAR_DAYS = 365;

    public static final int BORROW_YEAR_MONTHS = 12;


    public InterestUtil() {

    }


    public static BigDecimal calcInterest(BigDecimal amount, BigDecimal rate, int period, String periodUnit, RepaymentType repaymentType, int scale) {

        BigDecimal interest;

        if (periodUnit.equals("天")) {

            interest = amount.multiply(rate).multiply(new BigDecimal(period)).divide((new BigDecimal(BORROW_YEAR_DAYS)).multiply(new BigDecimal(100)), scale <= 0 ? 2 : scale, BigDecimal.ROUND_HALF_UP);

        } else {

            interest = repaymentType != RepaymentType.EQUAL_PI ? amount.multiply(rate).multiply(new BigDecimal(period)).divide((new BigDecimal(BORROW_YEAR_MONTHS)).multiply(new BigDecimal(100)), 2, 4) :

                    interestEqualMonth(rate, amount, period).multiply(new BigDecimal(period)).subtract(amount);

        }


        return interest;

    }


    public static BigDecimal interestMonth(BigDecimal rate, BigDecimal amount) {

        return amount.multiply(rate).divide((new BigDecimal(12)).multiply(new BigDecimal(100)), 2, 4);

    }


    /**
     * 等额本息还款 （每月还款额=贷款本金×[月利率×（1+月利率）^还款月数]÷[（1+月利率）^还款月数—1]）
     *
     * @param rate
     * @param amount
     * @param period
     * @return
     */

    public static BigDecimal interestEqualMonth(BigDecimal rate, BigDecimal amount, int period) {

        double monthRate = rate.doubleValue() / (BORROW_YEAR_MONTHS * 100);

        return divide(amount.multiply((new BigDecimal(monthRate)).multiply(new BigDecimal(Math.pow(1 + monthRate, period)))),

                (new BigDecimal(Math.pow(1 + monthRate, period))).subtract(new BigDecimal(1)));

    }


    /**
     * 等额本息计算(每月所还利息,Mr(1+r)^(n-1)÷[(1+r)^N-1])
     *
     * @param rate
     * @param amount
     * @return
     */

    public static BigDecimal interestMonth(BigDecimal rate, BigDecimal amount, int period, int certainPeriod) {

        double monthRate = rate.doubleValue() / (BORROW_YEAR_MONTHS * 100);

        return interestEqualMonth(rate, amount, period).subtract(

                divide(amount.multiply(new BigDecimal(monthRate)

                        .multiply(new BigDecimal(Math.pow((1 + monthRate),

                                certainPeriod - 1)))), new BigDecimal(

                        Math.pow((1 + monthRate), period))

                        .subtract(new BigDecimal(1))));

    }


    public static Map<Integer, BigDecimal> interestEvery(BigDecimal borrowRate, int borrowPeriod, BigDecimal amount) {

        Map<Integer, BigDecimal> map = new HashMap<Integer, BigDecimal>();

        BigDecimal interest = interestMonth(borrowRate, amount);


        for (int i = 1; i < borrowPeriod; ++i) {

            map.put(Integer.valueOf(i), interest);

        }


        map.put(Integer.valueOf(borrowPeriod), amount.add(interest));

        return map;

    }


    public static Date getRepayAt(String unit, int period, int repaymentWay) {

        Date date = new Date();

        Date repayAt = null;

        if (!unit.equals("天") && repaymentWay != 0) {

            repayAt = DateUtil.addMonth(date, Integer.valueOf(1));

        } else {

            repayAt = unit.equals("天") ? DateUtil.addDay(date, Integer.valueOf(period)) : DateUtil.addMonth(date, Integer.valueOf(period));

        }


        return repayAt;

    }


    public static BigDecimal serviceFee(BigDecimal amount, BigDecimal rate, int period, String periodUnit, RepaymentType repaymentType, BigDecimal scale) {

        if (PERIOD_UNIT_DAY.equals(periodUnit)) {

            return amount.multiply(new BigDecimal(period)).multiply(rate).multiply(scale).divide(new BigDecimal(BORROW_YEAR_DAYS).multiply(new BigDecimal(100)), 2, BigDecimal.ROUND_HALF_UP);

        }


        if (repaymentType == RepaymentType.EQUAL_PI) {

            return calcInterest(amount, rate, period, periodUnit, repaymentType, 2).multiply(scale).setScale(2, BigDecimal.ROUND_HALF_UP);

        }


        return amount.multiply(new BigDecimal(period)).multiply(rate).multiply(scale).divide(new BigDecimal(BORROW_YEAR_MONTHS).multiply(new BigDecimal(100)), 2, BigDecimal.ROUND_HALF_UP);

    }


    public static BigDecimal rateCalc(BigDecimal amount, BigDecimal interest, int period, String periodUnit) {

        if (PERIOD_UNIT_DAY.equals(period)) {

            return interest.multiply(new BigDecimal(BORROW_YEAR_DAYS))

                    .multiply(new BigDecimal(100)).

                            divide(amount.multiply(new BigDecimal(period)), 2, BigDecimal.ROUND_DOWN);

        }


        return interest.multiply(new BigDecimal(BORROW_YEAR_MONTHS))

                .multiply(new BigDecimal(100)).

                        divide(amount.multiply(new BigDecimal(period)), 2, BigDecimal.ROUND_DOWN);

    }


//    public static void main(String[] args) {

////    	System.out.println(calcInterest(new BigDecimal(600000), new BigDecimal(9.56), 3, "月", 2));

//    	System.out.println(serviceFee(new BigDecimal(600000), new BigDecimal(12.75), 3, "月", 2, new BigDecimal(0.15)));

//	}

}