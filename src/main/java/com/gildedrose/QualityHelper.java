package com.gildedrose;

public final class QualityHelper {

    private static final int QUALITY_THRESHOLD = 50;

    private QualityHelper() {}

    public static boolean isNotOverThresholdQuality(final Item item) {
        return item.quality < QUALITY_THRESHOLD;
    }

    public static boolean isNotZeroQuality(final Item item) {
        return item.quality > 0;
    }

    public static void incrementQuality(final Item item, final int amount) {
        if (amount == 0) {
            return;
        }

        if (isNotOverThresholdQuality(item)) {
            item.quality = item.quality + 1;
            incrementQuality(item, amount - 1);
        }
    }

    public static void decrementQuality(final Item item, final int amount) {
        if (amount == 0) {
            return;
        }

        if (isNotZeroQuality(item)) {
            item.quality = item.quality - 1;
            decrementQuality(item, amount - 1);
        }
    }

    public static void decrementSellIn(final Item item) {
        item.sellIn = item.sellIn - 1;
    }

    public static void expireQuality(final Item item) {
        item.quality = 0;
    }

    public static boolean isExpired(final Item item) {
        return item.sellIn < 0;
    }
}
