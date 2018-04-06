package com.touzhijia.domain.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DaysAheadDTO {

    private boolean isPunish = false;
    private int maxDayAhead;
    private BigDecimal punishProportion;
}
