package com.gildedrose;

import com.gildedrose.rules.RuleEngine;

class GildedRose {
    private final RuleEngine engine;
    private final Item[] items;

    public GildedRose(final Item... items) {
        this.engine = new RuleEngine();
        this.items = items;
    }

    public Item getItem(int index) {
        return items[index];
    }

    public void updateQuality() {
        for (final Item item : items) {
            engine.execute(item);
        }
    }
}
