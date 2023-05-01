package com.gildedrose.handlers;

import com.gildedrose.Item;

public interface ItemHandler {
    void setNext(ItemHandler next);

    void handle(Item item);
}
