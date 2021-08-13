package com.gildedrose;

import static com.gildedrose.QualityHelper.*;

public class NormalItem implements ExpandedItem {

    private final Item baseItem;

    public NormalItem(final Item baseItem) {
        this.baseItem = baseItem;
    }

    @Override
    public void handleUpdateQuality() {
        decrementSellIn(baseItem);

        decrementQuality(baseItem);

        if (isExpired(baseItem)) {
            decrementQuality(baseItem);
        }
    }
}
