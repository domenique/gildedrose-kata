package gildedrose.handler;

import gildedrose.Item;

public class BackstageHandler extends BaseHandler {

    @Override
    public boolean supports(Item currentItem) {
        return currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void handle(Item currentItem) {
        currentItem.sellIn = currentItem.sellIn - 1;

        increaseQuality(currentItem);
        if (currentItem.sellIn < 10) increaseQuality(currentItem);
        if (currentItem.sellIn < 5) increaseQuality(currentItem);
        if (currentItem.sellIn < 0) resetQuality(currentItem);
    }
}