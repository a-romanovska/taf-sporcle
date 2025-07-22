package com.sporcle.enums;

public enum Symbol {
    EMPTY(""),
    SPACE(" "),
    DOT("."),
    COMMA(","),
    HASH("#");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
