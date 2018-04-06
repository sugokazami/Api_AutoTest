package com.touzhijia.domain.entity;

/**
 * Created by chenxl on 2018/4/1.
 */

import java.math.BigDecimal;

import java.util.Date;


import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import javax.persistence.Transient;

import javax.persistence.Version;


import lombok.Data;


import com.touzhijia.domain.entity.Debt.RepaymentType;

import com.touzhijia.utils.InterestUtil;


/**
 * 转让记录实体
 * Created by chenpi on 2017年11月3日
 */

@Data
@Entity
@Table(name = "transfer")
public class Transfer {


    @Id
    private String id;

    private String uid;

    private String debtId;

    private String relationId;

    private String investId;

    private BigDecimal investAmount;

    private BigDecimal transferAmount;

    private BigDecimal transferPrice;

    private Integer transferPart;

    private BigDecimal balanceAmount;

    private BigDecimal pricePerPart;

    private int balancePart;

    private int status;

    private BigDecimal rate;

    private Integer period;

    private String periodUnit;

    private Date expireAt;

    private String title;

    private BigDecimal fee;

    private String tradeNo;

    private String redemptionId;

    private String comment;

    private Date createAt;

    private Date updateAt;

    private String specifiedBuyUid;

    @Version

    private int version;

    @Transient

    private BigDecimal onceTransferFee = BigDecimal.ZERO; //针对转让部分成交，单次投资转让的手续费

    @Transient

    private BigDecimal perInterest; //万份收益

    @Transient

    private BigDecimal originalFee; //原始手续费


    public BigDecimal getPerInterest() {

        return InterestUtil.calcInterest(new BigDecimal(10000), rate, period, periodUnit, RepaymentType.ONE_TIME, 8);

    }


    public enum TransferStatus {

        /**
         * 0申请初始化（待签约）3投资中 9已还清 10已还款确认  -5撤销
         */

        INIT(0), SELLING(3), PAID(9), PAID_CONFIRM(10), UNDO(-5);

        private int value;


        TransferStatus(Integer value) {

            this.value = value;

        }


        public Integer getValue() {

            return value;

        }

    }

}
