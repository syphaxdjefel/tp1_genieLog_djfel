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
                // Ne rien faire, car Sulfuras ne change jamais
                break;
            
            case "Conjured Beer":
                updateConjuredBeer(item);
                break;

            default:
                updateDefault(item);
                break;
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }

        item.sellIn -= 1;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality += 1;
        }
    }

    private void updateBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 11 && item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 6 && item.quality < 50) {
            item.quality += 1;
        }

        item.sellIn -= 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateDefault(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }

        item.sellIn -= 1;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void updateConjuredBeer(Item item) {
        int decreaseValue;
        if (item.sellIn >= 0) {
            decreaseValue = 2;
        } else {
            decreaseValue = 4;
        }

        if (item.quality > decreaseValue) {
            item.quality -= decreaseValue;
        } else {
            item.quality = 0;
        }
        item.sellIn -= 1;
    }
}
