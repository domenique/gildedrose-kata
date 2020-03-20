package gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (var i = 0; i < items.length; i++) {
            var currentItem = items[i];

            if (isSulfuras(currentItem)) {
                continue;
            }

            if (!isAgedBrie(currentItem)
                    && !isBackstagePass(currentItem)) {
                decreaseQuality(currentItem);
            } else {
                increaseQuality(currentItem);
                if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (currentItem.sellIn < 11) {
                        increaseQuality(currentItem);
                    }

                    if (currentItem.sellIn < 6) {
                        increaseQuality(currentItem);
                    }
                }

            }

            currentItem.sellIn = currentItem.sellIn - 1;

            if (currentItem.sellIn < 0) {
                if (!isAgedBrie(currentItem)) {
                    if (!currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        decreaseQuality(currentItem);
                    } else {
                        currentItem.quality = currentItem.quality - currentItem.quality;
                    }
                } else {
                    increaseQuality(currentItem);
                }
            }
        }
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