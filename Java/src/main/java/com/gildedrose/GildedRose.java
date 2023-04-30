package com.gildedrose;

class GildedRose {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            //if it's not aged brie neither backstage passes
            if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
                //If item quality is higher than 0 and it's not Sulfuras
                if (item.quality > 0 && !item.name.equals(SULFURAS)) {
                    item.quality = item.quality - 1;
                }
            } else {
                //If aged brie or backstage passes quality is inferior to 50
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    //If the item is backstage pass
                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        //if backstage pass sellIn is inferior to 11 and quality inferior to 50
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                        //if backstage pass sellIn is inferior to 6 and quality inferior to 50
                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
            //If the item is not Sulfuras
            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }
            //If SellIn is inferior to 0
            if (item.sellIn < 0) {
                //If the item is not aged brie
                if (!item.name.equals(AGED_BRIE)) {
                    //If the item is not backstage pass
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        //If the item quality is superior to 0 and is not Sulfuras
                        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        //If the item is backstage pass then quality is 0
                        item.quality = 0;
                    }
                } else {
                    //If the item is aged brie and quality is inferior to 50
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
