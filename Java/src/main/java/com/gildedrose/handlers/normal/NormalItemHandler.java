package com.gildedrose.handlers.normal;

import com.gildedrose.Item;
import com.gildedrose.handlers.NonSulfurasItemCommonHandler;

public class NormalItemHandler extends NonSulfurasItemCommonHandler {

    @Override
    public void handle(Item item) {

        if (item.quality > 0) {
            item.quality--;
        }
        if (item.sellIn < 1 && item.quality > 0) {
            item.quality--;
        }
        nonSulfurasEndOfTheDay(item);
    }
}
