package com.gildedrose.handler;

import com.gildedrose.Item;

public class LegendaryQualityHandler implements QualityHandler {

    private static final LegendaryQualityHandler INSTANCE = new LegendaryQualityHandler();

    private LegendaryQualityHandler() {}

    public static LegendaryQualityHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateQuality(final Item item) {
        // Legendary Items do not degrade
    }
}
