package com.touzhijia.domain.entity;

/**
 * Created by chenxl on 2018/3/31.
 */

public class VouchersCategory {
    public enum Type{
        /**
         * 提现券
         */
        WITHDRAW,
        /**
         * 现金券
         */
        CASH,
        /**
         * 平台加息券
         */
        PLAT_PLUS,
        /**
         * 投之家加息券
         */
        TZJ_PLUS,
        /**
         * 专享额度
         */
        EXCLUSIVE_QUOTA,
        /**
         * 新手额度
         */
        NOVICE_QUOTA,
        /**
         * 红包
         */
        LUCKY_MONEY;
    }
}