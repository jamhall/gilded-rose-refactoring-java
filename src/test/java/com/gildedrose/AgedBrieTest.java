package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("it should test aged brie items")
public class AgedBrieTest {

    @Test
    @DisplayName("quality should increase")
    void qualityShouldIncrease() {
        final Item item = new Item("Aged Brie", 4, 5);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(3, item.sellIn);
        assertEquals(6, item.quality);
    }

    @Test
    @DisplayName("quality should increase by two when sell in expires")
    void qualityShouldIncreaseByTwoWhenSellInExpires() {
        final Item item = new Item("Aged Brie", 0, 3);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(5, item.quality);
    }

    @Test
    @DisplayName("quality should never be more than fifty")
    void qualityShouldNeverBeMoreThanFifty() {
        final Item item = new Item("Aged Brie", 0, 50);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(50, item.quality);
    }

}
