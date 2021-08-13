package com.gildedrose;

public class LegendaryItem implements ExpandedItem {

    @Override
    public void handleUpdateQuality() {
        // Legendary Items never degrade in quality and never lose sellIn
    }
}
