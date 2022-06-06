package com.gildedrose.rules;

import com.gildedrose.Item;

@FunctionalInterface
public interface Expression {
    boolean apply(Item item);

}
