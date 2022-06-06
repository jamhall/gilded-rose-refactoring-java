package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("it should test sulfuras items")
public class SulfurasTest {

    @Test
    @DisplayName("quality and sell in should never decrease")
    void qualityAndSelInShouldNeverDecrease() {
        final Item item = new Item("Sulfuras, Hand of Ragnaros", 4, 4);
        final GildedRose application = new GildedRose(item);
        application.updateQuality();
        assertEquals(4, item.sellIn);
        assertEquals(4, item.quality);
    }
}
