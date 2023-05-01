package com.gildedrose.handlers;

import com.gildedrose.Item;

public class NonSulfurasItemCommonHandler extends ItemCommonHandler {

    public void nonSulfurasEndOfTheDay(Item item) {
        item.sellIn--;
    }

}
