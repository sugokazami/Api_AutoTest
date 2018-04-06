package com.touzhijia.utils;

import com.touzhijia.domain.entity.Debt;
import com.touzhijia.domain.entity.DebtBorrow;
import com.touzhijia.domain.entity.Invest;
import com.touzhijia.domain.entity.InvestRecord;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created by chenxl on 2018/3/31.
 */

@Slf4j
public class CheckUtil {
    //校验数据
    public static void checkDebt(List<Debt> debts, List<DebtBorrow> debtBorrows) {
        for (int i = 0; i < debts.size(); i++) {
            log.info("-----------第【" + (i + 1) + "】条数据中，bid_copy.debt和debt.debt_borrow表的对应字段进行校验-----------");
            Assertion.assertEquals(debts.get(i).getId(), debtBorrows.get(i).getId());
            log.info("[debt.id]:{},[debt_borrow.id]:{}", debts.get(i).getId(), debtBorrows.get(i).getId());

            Assertion.assertEquals(debts.get(i).getUid(), debtBorrows.get(i).getUid());
            log.info("[debt.uid]:{},[debt_borrow.user_name]:{}", debts.get(i).getUid(), debtBorrows.get(i).getUid());

            Assertion.assertEquals(debts.get(i).getAmount(), debtBorrows.get(i).getAmount());
            log.info("[debt.amount]:{},[debt_borrow.borrow_amount]:{}", debts.get(i).getAmount(), debtBorrows.get(i).getAmount());

            Assertion.assertEquals(debts.get(i).getRate(), debtBorrows.get(i).getRate());
            log.info("[debt.rate]:{},[debt_borrow.rate]:{}", debts.get(i).getRate(), debtBorrows.get(i).getRate());

            Assertion.assertEquals(debts.get(i).getRateAdd().intValue(), debtBorrows.get(i).getRateAdd().intValue());
            log.info("[debt.rate_add]:{},[debt_borrow.rate_add]:{}", debts.get(i).getRate(), debtBorrows.get(i).getRate());

            Assertion.assertEquals(Integer.valueOf(debts.get(i).getType()), debtBorrows.get(i).getType());
            log.info("[debt.type]:{},[debt_borrow.type]:{}", debts.get(i).getType(), debtBorrows.get(i).getType());

            Assertion.assertEquals(debts.get(i).getCategoryId(), debtBorrows.get(i).getCategoryId());
            log.info("[debt.category_id]:{},[debt_borrow.category_id]:{}", debts.get(i).getCategoryId(), debtBorrows.get(i).getCategoryId());

            Assertion.assertEquals(debts.get(i).getCategoryLabel(), debtBorrows.get(i).getTypeLabel());
            log.info("[debt.category_label]:{},[debt_borrow.type_label]:{}", debts.get(i).getCategoryLabel(), debtBorrows.get(i).getTypeLabel());

            Assertion.assertEquals(debts.get(i).getBalanceAmount(), debtBorrows.get(i).getBalance());
            log.info("[debt.balance_amount]:{},[debt_borrow.balance_amount]:{}", debts.get(i).getBalanceAmount(), debtBorrows.get(i).getBalance());

            //状态为6时，
            Assertion.assertEquals(debts.get(i).getBalancePart(), debtBorrows.get(i).getBalancePart(),"第【" + (i + 1) + "】条数据中，debt和debt_borrow表的balance_part字段对比");
            log.info("[debt.balance_part]:{},[debt_borrow.balance_part]:{}", debts.get(i).getBalancePart(), debtBorrows.get(i).getBalancePart());

            Assertion.assertEquals(debts.get(i).getBorrowPeriod(), debtBorrows.get(i).getPeriod());
            log.info("[debt.borrow_period]:{},[debt_borrow.borrow_period]:{}", debts.get(i).getBorrowPeriod(), debtBorrows.get(i).getPeriod());

            Assertion.assertEquals(debts.get(i).getBorrowPeriodUnit(), debtBorrows.get(i).getPeriodUnit());
            log.info("[debt.borrow_period_unit]:{},[debt_borrow.borrow_period_unit]:{}", debts.get(i).getBorrowPeriodUnit(), debtBorrows.get(i).getPeriodUnit());

            Assertion.assertEquals(debts.get(i).getRepaymentType(), debtBorrows.get(i).getRepaymentWay());
            log.info("[invest.repayment_type]:{},[debt_invest_record.repayment_way]:{}", debts.get(i).getRepaymentType(), debtBorrows.get(i).getRepaymentWay());

            Assertion.assertEquals(debts.get(i).getInvestDurationHours(), debtBorrows.get(i).getInvestPeriod());
            log.info("[debt.invest_duration_hours]:{},[debt_borrow.bid_deadline]:{}", debts.get(i).getInvestDurationHours(), debtBorrows.get(i).getInvestPeriod());

            Assertion.assertEquals(debts.get(i).getInvestProgress(), debtBorrows.get(i).getProgress());
            log.info("[debt.invest_progress]:{},[debt_borrow.project_progress]:{}", debts.get(i).getInvestProgress(), debtBorrows.get(i).getProgress());

            Assertion.assertEquals(debts.get(i).getExpireAt(), debtBorrows.get(i).getExpireAt());
            log.info("[debt.expire_at]:{},[debt_borrow.expire_at]:{}", debts.get(i).getExpireAt(), debtBorrows.get(i).getExpireAt());

            Assertion.assertEquals(debts.get(i).getMaxInvestAmount().intValue(), debtBorrows.get(i).getMaxInvestAmount().intValue());
            log.info("[debt.max_invest_amount]:{},[debt_borrow.max_invest_part]:{}", debts.get(i).getMaxInvestAmount(), debtBorrows.get(i).getMaxInvestAmount());

            Assertion.assertEquals(debts.get(i).getMaxInvestAmountPerUser().intValue(), debtBorrows.get(i).getMaxBuyAmountPerUser().intValue());
            log.info("[debt.max_invest_amount_per_user]:{},[debt_borrow.max_buy_limit_part]:{}", debts.get(i).getMaxInvestAmountPerUser(), debtBorrows.get(i).getMaxBuyAmountPerUser());

            Assertion.assertEquals(debts.get(i).getMaxInvestAmountPerUser().intValue(), debtBorrows.get(i).getMaxBuyAmountPerUser().intValue());
            log.info("[debt.max_invest_amount_per_user]:{},[debt_borrow.max_buy_limit_part]:{}", debts.get(i).getMaxInvestAmountPerUser(), debtBorrows.get(i).getMaxBuyAmountPerUser());

            Assertion.assertEquals(debts.get(i).getMinInvestAmount().intValue(), debtBorrows.get(i).getMinInvestAmount().intValue());
            log.info("[debt.min_invest_amount]:{},[debt_borrow.min_invest_part:{}]", debts.get(i).getMinInvestAmount(), debtBorrows.get(i).getMinInvestAmount());

            Assertion.assertEquals(debts.get(i).getMinInvestAmount().intValue(), debtBorrows.get(i).getMinInvestAmount().intValue());
            log.info("[debt.min_invest_amount]:{},[debt_borrow.min_invest_part:{}]", debts.get(i).getMinInvestAmount(), debtBorrows.get(i).getMinInvestAmount());

            Assertion.assertEquals(debts.get(i).getOpenInvestAt(), debtBorrows.get(i).getOnlineDate());
            log.info("[debt.open_invest_at]:{},[debt_borrow.online_date]:{}", debts.get(i).getOpenInvestAt(), debtBorrows.get(i).getOnlineDate());

            Assertion.assertEquals(debts.get(i).getTitle(), debtBorrows.get(i).getTitle());
            log.info("[debt.title]:{},[debt_borrow.title]:{}", debts.get(i).getTitle(), debtBorrows.get(i).getTitle());

            Assertion.assertEquals(debts.get(i).getDescription(), debtBorrows.get(i).getDescription());
            log.info("[debt.description]:{},[debt_borrow.description]:{}", debts.get(i).getDescription(), debtBorrows.get(i).getDescription());

            Assertion.assertEquals(debts.get(i).getBorrowerDescription(), debtBorrows.get(i).getBorrowerDescription());
            log.info("[debt.borrow.borrower_description]:{}", debts.get(i).getBorrowerDescription());
            log.info("[debt_borrow.borrower_description]:{}", debtBorrows.get(i).getBorrowerDescription());

            Assertion.assertEquals(debts.get(i).getExtra(), debtBorrows.get(i).getExtra());
            log.info("[debt.extra]:{},[debt_borrow.extra]:{}", debts.get(i).getDescription(), debtBorrows.get(i).getDescription());

            Assertion.assertEquals(debts.get(i).getChannel(), debtBorrows.get(i).getChannel());
            log.info("[debt.channel]:{},[debt_borrow.channel]:{}", debts.get(i).getDescription(), debtBorrows.get(i).getDescription());

//            Assertionion.assertEquals(debts.get(i).getDisplay(), debtBorrows.get(i).getDisplay());
//            log.info("[debt.display]:{},[debt_borrow.display]:{}", debts.get(i).getDescription(), debtBorrows.get(i).getDescription());

            Assertion.assertEquals(debts.get(i).getEnsurePlan(), debtBorrows.get(i).getEnsurePlan());
            log.info("[debt.ensure_plan]:{},[debt_borrow.ensure_plan]:{}", debts.get(i).getDescription(), debtBorrows.get(i).getDescription());

            //状态为6时有误差，需要放开
            Assertion.assertEquals(debts.get(i).getAwaitAmount(), debtBorrows.get(i).getAwaitAmount(),"第【" + (i + 1) + "】条数据中，debt和debt_borrow表的await_amount字段对比");
            log.info("[debt.await_amount]:{},[debt_borrow.await_amount]:{}", debts.get(i).getAwaitAmount(), debtBorrows.get(i).getAwaitAmount());

            Assertion.assertEquals(debts.get(i).getAwaitCapitalAmount().intValue(), debtBorrows.get(i).getAwaitCapitalAmount().intValue(),"debt和debt_borrow表的await_capital_amount字段对比");
            log.info("[debt.await_capital_amount]:{},[debt_borrow.await_capital_amount]:{}", debts.get(i).getAwaitCapitalAmount(), debtBorrows.get(i).getAwaitCapitalAmount());

            //状态为6时有误差，需要放开
            Assertion.assertEquals(debts.get(i).getAwaitInterestAmount(), debtBorrows.get(i).getAwaitInterestAmount(),"第【" + (i + 1) + "】条数据中，debt和debt_borrow表的await_interest_amount字段对比");
            log.info("[debt.await_interest_amount]:{},[debt_borrow.await_interest_amount]:{}", debts.get(i).getAwaitInterestAmount(), debtBorrows.get(i).getAwaitInterestAmount());

            Assertion.assertEquals(debts.get(i).getAwaitInterestAddAmount().intValue(), debtBorrows.get(i).getAwaitInterestAddAmount().intValue());
            log.info("[debt.await_interest_add_amount]:{},[debt_borrow.await_interest_add_amount]:{}", debts.get(i).getAwaitInterestAddAmount(), debtBorrows.get(i).getAwaitInterestAddAmount());

            Assertion.assertEquals(debts.get(i).getRepaidPeriod(), debtBorrows.get(i).getAlreadyRepayPeriod());
            log.info("[debt.repaid_period]:{},[debt_borrow.already_repay_period]:{}", debts.get(i).getAwaitInterestAddAmount(), debtBorrows.get(i).getAwaitInterestAddAmount());

//            状态为6时有误差，需要放开
            Assertion.assertEquals(debts.get(i).getRepayAmount(), debtBorrows.get(i).getRepayAmount(),"第【" + (i + 1) + "】条数据中，debt和debt_borrow表的repay_amount字段对比");
            log.info("[debt.repay_amount]:{},[debt_borrow.repay_amount]:{}", debts.get(i).getRepayAmount(), debtBorrows.get(i).getRepayAmount());

//            状态为6时有误差，需要放开
            Assertion.assertEquals(debts.get(i).getRepayCapitalAmount().intValue(), debtBorrows.get(i).getRepayCapitalAmount().intValue(),"第【" + (i + 1) + "】条数据中，debt和debt_borrow表的repay_capital_amount字段对比");
            log.info("[debt.repay_capital_amount]:{},[debt_borrow.repay_capital_amount]:{}", debts.get(i).getRepayCapitalAmount(), debtBorrows.get(i).getRepayCapitalAmount());

//            状态为6时有误差，需要放开
            Assertion.assertEquals(debts.get(i).getRepayInterestAmount(), debtBorrows.get(i).getRepayInterestAmount(),"第【" + (i + 1) + "】条数据中，debt和debt_borrow表的repay_interest_amount字段对比");
            log.info("[debt.repay_interest_amount]:{},[debt_borrow.repay_interest_amount]:{}", debts.get(i).getRepayInterestAmount(), debtBorrows.get(i).getRepayInterestAmount());

            Assertion.assertEquals(debts.get(i).getRepayPeriod(), debtBorrows.get(i).getRepayPeriod());
            log.info("[debt.repay_period]:{},[debt_borrow.total_period]:{}", debts.get(i).getRepayPeriod(), debtBorrows.get(i).getRepayPeriod());

            Assertion.assertEquals(debts.get(i).getTradeNo(), debtBorrows.get(i).getTradeNo());
            log.info("[debt.trade_no]:{},[debt_borrow.trade_no]:{}", debts.get(i).getTradeNo(), debtBorrows.get(i).getTradeNo());

            Assertion.assertEquals(debts.get(i).getMandataryUid(), debtBorrows.get(i).getMandataryUid());
            log.info("[debt.mandatary_uid]:{},[debt_borrow.mandatary_uid]:{}", debts.get(i).getMandataryUid(), debtBorrows.get(i).getMandataryUid());

            Assertion.assertEquals(debts.get(i).getMandataryFee().intValue(), debtBorrows.get(i).getMandataryFee().intValue());
            log.info("[debt.mandatary_fee]:{},[debt_borrow.mandatary_fee]:{}", debts.get(i).getMandataryFee().intValue(), debtBorrows.get(i).getMandataryFee().intValue());

//            Assertion.assertEquals(debts.get(i).getLoanType(), debtBorrows.get(i).getTypeLabel());
//            log.info("[debt.mandatary_fee]:{},[debt_borrow.mandatary_fee]:{}", debts.get(i).getMandataryFee().intValue(), debtBorrows.get(i).getMandataryFee().intValue());

            Assertion.assertEquals(debts.get(i).getInvestNum(), debtBorrows.get(i).getInvestCount());
            log.info("[debt.invest_num]:{},[debt_borrow.invest_num]:{}", debts.get(i).getInvestNum(), debtBorrows.get(i).getInvestCount() + "\r\n");

        }
    }

    public static void checkInvest(List<Invest> invests, List<InvestRecord> investRecords) {
        for (int i = 0; i < invests.size(); i++) {
            log.info("-----------第【" + (i + 1) + "】条数据中，bid.copy.invest和debt.debt_invest_record表的对应字段进行校验-----------");
            Assertion.assertEquals(Long.valueOf(invests.get(i).getId()), investRecords.get(i).getId());
            log.info("[invest.id]:{},[debt_invest_record.id]:{}", invests.get(i).getId(), investRecords.get(i).getId());

            Assertion.assertEquals(invests.get(i).getUid(), investRecords.get(i).getUid());
            log.info("[invest.uid]:{},[debt_invest_record.user_name]:{}", invests.get(i).getUid(), investRecords.get(i).getUid());

//            Assertion.assertEquals(invests.get(i).getDebtId(), investRecords.get(i).getDebtId());
//            log.info("[invest.debt_id]:{},[debt_invest_record.borrow_id]:{}", invests.get(i).getDebtId(), investRecords.get(i).getDebtId());
            Assertion.assertEquals(invests.get(i).getRelationId(), investRecords.get(i).getDebtId());
            log.info("[invest.relation_id]:{},[debt_invest_record.borrow_id]:{}", invests.get(i).getRelationId(), investRecords.get(i).getDebtId());

            Assertion.assertEquals(invests.get(i).getAmount(), investRecords.get(i).getAmount());
            log.info("[invest.amount]:{},[debt_invest_record.invest_amount]:{}", invests.get(i).getAmount(), investRecords.get(i).getAmount());

            Assertion.assertEquals(invests.get(i).getEffectedAmount(), investRecords.get(i).getEffectInvestAmount());
            log.info("[invest.effected_amount]:{},[debt_invest_record.effect_invest_amount]:{}", invests.get(i).getEffectedAmount(), investRecords.get(i).getEffectInvestAmount());

            Assertion.assertEquals(invests.get(i).getEffectedPart(), investRecords.get(i).getEffectInvestPart(), "第【" + (i + 1) + "】条数据中，invest和debt_invest_record中effected_part,effected_invest_part对比：");
            log.info("[invest.effected_part]:{},[debt_invest_record.effected_invest_part]:{}", invests.get(i).getEffectedPart(), investRecords.get(i).getEffectInvestPart());

            Assertion.assertEquals(invests.get(i).getType(), investRecords.get(i).getDebtCategory());
            log.info("[invest.type]:{},[debt_invest_record.debt_category]:{}", invests.get(i).getType(), investRecords.get(i).getDebtCategory());

            Assertion.assertEquals(invests.get(i).getCategoryId(), investRecords.get(i).getCategoryId());
            log.info("[invest.category_id]:{},[debt_invest_record.category_id]:{}", invests.get(i).getCategoryId(), investRecords.get(i).getCategoryId());

            Assertion.assertEquals(invests.get(i).getRepaymentType(), investRecords.get(i).getRepaymentWay());
            log.info("[invest.repayment_type]:{},[debt_invest_record.repayment_way]:{}", invests.get(i).getRepaymentType(), investRecords.get(i).getRepaymentWay());

            Assertion.assertEquals(invests.get(i).getDebtTitle(), investRecords.get(i).getDebtTitle());
            log.info("[invest.debt_title]:{},[debt_invest_record.debt_title]:{}", invests.get(i).getDebtTitle(), investRecords.get(i).getDebtTitle());

            Assertion.assertEquals(invests.get(i).getDebtRate(), investRecords.get(i).getRate());
            log.info("[invest.debt_rate]:{},[debt_invest_record.debt_rate]:{}", invests.get(i).getDebtRate(), investRecords.get(i).getRate());

            Assertion.assertEquals(invests.get(i).getTradeNo(), investRecords.get(i).getInvestTradeNo());
            log.info("[invest.trade_no]:{},[debt_invest_record.invest_trade_no]:{}", invests.get(i).getTradeNo(), investRecords.get(i).getInvestTradeNo());

            Assertion.assertEquals(invests.get(i).getReceiveAmount(), investRecords.get(i).getReceiveAmount());
            log.info("[invest.receive_amount]:{},[debt_invest_record.receive_amount]:{}", invests.get(i).getReceiveAmount(), investRecords.get(i).getReceiveAmount());

            Assertion.assertEquals(invests.get(i).getReceiveCapitalAmount(), investRecords.get(i).getReceiveCapitalAmount());
            log.info("[invest.receive_capital_amount]:{},[debt_invest_record.receive_capital_amount]:{}", invests.get(i).getReceiveCapitalAmount(), investRecords.get(i).getReceiveCapitalAmount());

            Assertion.assertEquals(invests.get(i).getReceiveInterestAmount(), investRecords.get(i).getReceiveInterestAmount());
            log.info("[invest.receive_interest_amount]:{},[debt_invest_record.receive_interest_amount]:{}", invests.get(i).getReceiveInterestAmount(), investRecords.get(i).getReceiveInterestAmount());

            Assertion.assertEquals(invests.get(i).getReceiveInterestAddAmount(), investRecords.get(i).getReceiveInterestAddAmount());
            log.info("[invest.receive_interest_add_amount]:{},[debt_invest_record.receive_interest_add_amount]:{}", invests.get(i).getReceiveInterestAddAmount(), investRecords.get(i).getReceiveInterestAddAmount());

            Assertion.assertEquals(invests.get(i).getReceiveInterestAddVoucherAmount(), investRecords.get(i).getAwaitInterestAddVoucherAmount());
            log.info("[invest.receive_interest_add_voucher_amount]:{},[debt_invest_record.await_interest_add_voucher_amount]:{}", invests.get(i).getReceiveInterestAddVoucherAmount(), investRecords.get(i).getReceiveInterestAddVoucherAmount());

            Assertion.assertEquals(invests.get(i).getAwaitAmount(), investRecords.get(i).getAwaitAmount());
            log.info("[invest.await_amount]:{},[debt_invest_record.await_amount]:{}", invests.get(i).getAwaitAmount(), investRecords.get(i).getAwaitAmount());

            Assertion.assertEquals(invests.get(i).getAwaitCapitalAmount(), investRecords.get(i).getAwaitCapitalAmount());
            log.info("[invest.await_capital_amount]:{},[debt_invest_record.await_capital_amount]:{}", invests.get(i).getAwaitCapitalAmount(), investRecords.get(i).getAwaitCapitalAmount());

            Assertion.assertEquals(invests.get(i).getAwaitInterestAmount(), investRecords.get(i).getAwaitInterestAmount());
            log.info("[invest.await_interest_amount]:{},[debt_invest_record.await_interest_amount]:{}", invests.get(i).getAwaitInterestAmount(), investRecords.get(i).getReceiveInterestAmount());

            Assertion.assertEquals(invests.get(i).getAwaitInterestAddAmount(), investRecords.get(i).getAwaitInterestAddAmount());
            log.info("[invest.await_interest_add_amount]:{},[debt_invest_record.await_interest_add_amount]:{}", invests.get(i).getAwaitInterestAddAmount(), investRecords.get(i).getAwaitInterestAddAmount());

            Assertion.assertEquals(invests.get(i).getAwaitInterestAddVoucherAmount(), investRecords.get(i).getAwaitInterestAddVoucherAmount());
            log.info("[invest.await_interest_add_voucher_amount]:{},[debt_invest_record.await_interest_add_voucher_amount]:{}", invests.get(i).getAwaitInterestAddVoucherAmount(), investRecords.get(i).getAwaitInterestAddVoucherAmount());

            Assertion.assertEquals(invests.get(i).getReceivedPeriod(), investRecords.get(i).getReceivedPeriod());
            log.info("[invest.received_period]:{},[debt_invest_record.received_num]:{}", invests.get(i).getReceivedPeriod(), investRecords.get(i).getReceivedPeriod());

            Assertion.assertEquals(invests.get(i).getTotalPeriod(), investRecords.get(i).getTotalPeriod());
            log.info("[invest.total_period]:{},[debt_invest_record.total_period]:{}", invests.get(i).getTotalPeriod(), investRecords.get(i).getTotalPeriod());

            Assertion.assertEquals(invests.get(i).getReceivedAmount(), investRecords.get(i).getActualReceivedAmount());
            log.info("[invest.received_amount]:{},[debt_invest_record.actual_received_amount]:{}", invests.get(i).getReceivedAmount(), investRecords.get(i).getActualReceivedAmount());

            Assertion.assertEquals(invests.get(i).getReceivedCapitalAmount(), investRecords.get(i).getActualReceivedCapitalAmount());
            log.info("[invest.received_capital_amount]:{},[debt_invest_record.actual_received_capital_amount]:{}", invests.get(i).getReceivedCapitalAmount(), investRecords.get(i).getActualReceivedCapitalAmount());

            Assertion.assertEquals(invests.get(i).getReceivedInterestAmount(), investRecords.get(i).getActualReceivedInterestAmount());
            log.info("[invest.received_interest_amount]:{},[debt_invest_record.actual_received_interest_amount]:{}", invests.get(i).getReceivedInterestAmount(), investRecords.get(i).getActualReceivedInterestAmount());

            Assertion.assertEquals(invests.get(i).getReceivedInterestAddAmount(), investRecords.get(i).getActualReceivedInterestAddAmount());
            log.info("[invest.received_interest_add_amount]:{},[debt_invest_record.actual_received_interest_add_amount]:{}", invests.get(i).getReceivedInterestAddAmount(), investRecords.get(i).getActualReceivedInterestAddAmount());

            Assertion.assertEquals(invests.get(i).getReceivedInterestAddVoucherAmount(), investRecords.get(i).getActualReceivedInterestAddVoucherAmount());
            log.info("[invest.received_interest_add_voucher_amount]:{},[debt_invest_record.actual_received_interest_add_voucher_amount]:{}", invests.get(i).getReceivedInterestAddAmount(), investRecords.get(i).getActualReceivedInterestAddAmount());

            Assertion.assertEquals(invests.get(i).getCalcInterestAt(), investRecords.get(i).getCalcInterestAt());
            log.info("[invest.calc_interest_at]:{},[debt_invest_record.calc_interest_date]:{}", invests.get(i).getCalcInterestAt(), investRecords.get(i).getCalcInterestAt());

            Assertion.assertEquals(invests.get(i).getLastReceiveAt(), investRecords.get(i).getLastReceiveAt());
            log.info("[invest.last_receive_at]:{},[debt_invest_record.last_receive_date]:{}", invests.get(i).getLastReceiveAt(), investRecords.get(i).getLastReceiveAt());

            Assertion.assertEquals(invests.get(i).getInvestCompleteAt(), investRecords.get(i).getInvestCompleteAt());
            log.info("[invest.invest_complete_at]:{},[debt_invest_record.invest_complete_date]:{}", invests.get(i).getInvestCompleteAt(), investRecords.get(i).getInvestCompleteAt());

            Assertion.assertEquals(invests.get(i).getVouchersCode(), investRecords.get(i).getVouchers());
            log.info("[invest.vouchers_code]:{},[debt_invest_record.vouchers]:{}", invests.get(i).getVouchersCode(), investRecords.get(i).getVouchers());

            Assertion.assertEquals(invests.get(i).getVouchersType(), investRecords.get(i).getVouchersType());
            log.info("[invest.vouchers_type]:{},[debt_invest_record.vouchers_type]:{}", invests.get(i).getVouchersType(), investRecords.get(i).getVouchersType());

            Assertion.assertEquals(invests.get(i).getVoucherInterestIsCalc(), investRecords.get(i).getCalcVoucherInterestFlag());
            log.info("[invest.voucher_interest_is_calc]:{},[debt_invest_record.is_calc_voucher_interest]:{}", invests.get(i).getVoucherInterestIsCalc(), investRecords.get(i).getCalcVoucherInterestFlag());

            Assertion.assertEquals(invests.get(i).getVoucherInterestIsCalc(), investRecords.get(i).getCalcVoucherInterestFlag());
            log.info("[invest.voucher_interest_is_calc]:{},[debt_invest_record.is_calc_voucher_interest]:{}", invests.get(i).getVoucherInterestIsCalc(), investRecords.get(i).getCalcVoucherInterestFlag() + "\r\n");

        }

    }
}
