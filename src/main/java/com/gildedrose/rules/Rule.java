package com.gildedrose.rules;

import com.gildedrose.Item;

public class Rule  {

    private final Expression expression;

    private final Action action;

    public Rule(final Expression expression, final Action action) {
        this.expression = expression;
        this.action = action;
    }

    public boolean supports(final Item item) {
        return expression.apply(item);
    }

    public void execute(final Item item) {
        action.apply(item);
    }
}
