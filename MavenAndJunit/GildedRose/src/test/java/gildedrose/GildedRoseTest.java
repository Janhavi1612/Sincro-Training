package gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {

	@Test
	void testUpdateQuality() {
		Item[] items = new Item[] { new Item("Aged Brie", 5, 10), // 4,11
				new Item("Elixir of the Mongoose", 7, 17), // 6,16
				new Item("Sulfuras, Hand of Ragnaros", 4, 20), // 4,20
				new Item("Backstage passes to a TAFKAL80ETC concert", 9, 30), // 8,32
				new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40) // 3,43
		};

		Item[] expectedItems = new Item[] { new Item("Aged Brie", 4, 11), new Item("Elixir of the Mongoose", 6, 16),
				new Item("Sulfuras, Hand of Ragnaros", 4, 20),
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
				new Item("Aged Brie", 9, 0) // 8,1
		};

		Item[] expectedItems = new Item[] { new Item("Aged Brie", 2, 50), new Item("Aged Brie", 1, 50),
				new Item("Aged Brie", 0, 50), new Item("Aged Brie", -1, 50), new Item("Aged Brie", -1, 22),
				new Item("Aged Brie", 8, 1) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		for (int i = 0; i < items.length; i++) {
			Assertions.assertEquals(expectedItems[i].sellIn, app.items[i].sellIn);
			Assertions.assertEquals(expectedItems[i].quality, app.items[i].quality);
		}
	}

	@Test
	void testForPasses() {
		Item[] items = new Item[] { new Item("Aged Brie", 3, 49), // 2,50
				new Item("Aged Brie", 2, 50), // 1,50
				new Item("Aged Brie", 1, 50), // 0,50
				new Item("Aged Brie", 0, 50), // -1,50
				new Item("Aged Brie", 0, 20), // -1,22
				new Item("Aged Brie", 9, 0) // 8,1
		};

		Item[] expectedItems = new Item[] { new Item("Aged Brie", 2, 50), new Item("Aged Brie", 1, 50),
				new Item("Aged Brie", 0, 50), new Item("Aged Brie", -1, 50), new Item("Aged Brie", -1, 22),
				new Item("Aged Brie", 8, 1) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		for (int i = 0; i < items.length; i++) {
			Assertions.assertEquals(expectedItems[i].sellIn, app.items[i].sellIn);
			Assertions.assertEquals(expectedItems[i].quality, app.items[i].quality);
		}
	}

}
