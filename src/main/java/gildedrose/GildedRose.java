package gildedrose;

import gildedrose.handler.ItemHandlerFactory;

import java.util.Arrays;

class GildedRose {

    private ItemHandlerFactory itemHandlerFactory;
    Item[] items;

    public GildedRose(Item[] items) {
        this.itemHandlerFactory = new ItemHandlerFactory();
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
                .forEach(this::handleItem);
    }

    private void handleItem(Item currentItem) {
        itemHandlerFactory.handlerFor(currentItem).handle(currentItem);
    }
}