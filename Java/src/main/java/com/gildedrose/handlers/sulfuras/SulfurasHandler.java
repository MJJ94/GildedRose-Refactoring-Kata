package com.gildedrose.handlers.sulfuras;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import com.gildedrose.exceptions.IncorrectSulfurasQualityException;
import com.gildedrose.handlers.ItemCommonHandler;

public class SulfurasHandler extends ItemCommonHandler {

    @Override
    public void handle(Item item) {
        if (ItemNames.SULFURAS.getValue().equals(item.name)) {
            if (item.quality != 80) {
                throw new IncorrectSulfurasQualityException();
            }
        } else {
            super.handle(item);
        }
    }
}
