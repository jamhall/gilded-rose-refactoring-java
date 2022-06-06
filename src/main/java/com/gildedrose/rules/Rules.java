package com.gildedrose.rules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public class Rules implements Iterable<Rule> {
    private final List<Rule> rules = new ArrayList<>();

    public Rules(final Rule... rules) {
        this.rules.addAll(asList(rules));
    }

    @Override
    public Iterator<Rule> iterator() {
        return rules.iterator();
    }

}
