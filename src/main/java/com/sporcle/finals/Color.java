package com.sporcle.finals;

public enum Color {
    RED_ERROR("#BB0000");

    private final String hexCode;

    Color(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}