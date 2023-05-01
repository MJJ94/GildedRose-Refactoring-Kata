package com.gildedrose.exceptions;

public class IncorrectSulfurasQualityException extends GildedRoseException {
    public IncorrectSulfurasQualityException() {
        super(ErrorCodesAndDescriptions.INCORRECT_SULFURAS_QUALITY_VALUE.getErrorCode(), ErrorCodesAndDescriptions.INCORRECT_SULFURAS_QUALITY_VALUE.getErrorDescription());
    }
}
