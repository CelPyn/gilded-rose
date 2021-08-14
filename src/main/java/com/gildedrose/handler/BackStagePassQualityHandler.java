package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.QualityHelper.*;

public class BackStagePassQualityHandler implements QualityHandler {

    private static final BackStagePassQualityHandler INSTANCE = new BackStagePassQualityHandler();

    private BackStagePassQualityHandler() {}

    public static BackStagePassQualityHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateQuality(final Item item) {
        if (isExpired(item)) {
            expireQuality(item);
            return;
        }

        final int qualityIncrease = calculateQualityIncrease(item);
        incrementQuality(item, qualityIncrease);
    }

    private int calculateQualityIncrease(final Item item) {
        if (item.sellIn < 6) {
            return 3;
        }

        if (item.sellIn < 11) {
            return 2;
        }

        return 1;
    }
}
