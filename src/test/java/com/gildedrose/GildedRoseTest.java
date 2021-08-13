package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    private static final String NORMAL_ITEM = "normal";
    private static final String BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private GildedRose app;

    @Test
    void foo() {
        final Item[] items = new Item[] { new Item("foo", 0, 0) };
        app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isNotNull().isEqualTo("foo");
    }

    @Nested
    class NormalItem {

        @Test
        void when_normalItem_sellInNotDue_qualityDegradesByOne() {
            final Item[] items = new Item[] { new Item(NORMAL_ITEM, 10, 40) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(39);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(9);
        }

        @Test
        void when_normalItem_sellInOverDue_qualityDegradesByOne() {
            final Item[] items = new Item[] { new Item(NORMAL_ITEM, -2, 40) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(38);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(-3);
        }

        @Test
        void when_normalItem_qualityIsZero_neverNegative() {
            final Item[] items = new Item[] { new Item(NORMAL_ITEM, -2, 0) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(0);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(-3);
        }

    }

    @Nested
    class RipeningItem {

        @Test
        void when_brie_sellInNotDue_qualityIncreasesByOne() {
            final Item[] items = new Item[] { new Item(BRIE, 10, 15) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(16);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(9);
        }

        @Test
        void when_brie_sellInDue_qualityIncreasesByTwo() {
            final Item[] items = new Item[] { new Item(BRIE, -2, 15) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(17);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(-3);
        }

        @Test
        void when_brie_qualityNeverExceeds50() {
            final Item[] items = new Item[] { new Item(BRIE, 10, 49) };
            app = new GildedRose(items);
            updateQuality(5);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(50);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(5);
        }

        @Test
        void when_backstagePass_sellInHigherThan10_qualityIncreasesByOne() {
            final Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 20, 10) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(11);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(19);
        }

        @Test
        void when_backstagePass_sellIn10_qualityIncreasesByTwo() {
            final Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 10, 10) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(12);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(9);
        }

        @Test
        void when_backstagePass_sellInBetween5and10_qualityIncreasesByTwo() {
            final Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 8, 10) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(12);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(7);
        }

        @Test
        void when_backstagePass_sellIn5_qualityIncreasesByTwo() {
            final Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 5, 10) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(13);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(4);
        }

        @Test
        void when_backstagePass_sellInLowerThan5_qualityIncreasesByTwo() {
            final Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 4, 10) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(13);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(3);
        }

        @Test
        void when_backstagePass_sellInNegative_qualityZero() {
            final Item[] items = new Item[] { new Item(BACKSTAGE_PASS, 1, 10) };
            app = new GildedRose(items);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(13);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(0);
            updateQuality(1);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(0);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(-1);
        }
    }

    @Nested
    class LegendaryItem {

        @Test
        void when_sulfuras_doesNotDegrade_doesNotLoseSellIn() {
            final Item[] items = new Item[] { new Item(SULFURAS, 10, 30) };
            app = new GildedRose(items);
            updateQuality(5);
            assertThat(app.items[0].quality).isNotNull().isEqualTo(30);
            assertThat(app.items[0].sellIn).isNotNull().isEqualTo(10);
        }
    }

    private void updateQuality(final int times) {
        IntStream.range(0, times).forEach(i -> app.updateQuality());
    }

}
