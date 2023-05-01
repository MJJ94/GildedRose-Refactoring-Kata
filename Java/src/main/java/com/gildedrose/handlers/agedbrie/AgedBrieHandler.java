package com.gildedrose.handlers.agedbrie;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import com.gildedrose.handlers.NonSulfurasItemCommonHandler;

public class AgedBrieHandler extends NonSulfurasItemCommonHandler {

    @Override
    public void handle(Item item) {
        if (ItemNames.AGED_BRIE.getValue().equals(item.name)) {
            if (item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn < 1) {
                item.quality++;
            }
            super.nonSulfurasEndOfTheDay(item);
        } else {
            super.handle(item);
        }
    }
}
