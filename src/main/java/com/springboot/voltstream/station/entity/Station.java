package com.springboot.voltstream.station.entity;

import com.springboot.voltstream.station.enums.StationType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;            // 충전소

    private String region;          // 지역

    private String operator;        // 운영사

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StationType type;       // 충전기 타입

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal basePrice;    // 기본 요금

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal thresholdKwh; // 요금이 할증되기 시작하는 기준 전력량
}
