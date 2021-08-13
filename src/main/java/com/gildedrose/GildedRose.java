package com.gildedrose;

class GildedRose {

    private static final int QUALITY_THRESHOLD = 50;

    private static final String BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(final Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            if (item.name.equals(SULFURAS)) {
                // Sulfuras never needs to be sold or loses quality.
                // Exit early so we don't have to take Sulfuras into account.
                return;
            }

            if (!item.name.equals(BRIE) && !item.name.equals(BACKSTAGE_PASS)) {
                decrementQuality(item);
            } else {
                if (isNotOverThresholdQuality(item)) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASS)) {
                        if (item.sellIn < 11) {
                            incrementQuality(item);
                        }

                        if (item.sellIn < 6) {
                            incrementQuality(item);
                        }
                    }
                }
            }

            decrementSellIn(item);

            if (item.sellIn < 0) {
                if (!item.name.equals(BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASS)) {
                        decrementQuality(item);
                    } else {
                        expireQuality(item);
                    }
                } else {
                    incrementQuality(item);
                }
            }
        }
    }

    private boolean isNotOverThresholdQuality(final Item item) {
        return item.quality < QUALITY_THRESHOLD;
    }

    private boolean isNotZeroQuality(final Item item) {
        return item.quality > 0;
    }

    private void incrementQuality(final Item item) {
        if (isNotOverThresholdQuality(item)) {
            item.quality = item.quality + 1;
        }
    }

    private void decrementQuality(final Item item) {
        if (isNotZeroQuality(item)) {
            item.quality = item.quality - 1;
        }
    }

    private void decrementSellIn(final Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void expireQuality(final Item item) {
        item.quality = 0;
    }
}
