package com.springboot.voltstream.station.enums;

public enum StationType {
    FAST("급속"),
    SLOW("완속");

    private final String value;

    StationType(String value) { this.value = value; }

    public static StationType fromValue(String text) {
        for (StationType b : StationType.values()) {
            if (String.valueOf(b.value).equals(text) || b.name().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
