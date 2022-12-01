package gildedrose;

import java.util.Arrays;

import static java.util.function.Predicate.not;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
                .filter(not(this::isSulfuras))
                .forEach(this::handleItem);
    }

    private void handleItem(Item currentItem) {
        currentItem.sellIn = currentItem.sellIn - 1;
        switch (currentItem.name) {
            case "Aged Brie" -> {
                increaseQuality(currentItem);
                if (currentItem.sellIn < 0) increaseQuality(currentItem);
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                increaseQuality(currentItem);
                if (currentItem.sellIn < 10) increaseQuality(currentItem);
                if (currentItem.sellIn < 5) increaseQuality(currentItem);
                if (currentItem.sellIn < 0) resetQuality(currentItem);
            }
//            case "Conjured Mana Cake" -> {
//                decreaseQuality(currentItem);
//                decreaseQuality(currentItem);
//                if (currentItem.sellIn < 0) resetQuality(currentItem);
//            }
            default -> {
                decreaseQuality(currentItem);
                if (currentItem.sellIn < 0) decreaseQuality(currentItem);
            }
        }
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