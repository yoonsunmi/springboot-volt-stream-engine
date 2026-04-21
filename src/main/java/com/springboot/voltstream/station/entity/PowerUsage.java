package com.springboot.voltstream.station.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PowerUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;            // 전기차 충전소

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal kwh;             // 수집된 전기 수요량

    @Column(nullable = false)
    private LocalDateTime collectedAt;  // 수집 시각
}
