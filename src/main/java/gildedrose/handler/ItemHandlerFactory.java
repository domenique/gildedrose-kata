package gildedrose.handler;

import gildedrose.Item;

import java.util.List;

public class ItemHandlerFactory {

    private List<BaseHandler> handlers = List.of(
            new BackstageHandler(), new AgedBrieHandler(), new ConjuredHandler(), new SulfurasHandler());

    public BaseHandler handlerFor(Item item) {
        return handlers.stream()
                .filter(h -> h.supports(item))
                .findFirst()
                .orElse(new DefaultHandler());

    }
}
