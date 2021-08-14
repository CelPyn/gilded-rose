package com.gildedrose;

public final class QualityHelper {

    private static final int UPPER_QUALITY_THRESHOLD = 50;
    private static final int LOWER_QUALITY_THRESHOLD = 0;

    private QualityHelper() {}

    public static boolean isNotOverThresholdQuality(final Item item) {
        return item.quality < UPPER_QUALITY_THRESHOLD;
    }

    public static boolean isNotZeroQuality(final Item item) {
        return item.quality > LOWER_QUALITY_THRESHOLD;
    }

    public static void incrementQuality(final Item item, final int amount) {
        if (amount == 0) {
            return;
        }

        if (isNotOverThresholdQuality(item)) {
            item.quality += 1;
            incrementQuality(item, amount - 1);
        }
    }

    public static void decrementQuality(final Item item, final int amount) {
        if (amount == 0) {
            return;
        }

        if (isNotZeroQuality(item)) {
            item.quality -= 1;
            decrementQuality(item, amount - 1);
        }
    }

    public static void decrementSellIn(final Item item) {
        item.sellIn -= 1;
    }

    public static void expireQuality(final Item item) {
        item.quality = LOWER_QUALITY_THRESHOLD;
    }

    public static boolean isExpired(final Item item) {
        return item.sellIn < LOWER_QUALITY_THRESHOLD;
    }
}
