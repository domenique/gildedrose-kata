package gildedrose.handler;

import gildedrose.Item;

public class SulfurasHandler extends BaseHandler {

    @Override
    public boolean supports(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public void handle(Item item) {
        // NoOp
    }
}