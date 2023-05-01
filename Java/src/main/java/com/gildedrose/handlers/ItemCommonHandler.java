package com.gildedrose.handlers;

import com.gildedrose.Item;

import java.util.Objects;

public abstract class ItemCommonHandler implements ItemHandler {
    private ItemHandler nextHandler;

    @Override
    public void setNext(ItemHandler next) {
        nextHandler = next;
    }

    @Override
    public void handle(Item item) {
        if (Objects.nonNull(nextHandler)) {
            nextHandler.handle(item);
        }
    }
}
