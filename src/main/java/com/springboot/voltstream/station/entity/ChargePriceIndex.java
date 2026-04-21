package com.springboot.voltstream.station.entity;

import com.springboot.voltstream.station.enums.PriceStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChargePriceIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "power_usage_id", nullable = false)
    private PowerUsage powerUsage;      // 산출 근거 데이터

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal priceIndex;      // 산출된 요금 지수

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PriceStatus status;         // 현재 상태

    @Column(nullable = false)
    private LocalDateTime createdAt;    // 산출 시간

}
