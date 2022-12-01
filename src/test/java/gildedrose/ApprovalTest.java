package gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;


class ApprovalTest {

    @Test
    void approvalTest() {
        String[] names = {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Conjured Mana Cake"};
        Integer[] sellIns = {0, 1, 2, 3, 4, 10};
        Integer[] qualities = {0, 1, 2, 3, 10, 20};
        CombinationApprovals.verifyAllCombinations(this::runIt, names, sellIns, qualities);
    }

    private String runIt(String name, int sellIn, int quality) {
        var items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }
}
