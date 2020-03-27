package gildedrose.handler;

import gildedrose.Item;

public class ConjuredHandler extends BaseHandler {

    @Override
    public boolean supports(Item currentItem) {
        return currentItem.name.equals("Conjured Mana Cake");
    }

    @Override
    public void handle(Item currentItem) {
        currentItem.sellIn = currentItem.sellIn - 1;

        decreaseQuality(currentItem);
        decreaseQuality(currentItem);
        if (currentItem.sellIn < 0) {
            decreaseQuality(currentItem);
            decreaseQuality(currentItem);
        }
    }
}