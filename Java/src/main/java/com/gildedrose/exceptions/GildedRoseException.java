package com.gildedrose.exceptions;

public class GildedRoseException extends RuntimeException {
    private final String errorCode;
    private final String errorDescription;


    public GildedRoseException(String errorCode, String errorDescription) {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "GildedRoseException{" +
            "errorCode='" + errorCode + '\'' +
            ", errorDescription='" + errorDescription + '\'' +
            '}';
    }
}
