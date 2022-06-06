package com.gildedrose.rules;

public class RuleBuilder {

    private Action     action;
    private Expression expression = item -> true;

    public Rule build() {
        return new Rule(expression, action);
    }

    public RuleBuilder execute(Action action) {
        this.action = action;
        return this;
    }

    public RuleBuilder expression(Expression expression) {
        this.expression = expression;
        return this;
    }
}
