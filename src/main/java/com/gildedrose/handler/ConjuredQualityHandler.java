package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.QualityHelper.decrementQuality;
import static com.gildedrose.QualityHelper.isExpired;

public class ConjuredQualityHandler implements QualityHandler {

    private static final int CONFJURED_ITEM_QUALITY_DECREASE = 2;
    private static final ConjuredQualityHandler INSTANCE = new ConjuredQualityHandler();

    private ConjuredQualityHandler() {}

    public static ConjuredQualityHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateQuality(final Item item) {
        decrementQuality(item, CONFJURED_ITEM_QUALITY_DECREASE);

        if (isExpired(item)) {
            decrementQuality(item, CONFJURED_ITEM_QUALITY_DECREASE);
        }
    }
}
