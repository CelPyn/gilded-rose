package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.QualityHelper.decrementSellIn;

public class DefaultSellInHandler implements SellInHandler {

    private static final DefaultSellInHandler INSTANCE = new DefaultSellInHandler();

    private DefaultSellInHandler() {}

    public static DefaultSellInHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateSellIn(final Item item) {
        decrementSellIn(item);
    }
}
