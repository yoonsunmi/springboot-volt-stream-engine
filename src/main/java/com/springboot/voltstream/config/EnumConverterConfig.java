package com.springboot.voltstream.config;

import com.springboot.voltstream.station.enums.StationType;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EnumConverterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StationTypeConverter());
    }

    /**
     * 충전기 타입(FAST, SLOW 등) 변환기
     */
    public static class StationTypeConverter implements Converter<String, StationType> {
        @Override
        public StationType convert(@NonNull String source) {
            try {
                // Enum 내부에 fromValue 메서드가 있다면 호출, 없다면 valueOf 사용
                return StationType.fromValue(source);
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 StationType입니다: " + source);
            }
        }
    }

}
