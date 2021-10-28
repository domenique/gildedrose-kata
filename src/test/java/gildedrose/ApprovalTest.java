package gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(KsDiffReporter.class)
class ApprovalTest {

    @Test
    void approvalTest() {
        String[] names = {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
        Integer[] sellIns = {10, 0};
        Integer[] qualities = {20};
        CombinationApprovals.verifyAllCombinations(this::runIt, names, sellIns, qualities);
    }

    private String runIt(String name, int sellIn, int quality) {
        var items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }
}
