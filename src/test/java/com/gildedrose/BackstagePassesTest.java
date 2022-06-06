package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("it should test backstage pass items")
public class BackstagePassesTest {

    @Test
    @DisplayName("quality should go to zero when sell in expires")
    void qualityShouldGoToZeroWhenSellInExpires() {
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 2);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    @DisplayName("quality should increase by three when five days or less")
    void qualityShouldIncreaseBThreeWhenFiveDaysOrLess() {
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 2);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(3, item.sellIn);
        assertEquals(5, item.quality);
    }

    @Test
    @DisplayName("quality should increase by one when ten days or more")
    void qualityShouldIncreaseBThreeWhenTenDaysOrMore() {
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 2);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(14, item.sellIn);
        assertEquals(3, item.quality);
    }

    @Test
    @DisplayName("quality should increase by two when ten days or less")
    void qualityShouldIncreaseByTwoWhenTenDaysOrLess() {
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(4, item.quality);
    }
}
