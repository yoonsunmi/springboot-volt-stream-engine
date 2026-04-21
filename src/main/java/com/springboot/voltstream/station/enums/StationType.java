package com.springboot.voltstream.station.enums;

public enum StationType {
    FAST("급속"),
    SLOW("완속");

    private final String description;

    StationType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static StationType fromValue(String text) {
        for (StationType type : StationType.values()) {
            if (type.description.equals(text) || type.name().equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("알 수 없는 StationType: " + text);
    }
}
