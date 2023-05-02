package com.gildedrose;

public enum ItemNames {
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    CONJURED("Conjured Mana Cake");

    private final String value;

    ItemNames(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
