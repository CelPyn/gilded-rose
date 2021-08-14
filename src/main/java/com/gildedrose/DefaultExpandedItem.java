package com.gildedrose;

import com.gildedrose.handler.QualityHandler;
import com.gildedrose.handler.SellInHandler;

public class DefaultExpandedItem implements ExpandedItem {

    private final Item baseItem;
    private final QualityHandler qualityHandler;
    private final SellInHandler sellInHandler;

    public DefaultExpandedItem(final Item baseItem, final QualityHandler qualityHandler, final SellInHandler sellInHandler) {
        this.baseItem = baseItem;
        this.qualityHandler = qualityHandler;
        this.sellInHandler = sellInHandler;
    }

    @Override
    public void handleUpdateQuality() {
        sellInHandler.updateSellIn(baseItem);
        qualityHandler.updateQuality(baseItem);
    }
}
