package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("it should test conjured items")
public class ConjuredTest {

    @Test
    @DisplayName("quality should decrease by four when sell in expires")
    void qualityShouldDecreaseByFourWhenSellInExpires() {
        final Item item = new Item("Conjured Mana Cake", 0, 8);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(4, item.quality);
    }

    @Test
    @DisplayName("quality should decrease by two")
    void qualityShouldDecreaseByTwo() {
        final Item item = new Item("Conjured Mana Cake", 4, 4);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(3, item.sellIn);
        assertEquals(2, item.quality);
    }

}
