package gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
                .forEach(this::handleItem);
    }

    private void handleItem(Item currentItem) {
        if (isSulfuras(currentItem)) {
            return;
        }

        if (isAgedBrie(currentItem)) {
            increaseQuality(currentItem);
        } else if (isBackstagePass(currentItem)) {
            increaseQuality(currentItem);
            if (currentItem.sellIn < 11) {
                increaseQuality(currentItem);
            }

            if (currentItem.sellIn < 6) {
                increaseQuality(currentItem);
            }
        } else {
            decreaseQuality(currentItem);
        }

        currentItem.sellIn = currentItem.sellIn - 1;

        if (isAgedBrie(currentItem)) {
            if (currentItem.sellIn < 0) increaseQuality(currentItem);
        } else if (isBackstagePass(currentItem)) {
            if (currentItem.sellIn < 0) resetQuality(currentItem);
        } else {
            if (currentItem.sellIn < 0) decreaseQuality(currentItem);
        }

    }

    private void resetQuality(Item currentItem) {
        currentItem.quality = 0;
    }

    private boolean isBackstagePass(Item currentItem) {
        return currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item currentItem) {
        return currentItem.name.equals("Aged Brie");
    }

    private void decreaseQuality(Item currentItem) {
        if (currentItem.quality > 0) {
            currentItem.quality = currentItem.quality - 1;
        }
    }

    private boolean isSulfuras(Item currentItem) {
        return currentItem.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void increaseQuality(Item currentItem) {
        if (currentItem.quality < 50) {
            currentItem.quality = currentItem.quality + 1;
        }
    }
}