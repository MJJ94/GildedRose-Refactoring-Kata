package com.gildedrose.exceptions;

public class ItemsNullOrEmptyExceptions extends GildedRoseException {
    public ItemsNullOrEmptyExceptions() {
        super(ErrorCodesAndDescriptions.ITEMS_NULL_OR_EMPTY.getErrorCode(), ErrorCodesAndDescriptions.ITEMS_NULL_OR_EMPTY.getErrorDescription());
    }
}
