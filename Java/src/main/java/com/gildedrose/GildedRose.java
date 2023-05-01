package com.gildedrose;

import com.gildedrose.exceptions.ItemNameNullOrEmptyException;
import com.gildedrose.exceptions.ItemsNullOrEmptyExceptions;
import com.gildedrose.handlers.ItemHandler;
import com.gildedrose.handlers.agedbrie.AgedBrieHandler;
import com.gildedrose.handlers.backstagepass.BackstagePassHandler;
import com.gildedrose.handlers.conjured.ConjuredItemHandler;
import com.gildedrose.handlers.normal.NormalItemHandler;
import com.gildedrose.handlers.sulfuras.SulfurasHandler;

import java.util.List;
import java.util.Objects;

class GildedRose {

    public List<Item> updateQuality(List<Item> items) {

        if (Objects.isNull(items) || items.isEmpty()) {
            throw new ItemsNullOrEmptyExceptions();
        }

        ItemHandler normalItemHandler = new NormalItemHandler();
        ItemHandler backstagePassHandler = new BackstagePassHandler();
        ItemHandler agedBrieHandler = new AgedBrieHandler();
        ItemHandler sulfurasHandler = new SulfurasHandler();
        ItemHandler conjuredHandler = new ConjuredItemHandler();

        sulfurasHandler.setNext(agedBrieHandler);
        agedBrieHandler.setNext(backstagePassHandler);
        backstagePassHandler.setNext(conjuredHandler);
        conjuredHandler.setNext(normalItemHandler);

        for (Item item : items) {
            if (Objects.isNull(item.name) || item.name.isEmpty()) {
                throw new ItemNameNullOrEmptyException();
            }
            sulfurasHandler.handle(item);
        }
        return items;
    }
}
