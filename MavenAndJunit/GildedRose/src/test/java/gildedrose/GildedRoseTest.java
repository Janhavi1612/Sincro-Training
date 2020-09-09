package gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {

	@Test
	void testUpdateQuality() {
		Item[] items = new Item[] { new Item("Aged Brie", 5, 10), // 4,11
				new Item("Elixir of the Mongoose", 7, 17), // 6,16
				new Item("Sulfuras, Hand of Ragnaros", 4, 80), // 4,80
				new Item("Backstage passes to a TAFKAL80ETC concert", 9, 30), // 8,32
				new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40) // 3,43
		};

		Item[] expectedItems = new Item[] { new Item("Aged Brie", 4, 11), new Item("Elixir of the Mongoose", 6, 16),
				new Item("Sulfuras, Hand of Ragnaros", 4, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 8, 32),
				new Item("Backstage passes to a TAFKAL80ETC concert", 3, 43), };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		// assertArrayEquals("Array values should match", expectedItems, app.items);
		// Assertions.assertArrayEquals(expectedItems, app.items);
		for (int i = 0; i < items.length; i++) {
			Assertions.assertEquals(expectedItems[i].sellIn, app.items[i].sellIn);
			Assertions.assertEquals(expectedItems[i].quality, app.items[i].quality);
		}
	}

	@Test
	void testForAgedBrie() {
		Item[] items = new Item[] { new Item("Aged Brie", 3, 49), // 2,50
				new Item("Aged Brie", 2, 50), // 1,50
				new Item("Aged Brie", 1, 50), // 0,50
				new Item("Aged Brie", 0, 50), // -1,50
				new Item("Aged Brie", 0, 20), // -1,22
				new Item("Aged Brie", 9, 0), // 8,1
				new Item("Aged Brie", -2, 5) // -3,7
		};

		Item[] expectedItems = new Item[] { new Item("Aged Brie", 2, 50), new Item("Aged Brie", 1, 50),
				new Item("Aged Brie", 0, 50), new Item("Aged Brie", -1, 50), new Item("Aged Brie", -1, 22),
				new Item("Aged Brie", 8, 1), new Item("Aged Brie", -3, 7) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		for (int i = 0; i < items.length; i++) {
			Assertions.assertEquals(expectedItems[i].sellIn, app.items[i].sellIn);
			Assertions.assertEquals(expectedItems[i].quality, app.items[i].quality);
		}
	}

	@Test
	void testForConcertPasses() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30), // 10,31
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 32), // 9,34
				new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20), // 5,22
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 23), // 4,26
				new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30), // 0,33
				new Item("Backstage passes to a TAFKAL80ETC concert", 0, 33), // -1,0
				new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0) // -2,0
		};

		Item[] expectedItems = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 31),
				new Item("Backstage passes to a TAFKAL80ETC concert", 9, 34),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 22),
				new Item("Backstage passes to a TAFKAL80ETC concert", 4, 26),
				new Item("Backstage passes to a TAFKAL80ETC concert", 0, 33),
				new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
				new Item("Backstage passes to a TAFKAL80ETC concert", -2, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		for (int i = 0; i < items.length; i++) {
			Assertions.assertEquals(expectedItems[i].sellIn, app.items[i].sellIn);
			Assertions.assertEquals(expectedItems[i].quality, app.items[i].quality);
		}
	}

	@Test
	void testForSulfuras() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80), // 5,80
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), // 0,80
				new Item("Sulfuras, Hand of Ragnaros", -2, 80), // -2,80
		};

		Item[] expectedItems = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80),
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), new Item("Sulfuras, Hand of Ragnaros", -2, 80) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		for (int i = 0; i < items.length; i++) {
			Assertions.assertEquals(expectedItems[i].sellIn, app.items[i].sellIn);
			Assertions.assertEquals(expectedItems[i].quality, app.items[i].quality);
		}
	}

}
