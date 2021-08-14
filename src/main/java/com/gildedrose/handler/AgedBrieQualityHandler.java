package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.QualityHelper.incrementQuality;
import static com.gildedrose.QualityHelper.isExpired;

public class AgedBrieQualityHandler implements QualityHandler {

    private static final AgedBrieQualityHandler INSTANCE = new AgedBrieQualityHandler();

    private AgedBrieQualityHandler() {}

    public static AgedBrieQualityHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateQuality(final Item item) {
        final int qualityIncrease = calculateQualityIncrease(item);
        incrementQuality(item, qualityIncrease);
    }

    private int calculateQualityIncrease(final Item item) {
        if (isExpired(item)) {
            return 2;
        }
        return 1;
    }
}
