package gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            var item = items[i];
            doStuff(item);
        }
    }

    private void doStuff(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Aged Brie":
                item.sellIn = item.sellIn - 1;

                increase(item);
                if (item.sellIn < 0) {
                    increase(item);
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.sellIn = item.sellIn - 1;

                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    if (item.sellIn < 11) {
                        increase(item);
                    }
                    if (item.sellIn < 6) {
                        increase(item);
                    }
                }

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            default:
                item.sellIn = item.sellIn - 1;

                decrease(item);
                if (item.sellIn < 0) {
                    decrease(item);
                }
                break;
        }
    }

    private void decrease(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increase(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}



