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
        currentItem.sellIn = currentItem.sellIn - 1;

        if (isAgedBrie(currentItem)) {
            handleAgedBrie(currentItem);
        } else if (isBackstagePass(currentItem)) {
            handleBackstagePass(currentItem);
        } else if (isConjured(currentItem)) {
            handleConjuredItem(currentItem);
        } else {
            handleDefaultItem(currentItem);
        }
    }

    private void handleDefaultItem(Item currentItem) {
        decreaseQuality(currentItem);
        if (currentItem.sellIn < 0) decreaseQuality(currentItem);
    }

    private void handleConjuredItem(Item currentItem) {
        decreaseQuality(currentItem);
        decreaseQuality(currentItem);
        if (currentItem.sellIn < 0) {
            decreaseQuality(currentItem);
            decreaseQuality(currentItem);
        }
    }

    private void handleBackstagePass(Item currentItem) {
        increaseQuality(currentItem);
        if (currentItem.sellIn < 10) increaseQuality(currentItem);
        if (currentItem.sellIn < 5) increaseQuality(currentItem);
        if (currentItem.sellIn < 0) resetQuality(currentItem);
    }

    private void handleAgedBrie(Item currentItem) {
        increaseQuality(currentItem);
        if (currentItem.sellIn < 0) increaseQuality(currentItem);
    }

    private boolean isConjured(Item currentItem) {
        return currentItem.name.equals("Conjured Mana Cake");
    }

    private boolean isBackstagePass(Item currentItem) {
        return currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item currentItem) {
        return currentItem.name.equals("Aged Brie");
    }

    private boolean isSulfuras(Item currentItem) {
        return currentItem.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void increaseQuality(Item currentItem) {
        currentItem.quality = Math.min(50, currentItem.quality + 1);
    }

    private void decreaseQuality(Item currentItem) {
        currentItem.quality = Math.max(0, currentItem.quality - 1);
    }

    private void resetQuality(Item currentItem) {
        currentItem.quality = 0;
    }
}