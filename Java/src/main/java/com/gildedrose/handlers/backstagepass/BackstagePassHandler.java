package com.gildedrose.handlers.backstagepass;

import com.gildedrose.Item;
import com.gildedrose.ItemNames;
import com.gildedrose.handlers.NonSulfurasItemCommonHandler;

public class BackstagePassHandler extends NonSulfurasItemCommonHandler {

    @Override
    public void handle(Item item) {
        if (ItemNames.BACKSTAGE_PASSES.getValue().equals(item.name)) {

            if (item.quality < 50) {
                item.quality++;
                //if backstage pass sellIn is inferior to 11 then quality has a second increase
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++;
                }
                //if backstage pass sellIn is inferior to 6 then quality has a third increase
                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality++;
                }
            }
            //If backstage pass sellIn is inferior to 0 then quality is 0
            if (item.sellIn < 1) {
                item.quality = 0;
            }
            super.nonSulfurasEndOfTheDay(item);
        } else {
            super.handle(item);
        }
    }
}
