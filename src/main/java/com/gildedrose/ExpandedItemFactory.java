package com.gildedrose;

import java.util.Locale;

public final class ExpandedItemFactory {

    private static final String BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private ExpandedItemFactory() {}

    public static ExpandedItem create(final Item item) {
        switch (item.name) {
            case BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASS:
                return new BackStagePass(item);
            case SULFURAS:
                return new LegendaryItem();
            default:
                if (item.name.toLowerCase(Locale.ROOT).startsWith("conjured")) {
                    return new ConjuredItem(item);
                }

                return new NormalItem(item);
        }
    }
}
