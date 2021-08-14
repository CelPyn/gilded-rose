package com.gildedrose;

import com.gildedrose.handler.*;

import java.util.Locale;

public final class ExpandedItemFactory {

    private static final String BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final DefaultSellInHandler DEFAULT_SELL_IN_HANDLER = DefaultSellInHandler.getInstance();

    private ExpandedItemFactory() {}

    public static ExpandedItem create(final Item item) {
        switch (item.name) {
            case BRIE:
                return new DefaultExpandedItem(item, AgedBrieQualityHandler.getInstance(), DEFAULT_SELL_IN_HANDLER);
            case BACKSTAGE_PASS:
                return new DefaultExpandedItem(item, BackStagePassQualityHandler.getInstance(), DEFAULT_SELL_IN_HANDLER);
            case SULFURAS:
                return new DefaultExpandedItem(item, LegendaryQualityHandler.getInstance(), LegendarySellInHandler.getInstance());
            default:
                if (item.name.toLowerCase(Locale.ROOT).startsWith("conjured")) {
                    return new DefaultExpandedItem(item, ConjuredQualityHandler.getInstance(), DEFAULT_SELL_IN_HANDLER);
                }

                return new DefaultExpandedItem(item, NormalItemQualityHandler.getInstance(), DEFAULT_SELL_IN_HANDLER);
        }
    }
}
