package com.springboot.voltstream.station.enums;

import java.math.BigDecimal;

public enum PriceStatus {
    NORMAL("평균 수요 이하"),
    SURGE("평균 초과"),
    PEAK("급등 구간");

    private final String description;

    PriceStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PriceStatus from(BigDecimal demandMultiplier) {
        if (demandMultiplier.compareTo(new BigDecimal("1.0")) < 0) return NORMAL;
        if (demandMultiplier.compareTo(new BigDecimal("1.5")) < 0) return SURGE;
        return PEAK;
    }
}
