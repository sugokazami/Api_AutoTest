package com.touzhijia.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.touzhijia.common.utils.DateUtil;


/**
 * Created by chenxl on 2018/3/31.
 */


@Data
@Entity
@Table(name = "invest")

public class Invest {

    @Id
    private String id;

    private String uid;

    private String debtId;

    private String relationId;

    private int relationType;//1原始标的 2转让债权

    private BigDecimal amount;

    private int part;

    private BigDecimal effectedAmount;

    private Integer effectedPart;

    private int status;

    private InvestChannel channel;

    private Integer type;

    private Integer categoryId;

    private Integer repaymentType;

    private String debtTitle;

    private BigDecimal debtRate;

    private String tradeNo;


    private BigDecimal receiveAmount;

    private BigDecimal receiveCapitalAmount;

    private BigDecimal receiveInterestAmount;

    private BigDecimal receiveInterestAddAmount;

    private BigDecimal receiveInterestAddVoucherAmount;

    private BigDecimal awaitAmount;

    private BigDecimal awaitCapitalAmount;

    private BigDecimal awaitInterestAmount;

    private BigDecimal awaitInterestAddAmount;

    private BigDecimal awaitInterestAddVoucherAmount;

    private Integer receivedPeriod;

    private Integer totalPeriod;

    private BigDecimal receivedAmount;

    private BigDecimal receivedCapitalAmount;

    private BigDecimal receivedInterestAmount;

    private BigDecimal receivedInterestAddAmount;

    private BigDecimal receivedInterestAddVoucherAmount;


    private String orderId;

    private Date calcInterestAt;

    private Date lastReceiveAt;

    private Date investCompleteAt;

    private String vouchersCode;

    private VouchersCategory.Type vouchersType;

    private BigDecimal vouchersValue = BigDecimal.ZERO;

    private Boolean voucherInterestIsCalc = true;

    private BigDecimal transferVoucherFee = BigDecimal.ZERO;


    private Integer borrowPeriod;

    private String borrowPeriodUnit;

    private ContinueStatus continueInvestStatus;

    private String continueInvestPeriod;

    private String continueInvestId;

    private String agreementNo;

    private Integer agreementIsCreated;

    private Integer ownedPeriod = 0;

    private TransferFlag transferFlag;

    private int transferPart = 0;

    private String transferAgreementNo;

    private Integer transferAgreementIsCreated;

    private String vipGrade;

    private String buyId;

    private Date createAt;

    private Date updateAt;

    private boolean enableTransfer = true;//参与活动后标识使用

    @Version

    private int version;

    @Transient

    private Boolean transferAbled;

    @Transient

    private List<ExecContent> execContent = new ArrayList<ExecContent>();

    @Transient

    private List<ExecutionStrategy> strategies = new ArrayList<Invest.ExecutionStrategy>();

    @Transient

    private int leftPeriod; //剩余期限（转让时前端展示需要）


    public int getLeftPeriod() {

        if (lastReceiveAt == null || status == InvestStatus.PAID.getValue()) {

            return 0;

        }

        return DateUtil.diffDay(new Date(), lastReceiveAt);

    }


    public enum InvestStatus {


        /**
         * -1投资失败 0投资创建 1投资中 2还款中 3已还款
         */

        INVEST_DEALING(0), BIDDING(1), REPAYMENT(2), PAID(3), FAILED(-1);

        private int value;


        InvestStatus(int value) {

            this.value = value;

        }


        public int getValue() {

            return value;

        }

    }


    public enum InvestChannel {

        /**
         * 0:其他;1:PC;2:安卓;3:wap端;4:ios;5:自动;6:续购;;
         */

        OTHERS, PC, AND, WAP, IOS, AUTO, CONTINUE;

    }


    public enum TransferFlag {


        /**
         * 0:未转让;1:部分转让;2:全部转让
         */

        NOT_TRASFERRED, PART_TRANSFERRED, ALL_TRANSFERRED;

    }


    public enum RelationType {

        /**
         * 1债权关系 2转让关系
         */

        DEBT(1), TRANSFER(2);

        private int value;


        RelationType(Integer value) {

            this.value = value;

        }


        public Integer getValue() {

            return value;

        }

    }


    public enum ExecContent {

        TRADE, INVEST_TRANSFER, VOUCHERS, INVEST_DEPOSIT, INVEST_TRANSFER_DEPOSIT, FRESH;

    }


    public enum ExecutionStrategy {

        /**
         * 投资策略：券，专项，新手，交易
         */

        VOUCHER, PRIVILEGE, FRESH, BASE;

    }


    public enum ContinueStatus {

        CLOSED, OPEN;

    }


    public static Map<InvestChannel, String> investChannelStr = new HashMap<InvestChannel, String>();


    static {

        investChannelStr.put(InvestChannel.OTHERS, "手动");

        investChannelStr.put(InvestChannel.PC, "手动");

        investChannelStr.put(InvestChannel.AND, "手动");

        investChannelStr.put(InvestChannel.WAP, "手动");

        investChannelStr.put(InvestChannel.IOS, "手动");

        investChannelStr.put(InvestChannel.AUTO, "自动");

        investChannelStr.put(InvestChannel.CONTINUE, "预约");

    }

}
