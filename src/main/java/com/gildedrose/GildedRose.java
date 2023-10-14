package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // Parcourt tous les items et met à jour leur qualité
        for (int i = 0; i < items.length; i++) {
            updateQualityForItem(items[i]);
        }
    }

    private void updateQualityForItem(Item item) {
        // Switch sur le nom de l'item pour appliquer les mises à jour appropriées
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
        // La qualité d'Aged Brie augmente avec l'âge, jusqu'à 50
        if (item.quality < 50) {
            item.quality += 1;
        }

        item.sellIn -= 1;

        // Une fois périmé, la qualité augmente deux fois plus vite
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality += 1;
        }
    }

    private void updateBackstagePasses(Item item) {
        // La qualité de Backstage Passes augmente avec le temps
        if (item.quality < 50) {
            item.quality += 1;
        }

        // Les règles spécifiques en fonction de la date du concert
        if (item.sellIn < 11 && item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 6 && item.quality < 50) {
            item.quality += 1;
        }

        item.sellIn -= 1;

        // Une fois le concert passé, la qualité tombe à zéro
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateDefault(Item item) {
        // La qualité diminue normalement
        if (item.quality > 0) {
            item.quality -= 1;
        }

        item.sellIn -= 1;

        // Une fois périmé, la qualité diminue deux fois plus vite
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void updateConjuredBeer(Item item) {
        // La qualité de Conjured Beer diminue deux fois plus vite
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
