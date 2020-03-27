package gildedrose.handler;

import gildedrose.Item;

public abstract class BaseHandler {

    public abstract boolean supports(Item item);

    public abstract void handle(Item item);

    public void increaseQuality(Item currentItem) {
        currentItem.quality = Math.min(50, currentItem.quality + 1);
    }

    public void decreaseQuality(Item currentItem) {
        currentItem.quality = Math.max(0, currentItem.quality - 1);
    }

    public void resetQuality(Item currentItem) {
        currentItem.quality = 0;
    }
}
