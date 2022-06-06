package com.gildedrose.rules;

import com.gildedrose.Item;
import com.gildedrose.ItemRulesFactory;

import static java.util.Objects.requireNonNull;

public class RuleEngine {

    private final ItemRulesFactory factory;

    public RuleEngine() {
        this.factory = new ItemRulesFactory();
    }

    public void execute(final Item item) {
        final Rules rules = factory.getRuleForItem(requireNonNull(item, "item cannot be null"));

        if (rules == null) {
            throw new IllegalArgumentException("Could not find rules for given item");
        }

        for (final Rule rule : rules) {
            if (rule.supports(item)) {
                rule.execute(item);
            }
        }
    }

}
