package com.gildedrose;

import java.util.List;

class GildedRose {

    public List<Item> updateQuality(List<Item> items) {

        for (Item item : items) {
            //if it's not aged brie neither backstage passes
            if (!item.name.equals(ItemNames.AGED_BRIE.getValue())
                && !item.name.equals(ItemNames.BACKSTAGE_PASSES.getValue())) {
                //If item quality is higher than 0 and it's not Sulfuras
                if (item.quality > 0 && !item.name.equals(ItemNames.SULFURAS.getValue())) {
                    item.quality = item.quality - 1;
                }
            } else {
                //If aged brie or backstage passes quality is inferior to 50
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    //If the item is backstage pass
                    if (item.name.equals(ItemNames.BACKSTAGE_PASSES.getValue())) {
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
            if (!item.name.equals(ItemNames.SULFURAS.getValue())) {
                item.sellIn = item.sellIn - 1;
            }
            //If SellIn is inferior to 0
            if (item.sellIn < 0) {
                //If the item is not aged brie
                if (!item.name.equals(ItemNames.AGED_BRIE.getValue())) {
                    //If the item is not backstage pass
                    if (!item.name.equals(ItemNames.BACKSTAGE_PASSES.getValue())) {
                        //If the item quality is superior to 0 and is not Sulfuras
                        if (item.quality > 0 && !item.name.equals(ItemNames.SULFURAS.getValue())) {
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
        return items;
    }
}
