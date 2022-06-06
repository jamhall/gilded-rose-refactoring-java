package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    @DisplayName("it should decrease quality by one")
    void qualityShouldDecreaseByOne() {
        final Item item = new Item("test", 10, 3);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(2, item.quality);
    }

    @Test
    @DisplayName("it should decrease quality by two when sell in expires")
    void qualityShouldDecreaseByTwoWhenSellInExpires() {
        final Item item = new Item("test", 0, 3);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(1, item.quality);
    }

    @Test
    @DisplayName("quality should never be negative")
    void qualityShouldNeverBeNegative() {
        final Item item = new Item("test", 10, 0);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(0, item.quality);
    }


}
