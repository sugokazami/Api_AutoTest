package com.touzhijia.domain.entity;

/**
 * Created by chenxl on 2018/3/31.
 */

import javax.persistence.*;

import com.touzhijia.domain.entity.VouchersCategory;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(catalog = "debt", name = "debt_invest_record")
public class InvestRecord {
    private static final long serialVersionUID = 49129052463689797L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "borrow_id")
    private String debtId;
    @Column(name = "user_name")
    private String uid;

    @Column(name = "invest_amount")
    private BigDecimal amount;
    private BigDecimal effectInvestAmount;
    @Column(name = "invest_date")
    private Date investAt;
    @Column(name = "invest_status")
    private Integer status;
    private BigDecimal receiveAmount;
    private BigDecimal receiveCapitalAmount;
    private BigDecimal receiveInterestAmount;
    private BigDecimal receiveInterestAddAmount;
    private BigDecimal receiveInterestAddVoucherAmount;
    private BigDecimal actualReceivedAmount;
    private BigDecimal actualReceivedCapitalAmount;
    private BigDecimal actualReceivedInterestAmount;
    private BigDecimal actualReceivedInterestAddAmount;
    private BigDecimal actualReceivedInterestAddVoucherAmount;
    private BigDecimal awaitAmount;
    private BigDecimal awaitInterestAmount;
    private BigDecimal awaitInterestAddAmount;
    private BigDecimal awaitInterestAddVoucherAmount;
    private BigDecimal awaitCapitalAmount;
    @Column(name = "received_num")
    private Integer receivedPeriod;
    private Integer totalPeriod;

    private String investIp;
    @Column(name = "update_date")
    private Date updateAt;
    @Column(name = "create_date")
    private Date createAt;
    @Column(name = "invest_complete_date")
    private Date investCompleteAt;

    private String agreementNo;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "invest_type")
    private InvestAutoType type;
    @Column(name = "invest_channel")
    private Integer channel;
    @Column(name = "transfer_borrow_id")
    private String transferDebtId;
    private String transferAgreementNo;
    private String vouchers;
    @Enumerated(value = EnumType.ORDINAL)
    private VouchersCategory.Type vouchersType;
    private BigDecimal vouchersAmount = BigDecimal.ZERO;
    private BigDecimal voucherRate = BigDecimal.ZERO;
    @Enumerated(value = EnumType.ORDINAL)
    private ContinueStatus continueInvestStatus;
    private String continueInvestPeriod;
    private String continueInvestId;
    @Column(name = "is_calc_voucher_interest")
    private Boolean calcVoucherInterestFlag = true;
    private String voucherTradeNo;
    private Boolean voucherConfirmation;
    private Integer voucherStatus = VoucherStatus.PAID.getValue();

    @Version
    private Integer version;
    private String investTradeNo;
    @Column(name = "transfer_flag")
    private Integer transferStatus;
    @Column(name = "already_interest_period")
    private Integer ownedPeriod;

    private  Integer categoryId ;

    private Integer debtCategory;
    private Integer repaymentWay;
    @Column(name = "calc_interest_date")
    private Date calcInterestAt;
    @Column(name = "last_receive_date")
    private Date lastReceiveAt;
    private String debtTitle;
    @Column(name = "debt_rate")
    private BigDecimal rate;
    @Column(name = "effect_invest_part")
    private Integer effectInvestPart;
    private String vipGrade;

    @Transient
    private Integer period;
    @Transient
    private String periodUnit;
    @Transient
    private boolean transferAbled;
    @Transient
    private List<ExecutionStrategy> strategies = new ArrayList<InvestRecord.ExecutionStrategy>();

    public enum InvestChannel {

        PC(1), AND(2), WAP(3), IOS(4);
        private int value;

        InvestChannel(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static Map<Integer, Integer> channelData = new HashMap<Integer, Integer>();

    static {
        channelData.put(InvestChannel.PC.getValue(), 1);
        channelData.put(InvestChannel.AND.getValue(), 2);
        channelData.put(InvestChannel.WAP.getValue(), 4);
        channelData.put(InvestChannel.IOS.getValue(), 8);
    }

    public enum InvestStatus {

        /**
         * 0投资中 1还款中 2已还款 3投资失败
         */
        BIDDING(0), REPAYMENT(1), PAID(2), FAILED(3);
        private int value;

        InvestStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum InvestAutoType {
        NORAML, AUTO, CONTINUE;
    }

    public enum IPlanInvestStatus {

        /**
         * 0预约 1开启 2进行中 3完成 4关闭
         */
        ORDER(0), OPEN(1), INVESTING(2), FINISHED(3), CLOSED(4);
        private int value;

        IPlanInvestStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum TransferStatus {

        /**
         * 0未转让 1转让中 2转让完成
         */
        TRANSFER_NOT(0), TRANSFERING(1), TRANSFER_SUCCESS(2);
        private int value;

        TransferStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum VoucherStatus {

        /**
         * 0未还 1已还
         */
        UNREPAY(0), PAID(1);
        private int value;

        VoucherStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum ContinueStatus {
        CLOSED, OPEN;
    }

    public enum AutoType {
        AUTO, CONTINUE;
    }

    public enum DataEnumCache {

        DATA_PC(1, 1), DATA_AND(2, 2), DATA_WAP(3, 4), DATA_IOS(4, 8);
        private Integer index;
        private Integer value;

        DataEnumCache(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public static Integer getValue(Integer index) {
            for (DataEnumCache dataEnumCache : DataEnumCache.values()) {
                if (dataEnumCache.getIndex() == index) {
                    return dataEnumCache.getValue();
                }
            }
            return null;
        }
    }

    public enum ExecutionStrategy {

        VOUCHER, PRIVILEGE, FRESH, BASE;
    }

    public static Map<InvestAutoType, String> investTypeStr = new HashMap<InvestAutoType, String>();

    static {
        investTypeStr.put(InvestAutoType.NORAML, "手动投标");
        investTypeStr.put(InvestAutoType.AUTO, "自动投标");
        investTypeStr.put(InvestAutoType.CONTINUE, "续购");
    }

    public static final int AGREEMENT_ID_LENGTH = 6;// 协议长度
    public static final String DEBT_AGREEMENTNO_PREFIX = "TZJ-SYZR-";//债权协议编号前缀
    public static final String DEBT_AGREEMENTNO_TRANSFER_PREFIX = "TZJ-ZQZR-";//转让协议编号前缀
    public static final String DEBT_AGREEMENTNO_SEPARATOR = "-";//协议间隔符

}
