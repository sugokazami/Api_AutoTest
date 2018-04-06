package com.touzhijia.domain.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;



import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

import javax.persistence.Transient;

import javax.persistence.Version;



import lombok.Data;



import com.touzhijia.domain.entity.Debt.RepaymentType;



@Data

@Entity

@Table(name = "loan")

public class Loan implements Serializable {



    private static final long serialVersionUID = 3216422272516920951L;



    @Id

    private String id;

    private String debtId;

    private String uid;

    private Date createAt;

    private BigDecimal rate;

    private BigDecimal amount;

    private RepaymentType repaymentType;

    private int borrowPeriod;

    private String borrowPeriodUnit;

    private String title;

    private String description;

    private String borrowerDescription;

    private boolean status;

    private String extra;

    private String warrantUid;

    private String mandataryUid;

    private BigDecimal mandataryFee;

    private LoanType loanType;

    private String relationId;

    @Version

    private Integer version;



    @Transient

    private String transferDebtId;

    @Transient

    private Long transferInvestId;

    @Transient

    private BigDecimal interestAmount;



    public enum Display {



        /**

         * -1不显示 0显示

         */

        DISPLAY(0), HIDDEN(-1);

        private int value;



        Display(int value) {

            this.value = value;

        }



        public int getValue() {

            return value;

        }

    }



    public enum LoanType {

        PERSON, COMPANY;

    }

}

