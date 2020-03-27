package gildedrose.handler;

import gildedrose.Item;

public class AgedBrieHandler extends BaseHandler {

    @Override
    public boolean supports(Item currentItem) {
        return currentItem.name.equals("Aged Brie");
    }

    @Override
    public void handle(Item currentItem) {
        currentItem.sellIn = currentItem.sellIn - 1;

        increaseQuality(currentItem);
        if (currentItem.sellIn < 0) increaseQuality(currentItem);
    }
}