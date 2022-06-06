package com.gildedrose;

import com.gildedrose.rules.Expression;
import com.gildedrose.rules.Rule;
import com.gildedrose.rules.RuleBuilder;
import com.gildedrose.rules.Rules;

import java.util.HashMap;

public class ItemRulesFactory {

    private final HashMap<String, Rules> items;

    public ItemRulesFactory() {
        this.items = new HashMap<>() {{
            put("Aged Brie", createAgedBrieRules());
            put("Backstage passes to a TAFKAL80ETC concert", createBackstagePassesRules());
            put("Conjured Mana Cake", createConjuredRules());
            put("Sulfuras, Hand of Ragnaros", createSulfurasRule());
        }};
    }

    public Rules getRuleForItem(final Item item) {
        return items.getOrDefault(item.name, createDefaultRules());
    }

    private Rules createAgedBrieRules() {
        return new Rules(
            createDecrementSellIn(),
            createDeltaQualityRule(2, item -> item.sellIn < 0),
            createDeltaQualityRule(1, item -> item.sellIn >= 0)
        );
    }

    private Rules createBackstagePassesRules() {
        return new Rules(
            createDecrementSellIn(),
            createZeroQualityRule(),
            createDeltaQualityRule(3, item -> item.sellIn <= 5 && item.sellIn > 0),
            createDeltaQualityRule(2, item -> item.sellIn <= 10 && item.sellIn > 5),
            createDeltaQualityRule(1, item -> item.sellIn >= 10)
        );
    }

    private Rules createConjuredRules() {
        return new Rules(
            createDecrementSellIn(),
            createDeltaQualityRule(-4, item -> item.sellIn < 0),
            createDeltaQualityRule(-2, item -> item.sellIn >= 0)
        );
    }

    private Rules createSulfurasRule() {
        return new Rules();
    }

    private Rule createDecrementSellIn() {
        return new RuleBuilder()
            .execute(item -> item.sellIn -= 1)
            .build();
    }

    private Rules createDefaultRules() {
        return new Rules(
            createDecrementSellIn(),
            createDeltaQualityRule(-2, item -> item.sellIn < 0),
            createDeltaQualityRule(-1, item -> item.sellIn >= 0)
        );
    }

    private Rule createDeltaQualityRule(final int amount,
                                        final Expression expression) {
        return new RuleBuilder()
            .expression(item -> {
                if (expression.apply(item)) {
                    final int lowerBound = 0;
                    final int upperBound = 50;
                    final int quality = item.quality + amount;
                    return quality >= lowerBound && quality <= upperBound;
                }
                return false;
            })
            .execute(item -> item.quality += amount)
            .build();
    }

    private Rule createZeroQualityRule() {
        return new RuleBuilder()
            .expression(item -> item.sellIn < 0)
            .execute(item -> item.quality = 0)
            .build();
    }
}
