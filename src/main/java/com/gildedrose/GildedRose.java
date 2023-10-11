package com.gildedrose;
class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      updateQualityForItem(items[i]);
    }
  }

  private void updateQualityForItem(Item item) {

    switch (item.name) {
    case "Aged Brie":
      updateAgedBrie(item);
      break;

    case "Backstage passes to a TAFKAL80ETC concert":
      updateBackstagePasses(item);
      break;

    case "Sulfuras, Hand of Ragnaros":
      updateSulfuras(item);
      break;

    default:
      updateDefault(item);
      break;
    }
  }

  private void updateAgedBrie(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }

    item.sellIn = item.sellIn - 1;

    if (item.sellIn < 0) {
      if (item.quality < 50) {
        item.quality = item.quality + 1;
      }
    }
  }

  private void updateBackstagePasses(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;

      if (item.sellIn < 11) {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }

      if (item.sellIn < 6) {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }

    item.sellIn = item.sellIn - 1;
    if (item.sellIn < 0) {
      item.quality = 0;
    }
  }

  private void updateSulfuras(Item item) {
    // Ne rien faire, car Sulfuras ne change jamais
  }

  private void updateDefault(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }

    item.sellIn = item.sellIn - 1;

    if (item.sellIn < 0) {
      if (item.quality > 0) {
        item.quality = item.quality - 1;
      }
    }
  }
}