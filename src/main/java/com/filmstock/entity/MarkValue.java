package com.filmstock.entity;

public enum MarkValue {
    M1(1),
    M2(2),
    M3(3),
    M4(4),
    M5(5),
    M6(6),
    M7(7),
    M8(8),
    M9(9),
    M10(10);

    private int value;

    MarkValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MarkValue getMarkValue(int value) {
        for (MarkValue markValue : MarkValue.values()) {
            if (value == markValue.getValue()) {
                return markValue;
            }
        }
        return null;
    }
}
