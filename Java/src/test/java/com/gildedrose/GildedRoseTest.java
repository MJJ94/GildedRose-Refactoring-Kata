package com.gildedrose;

import com.gildedrose.exceptions.ErrorCodesAndDescriptions;
import com.gildedrose.exceptions.IncorrectSulfurasQualityException;
import com.gildedrose.exceptions.ItemNameNullOrEmptyException;
import com.gildedrose.exceptions.ItemsNullOrEmptyExceptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    private static Stream<Arguments> normalItemsQualityRangeAndExpectedResult() {
        List<Arguments> normalItemsQualityRange = new ArrayList<>();
        int sellIn = 15;
        int quality = 20;
        int expectedQuality;
        while (sellIn > -10) {
            if (sellIn > 0) {
                //If sellIn is bigger than 0 normal items quality decrease by 1
                expectedQuality = quality - 1;
            } else {
                //If sellIn is bigger than 0 normal items quality decrease by 2
                expectedQuality = quality - 2;
            }
            normalItemsQualityRange.add(Arguments.of(sellIn, expectedQuality, quality));
            sellIn--;
        }
        return normalItemsQualityRange.stream();
    }

    private static Stream<Arguments> agedBrieQualityRangeAndExpectedResult() {
        List<Arguments> brieQualityRange = new ArrayList<>();
        int sellIn = 15;
        int quality = 20;
        int expectedQualityAfterUpdate;
        while (sellIn > -2) {
            if (sellIn < 1) {
                expectedQualityAfterUpdate = quality + 2;
            } else {
                expectedQualityAfterUpdate = quality + 1;
            }
            brieQualityRange.add(Arguments.of(sellIn, expectedQualityAfterUpdate, quality));
            sellIn--;
        }
        return brieQualityRange.stream();
    }

    private static Stream<Arguments> backstagePassQualityRangeAndExpectedResult() {
        List<Arguments> backstagePassQualityRange = new ArrayList<>();
        int sellIn = 15;
        int quality = 20;
        int expectedQuality;
        while (sellIn > -2) {
            if (sellIn > 10) {
                //Like agedBrie backstagePass increase in quality less sellIn days
                expectedQuality = quality + 1;
            } else if (sellIn > 5) {
                //If sellIn is between 10 and 6 then quality increase by 2
                expectedQuality = quality + 2;
            } else if (sellIn > 0) {
                //If sellIn is between 5 and 0 then quality increase by 3
                expectedQuality = quality + 3;
            } else {
                //If sellIn is smaller than 0 then the quality is 0
                expectedQuality = 0;
            }
            backstagePassQualityRange.add(Arguments.of(sellIn, expectedQuality, quality));
            sellIn--;
        }
        return backstagePassQualityRange.stream();
    }

    private static Stream<Arguments> conjuredItemsQualityRangeAndExpectedResult() {
        List<Arguments> conjuredItemsQualityRange = new ArrayList<>();
        int sellIn = 15;
        int quality = 20;
        int expectedQuality;
        while (sellIn > -10) {
            if (sellIn > 0) {
                //If sellIn is bigger than 0 conjured items quality decrease by 2
                expectedQuality = quality - 2;
            } else {
                //If sellIn is bigger than 0 conjured items quality decrease by 4
                expectedQuality = quality - 4;
            }
            conjuredItemsQualityRange.add(Arguments.of(sellIn, expectedQuality, quality));
            sellIn--;
        }
        return conjuredItemsQualityRange.stream();
    }

    @Test
    void foo() {
        List<Item> items = Collections.singletonList(new Item("foo", 0, 0));
        GildedRose app = new GildedRose();
        List<Item> result = app.updateQuality(items);
        assertEquals("foo", result.get(0).name);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void itemsListCantBeNullOrEmpty(List<Item> items) {
        GildedRose gildedRose = new GildedRose();
        assertThrows(ItemsNullOrEmptyExceptions.class, () -> gildedRose.updateQuality(items), ErrorCodesAndDescriptions.ITEMS_NULL_OR_EMPTY.getErrorDescription());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void itemsCantHaveNullOrEmptyNames(String itemName) {
        List<Item> items = Collections.singletonList(new Item(itemName, 4, 10));
        GildedRose gildedRose = new GildedRose();

        assertThrows(ItemNameNullOrEmptyException.class, () -> gildedRose.updateQuality(items), ErrorCodesAndDescriptions.ITEMS_NAME_NULL_OR_EMPTY.getErrorDescription());
    }

    @ParameterizedTest
    @MethodSource("normalItemsQualityRangeAndExpectedResult")
    void normalItemsQualityUpdateTest(Integer sellIn, Integer expectedQuality, Integer quality) {
        List<Item> items = Collections.singletonList(new Item("item1", sellIn, quality));
        GildedRose gildedRose = new GildedRose();

        List<Item> result = gildedRose.updateQuality(items);

        Item item = result.get(0);
        assertEquals(expectedQuality, item.quality);
        int expectedSellIn = sellIn - 1;
        assertEquals(expectedSellIn, item.sellIn);
    }

    @Test
    void itemsQualityCantBeNegative() {
        List<Item> items = Collections.singletonList(new Item("item1", 4, 0));
        GildedRose gildedRose = new GildedRose();

        List<Item> result = gildedRose.updateQuality(items);

        Item item = result.get(0);
        assertEquals(0, item.quality);
        assertEquals(3, item.sellIn);
    }

    @ParameterizedTest
    @MethodSource("agedBrieQualityRangeAndExpectedResult")
    void agedBrieQUalityIncreasesTest(Integer sellIn, Integer expectedQualityAfterUpdate, Integer quality) {
        List<Item> items = Collections.singletonList(new Item(ItemNames.AGED_BRIE.getValue(), sellIn, quality));
        GildedRose gildedRose = new GildedRose();

        List<Item> result = gildedRose.updateQuality(items);

        Item item = result.get(0);
        assertEquals(expectedQualityAfterUpdate, item.quality);
        assertEquals(sellIn - 1, item.sellIn);
    }

    @ParameterizedTest
    @MethodSource("backstagePassQualityRangeAndExpectedResult")
    void backstagePassQualityIncreasesTest(Integer sellIn, Integer expectedQuality, Integer quality) {
        List<Item> items = Collections.singletonList(new Item(ItemNames.BACKSTAGE_PASSES.getValue(), sellIn, quality));
        GildedRose gildedRose = new GildedRose();

        List<Item> result = gildedRose.updateQuality(items);

        Item item = result.get(0);
        assertEquals(expectedQuality, item.quality);
        int expectedSellIn = sellIn - 1;
        assertEquals(expectedSellIn, item.sellIn);
    }

    @Test
    void sulfurasQualityNeverChanges() {
        List<Item> items = Collections.singletonList(new Item(ItemNames.SULFURAS.getValue(), 4, 80));
        GildedRose gildedRose = new GildedRose();

        List<Item> result = gildedRose.updateQuality(items);

        Item item = result.get(0);
        assertEquals(80, item.quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 81, 50})
    void sulfurasQualityCantBeDifferentThan80(int quality) {
        List<Item> items = Collections.singletonList(new Item(ItemNames.SULFURAS.getValue(), 4, quality));
        GildedRose gildedRose = new GildedRose();

        assertThrows(IncorrectSulfurasQualityException.class, () -> gildedRose.updateQuality(items), ErrorCodesAndDescriptions.INCORRECT_SULFURAS_QUALITY_VALUE.getErrorDescription());
    }

    @ParameterizedTest
    @MethodSource("conjuredItemsQualityRangeAndExpectedResult")
    @Disabled("Enable once conjured items feature is implemented")
    void conjuredItemsQualityUpdateTest(Integer sellIn, Integer expectedQuality, Integer quality) {
        List<Item> items = Collections.singletonList(new Item("Conjured", sellIn, quality));
        GildedRose gildedRose = new GildedRose();

        List<Item> result = gildedRose.updateQuality(items);

        Item item = result.get(0);
        assertEquals(expectedQuality, item.quality);
        int expectedSellIn = sellIn - 1;
        assertEquals(expectedSellIn, item.sellIn);
    }

}
