package com.gildedrose.handler;

import com.gildedrose.Item;

public class LegendarySellInHandler implements SellInHandler {

    private static final LegendarySellInHandler INSTANCE = new LegendarySellInHandler();

    private LegendarySellInHandler() {}

    public static LegendarySellInHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateSellIn(final Item item) {
        // Legendary Items do not need to be sold.
    }
}
