package com.gildedrose.handler;

import com.gildedrose.Item;

import static com.gildedrose.QualityHelper.decrementQuality;
import static com.gildedrose.QualityHelper.isExpired;

public class NormalItemQualityHandler implements QualityHandler {

    private static final int NORMAL_ITEM_QUALITY_DECREASE = 1;
    private static final NormalItemQualityHandler INSTANCE = new NormalItemQualityHandler();

    private NormalItemQualityHandler() {}

    public static NormalItemQualityHandler getInstance() {
        return INSTANCE;
    }

    @Override
    public void updateQuality(final Item item) {
        decrementQuality(item, NORMAL_ITEM_QUALITY_DECREASE);

        if (isExpired(item)) {
            decrementQuality(item, NORMAL_ITEM_QUALITY_DECREASE);
        }
    }
}
