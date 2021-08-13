package com.gildedrose;

import static com.gildedrose.QualityHelper.*;

public class AgedBrie implements ExpandedItem, Ripenable {

    private final Item baseItem;

    public AgedBrie(final Item baseItem) {
        this.baseItem = baseItem;
    }

    @Override
    public void handleUpdateQuality() {
        decrementSellIn(baseItem);

        incrementQuality(baseItem, getQualityIncrease());
    }

    @Override
    public int getQualityIncrease() {
        if (isExpired(baseItem)) {
            return 2;
        }
        return 1;
    }
}
