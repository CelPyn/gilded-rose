package com.gildedrose;

import static com.gildedrose.QualityHelper.*;

public class ConjuredItem implements ExpandedItem, Degradable {

    private final Item baseItem;

    public ConjuredItem(final Item item) {
        this.baseItem = item;
    }

    @Override
    public void handleUpdateQuality() {
        decrementSellIn(baseItem);

        decrementQuality(baseItem, getQualityDecrease());

        if (isExpired(baseItem)) {
            decrementQuality(baseItem, getQualityDecrease());
        }
    }

    @Override
    public int getQualityDecrease() {
        return 2;
    }
}
