package com.gildedrose.exceptions;

public class ItemNameNullOrEmptyException extends GildedRoseException {
    public ItemNameNullOrEmptyException() {
        super(ErrorCodesAndDescriptions.ITEMS_NAME_NULL_OR_EMPTY.getErrorCode(), ErrorCodesAndDescriptions.ITEMS_NAME_NULL_OR_EMPTY.getErrorDescription());
    }
}
