package com.touzhijia.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Entity
@Data
@Table(catalog = "debt", name = "debt_borrow")
public class DebtBorrow implements Serializable {

    private static final long serialVersionUID = -5377866302672303881L;

    @Id
    private String id;
    @Column(name = "user_name")
    private String uid;
    @Column(name = "borrow_amount")
    private BigDecimal amount;
    private BigDecimal repayAmount;
    private BigDecimal repayCapitalAmount;
    private BigDecimal repayInterestAmount;
    private BigDecimal awaitAmount;
    private BigDecimal awaitCapitalAmount;
    private BigDecimal awaitInterestAmount;
    private BigDecimal awaitInterestAddAmount;
    private BigDecimal awaitInterestAddVoucherAmount;
    @Column(name = "total_period")
    private Integer repayPeriod;
    private Integer alreadyRepayPeriod;

    @Column(name = "borrow_period")
    private Integer period;
    @Column(name = "borrow_period_unit")
    private String periodUnit;
    private BigDecimal rate;
    private BigDecimal rateAdd;
    private Integer repaymentWay;
    private String title;
    private String description;
    @Column(name = "project_progress")
    private Integer progress;
    private String ensurePlan;
    @Column(name = "expire_date")
    private Date expireAt;
    @Column(name = "create_date")
    private Date createAt;
    @Column(name = "min_invest_part")
    private Integer minInvestAmount;
    @Column(name = "max_invest_part")
    private BigDecimal maxInvestAmount;
    @Column(name = "balance_amount")
    private BigDecimal balance;
    @Column(name = "invest_num")
    private Integer investCount;
    @Column(name = "last_invest_date")
    private Date lastInvestAt;
    private Integer status;
    @Column(name = "calculate_interest_date")
    private Date calculateInterestAt;

    @Column(name = "borrower_description")
    private String  BorrowerDescription ;
    @Column(name = "mandatary_uid")
    private String mandataryUid;
    @Column(name = "mandatary_fee")
    private BigDecimal mandataryFee;

    @Column(name = "update_date")
    private Date updateAt;
    @Column(name = "actual_online_date")
    private Date openInvestAt;
    @Column(name = "max_buy_limit_part")
    private Integer maxBuyAmountPerUser;
    private Integer type;
    private String typeLabel;
    private Integer categoryId;

    @Version
    private Integer version;
    @Column(name = "transfer_id")
    private String transferDebtId;
    private Long transferInvestId;
    private BigDecimal transferFeeAmount;
    @Column(name = "first_borrow_id")
    private String firstDebtId;
    private Integer channel;
    private String extra;
    private Integer display;
    private String tradeNo;
    private String transferAgreementNo;
    private BigDecimal investAmount;

    //hook字段
    @Column(name = "bid_deadline")
    private Integer investPeriod;
    @Column(name = "balance_part")
    private Integer balancePart;
    @Column(name = "invest_unit")
    private Integer investUnit;
    @Column(name = "online_date")
    private Date onlineDate;
    @Column(name = "thaw_flg")
    private Integer freezeFlag;
    private String extra2;
    private BigDecimal interestAmount;

    @Transient
    private BigDecimal originalTransferFeeAmount;
    @Transient
    private BigDecimal originalRate;
    @Transient
    private String statusString;
    @Transient
    private long remainTime;
    @Transient
    private BigDecimal perInterest;
    @Transient
    private Map<String, Object> map = new HashMap<String, Object>();

    public enum DebtStatus {
        /**
         * 0待审核 1初审通过 2投标预售中 3投资中 4满标待审 5放款待审 6还款中 7逾期 8坏账 9已还清 -1初审驳回 -2流标 -3满标驳回 -4放款驳回 -5撤标
         */
        VERIFY(0), VERIFYPASS(1), PRESELL(2), SELLING(3), FULLSCALE(4), LOAN(5), REPAYMENT(6), OVERDUE(7),
        BADDEBT(8), PAID(9), VERIFYUNPASS(-1), FAILED(-2), FULLUNPASS(-3), LOANUNPASS(-4), UNDO(-5);
        private int value;

        DebtStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum DebtType {
        /**
         * 0精选 1专享 2转让 3新手 4平台
         */
        SELECTION(0), PRIVILEGE(1), TRANSFER(2), FRESH(3), PLATFORM(4);
        private int value;

        DebtType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static boolean isExist(int type) {
            DebtType[] types = DebtType.values();

            for (DebtType debtType : types) {
                if (debtType.getValue() == type) {
                    return true;
                }
            }

            return false;
        }
    }

    public static Map<Integer, String> debtTitlePrefix = new HashMap<Integer, String>();

    static {
        debtTitlePrefix.put(0, "精选P2P债权组合");
        debtTitlePrefix.put(1, "专享债权组合");
        debtTitlePrefix.put(2, "个人转让债权");
        debtTitlePrefix.put(3, "新手债权组合");
        debtTitlePrefix.put(4, "品牌债权");
        debtTitlePrefix.put(5, "移动专享债权组合");
        debtTitlePrefix.put(6, "精选P2P债权组合");
    }

    public static final String ENSURE_PLAN = "全额债权回款保障";

    public enum DebtPeriodUnit {
        DAY("天"), MONTH("月");
        private String value;

        DebtPeriodUnit(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum CancelType {
        CANCEL, FLOW;
    }

    public enum Display {
        DISPLAY(0), HIDE(-1);
        private int value;

        Display(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum DebtPrefix {
        TRANSFER("T");

        private String value;

        DebtPrefix(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static final String TRANSFER_DESCRIPTION = "为增加投资人资金的流动性，投之家特推出债权转让业务。"
            + "可购买转让债权的其中一部分 ，也可以全部购买，购买的转让债权可以再次转出。通过自动购买与预约自动续购无法购买转让债权。";

    public static Map<Integer, String> statusStr = new HashMap<Integer, String>();

    static {
        statusStr.put(DebtStatus.VERIFY.getValue(), "待审核");
        statusStr.put(DebtStatus.VERIFYPASS.getValue(), "初审通过");
        statusStr.put(DebtStatus.VERIFYUNPASS.getValue(), "初审驳回");
        statusStr.put(DebtStatus.PRESELL.getValue(), "投标预售中");
        statusStr.put(DebtStatus.SELLING.getValue(), "投资中");
        statusStr.put(DebtStatus.FAILED.getValue(), "流标");
        statusStr.put(DebtStatus.UNDO.getValue(), "撤标");
        statusStr.put(DebtStatus.FULLSCALE.getValue(), "满标待审");
        statusStr.put(DebtStatus.FULLUNPASS.getValue(), "满标驳回");
        statusStr.put(DebtStatus.LOAN.getValue(), "满标通过");
        statusStr.put(DebtStatus.REPAYMENT.getValue(), "还款中");
        statusStr.put(DebtStatus.PAID.getValue(), "已还清");
        statusStr.put(DebtStatus.OVERDUE.getValue(), "逾期");
        statusStr.put(DebtStatus.BADDEBT.getValue(), "坏账");
        statusStr.put(DebtStatus.LOANUNPASS.getValue(), "放款驳回");
    }

    public DebtBorrow(long id, BigDecimal effectInvestAmount, BigDecimal borrowAmount) {
        this.alreadyRepayPeriod = (int) id;
        this.awaitCapitalAmount = effectInvestAmount;
        this.amount = borrowAmount;
    }

    public DebtBorrow() {
        super();
    }
}
