package gildedrose.handler;

import gildedrose.Item;

public class DefaultHandler extends BaseHandler {

    @Override
    public boolean supports(Item item) {
        return false;
    }

    @Override
    public void handle(Item item) {
        item.sellIn = item.sellIn - 1;

        decreaseQuality(item);
        if (item.sellIn < 0) decreaseQuality(item);
    }

}
