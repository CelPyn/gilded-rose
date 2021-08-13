package com.gildedrose;

import static com.gildedrose.QualityHelper.*;

public class BackStagePass implements ExpandedItem, Ripenable {

    private final Item baseItem;

    public BackStagePass(final Item baseItem) {
        this.baseItem = baseItem;
    }

    @Override
    public void handleUpdateQuality() {
        decrementSellIn(baseItem);

        if (isExpired(baseItem)) {
            expireQuality(baseItem);
            return;
        }

        incrementQuality(baseItem, getQualityIncrease());
    }

    @Override
    public int getQualityIncrease() {
        if (baseItem.sellIn < 6) {
            return 3;
        }

        if (baseItem.sellIn < 11) {
            return 2;
        }

        return 1;
    }
}
