package com.gildedrose.exceptions;

public enum ErrorCodesAndDescriptions {
    ITEMS_NULL_OR_EMPTY("E1000", "Items can not be null or empty"),
    ITEMS_NAME_NULL_OR_EMPTY("E1001", "Item name can not be null or empty"),
    INCORRECT_SULFURAS_QUALITY_VALUE("E1002", "Sulfuras quality can't be different than 80");

    private final String errorCode;
    private final String errorDescription;

    ErrorCodesAndDescriptions(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
