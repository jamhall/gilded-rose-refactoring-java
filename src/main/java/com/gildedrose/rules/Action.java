package com.gildedrose.rules;

import com.gildedrose.Item;

@FunctionalInterface
public interface Action {
    void apply(Item item);
}
