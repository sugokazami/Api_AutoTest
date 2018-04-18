package com.touzhijia.domain.entity;

import lombok.Data;

/**
 * Created by chenxl on 2018/4/17.
 */

@Data
public class CheckBean<T> {

    private String checkName ;

    private T actualValue ;

    private T expectValue ;

    private String result ;

    public CheckBean(String checkName, T actualValue, T expectValue, String result) {
        this.checkName = checkName;
        this.actualValue = actualValue;
        this.expectValue = expectValue;
        this.result = result;
    }
}
