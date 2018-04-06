package com.touzhijia.domain.entity;

import java.math.BigDecimal;

import java.util.Date;

import java.util.HashMap;

import java.util.List;

import java.util.Map;


import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import javax.persistence.Transient;

import javax.persistence.Version;


import lombok.Data;


import com.touzhijia.domain.dto.DaysAheadDTO;

import com.touzhijia.domain.entity.Loan.LoanType;

import com.touzhijia.utils.InterestUtil;


@Data
@Entity
@Table(name = "debt")
public class Debt {

    @Id

    private String id;

    private String title;

    private String uid;

//    private DebtType debtType;

    private String type;

    private Integer categoryId;

    private String categoryLabel;

    private BigDecimal amount;

    private BigDecimal balanceAmount;

    private int totalPart;

    private Integer balancePart;

    private BigDecimal rate;

    private BigDecimal rateAdd = BigDecimal.ZERO;

    private Integer borrowPeriod;

    private String borrowPeriodUnit;

    private Integer repaymentType;

    private Integer status;

    private BigDecimal pricePerPart = BigDecimal.ONE;

    private BigDecimal fee = BigDecimal.ZERO;

    private Date expireAt;

    private BigDecimal minInvestAmount;

    private BigDecimal maxInvestAmount;

    private BigDecimal maxInvestAmountPerUser;

    private Date openInvestAt;

    private Integer investDurationHours;

    private Integer investProgress = 0;


    private BigDecimal repayAmount;

    private BigDecimal repayCapitalAmount;

    private BigDecimal repayInterestAmount;

    private BigDecimal repayInterestAddAmount;

    private BigDecimal awaitAmount;

    private BigDecimal awaitCapitalAmount;

    private BigDecimal awaitInterestAmount;

    private BigDecimal awaitInterestAddAmount;


    private Integer repayPeriod;

    private Integer repaidPeriod;

    private Date lastInvestAt;

    private Date calculateInterestAt;

    private String tradeNo;

    private String extra;

    private Integer channel;

    private Display display;

    private String ensurePlan;

    private String description;

    private String borrowerDescription;

    private Integer agreementCreatedFlag = 0;

    private String agreementNo;


    private Date createAt;

    private Date updateAt;

    private String tplanId;

    private String assetId;


    private String warrantUid;

    private String mandataryUid;

    private BigDecimal mandataryFee;

    private LoanType loanType;

    private Integer investNum = 0;

    @Version

    private int version;

    @Transient

    private Date lastRepayAt;

    @Transient

    private DaysAheadDTO daysAheadDTO;

    @Transient

    private Map<String, Object> map = new HashMap<String, Object>();

    @Transient

    private BigDecimal perInterest;

    @Transient

    private List<HashMap<String, BigDecimal>> receives = null; //供生成还款计划使用


//    public BigDecimal getPerInterest() {
//
//        return InterestUtil.calcInterest(new BigDecimal(10000), rate, borrowPeriod, borrowPeriodUnit, repaymentType, 8);
//
//    }


    //债权类型

    public enum DebtType {

        /**
         * 普通，专项，转让，新手，平台
         */

        NORMAL, PRIVILEGE, TRANSFER, FRESHER, PLATFORM, TPLAN;

    }


    public enum DebtStatus {

        /**
         * 0待审核 1初审通过 2投标预售中 3投资中 4满标中 5放款中 6还款中 7逾期 8坏账 9还款处理中 10已还款 11垫付还清 -1初审驳回 -2流标 -3满标驳回 -4放款驳回 -5撤标
         */

        VERIFY(0), VERIFYPASS(1), PRESELL(2), SELLING(3), FULLSCALE(4), DEALING(5), REPAYMENT(6), OVERDUE(7),

        BADDEBT(8), PAYING(9), PAID(10), BAIL_REPAY(11), REPAY_BAIL(12), VERIFYUNPASS(-1), FAILED(-2), FULLUNPASS(-3), LOANUNPASS(-4), UNDO(-5);

        private int value;


        DebtStatus(Integer value) {

            this.value = value;

        }


        public Integer getValue() {

            return value;

        }

    }


    public enum BorrowPeriodUnit {


        DAY("天"),

        MONTH("月");


        private final String borrowPeriodUnitName;


        BorrowPeriodUnit(String borrowPeriodUnitName) {

            this.borrowPeriodUnitName = borrowPeriodUnitName;

        }


        public String getValue() {

            return borrowPeriodUnitName;

        }


        public String borrowPeriodUnitName() {

            return borrowPeriodUnitName;

        }


        static public boolean isMember(String borrowPeriodUnitName) {

            BorrowPeriodUnit[] borrowPeriodUnits = BorrowPeriodUnit.values();

            for (BorrowPeriodUnit borrowPeriodUnit : borrowPeriodUnits)

                if (borrowPeriodUnit.borrowPeriodUnitName.equals(borrowPeriodUnitName)) {

                    return true;

                }

            return false;

        }

    }


    public enum RepaymentType {

        /**
         * 先息后本，一次性还本付息，等额本息
         */

        MONTHLY_INTEREST, ONE_TIME, EQUAL_PI;

    }


    public enum Display {

        /**
         * 0显示 1隐藏
         */

        DISPLAY, HIDE;

    }


    public static Map<Object, String> debtTitlePrefix = new HashMap<Object, String>();


    static {

        debtTitlePrefix.put(LoanType.PERSON, "个人");

        debtTitlePrefix.put(LoanType.COMPANY, "企业");

        debtTitlePrefix.put(DebtType.TRANSFER, "个人转让债权");

        debtTitlePrefix.put(DebtType.FRESHER, "新手");

    }

}