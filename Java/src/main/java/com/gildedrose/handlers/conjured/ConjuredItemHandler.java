package com.gildedrose.handlers.conjured;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import com.gildedrose.handlers.NonSulfurasItemCommonHandler;

public class ConjuredItemHandler extends NonSulfurasItemCommonHandler {

    @Override
    public void handle(Item item) {

        if (ItemNames.CONJURED.getValue().equals(item.name)) {
            if (item.quality > 1) {
                item.quality -= 2;
            }
            if (item.sellIn < 1 && item.quality > 1) {
                item.quality -= 2;
            }
            nonSulfurasEndOfTheDay(item);
        } else {
            super.handle(item);
        }
    }
}
