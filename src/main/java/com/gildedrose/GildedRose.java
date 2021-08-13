package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(final Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).map(ExpandedItemFactory::create).forEach(ExpandedItem::handleUpdateQuality);
    }

}
