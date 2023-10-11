package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

    static final String CLASSIC_ITEM = "classique item";
    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    //La qualite des items classique diminue de 1 quand quality > 0 et sellIn > 0
    void classicItemQuality1() {
        final int quality = 50;
        final int sellIn = 2;
        final Item[] items = new Item[] {
            new Item(CLASSIC_ITEM, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality - 1));
    }

    @Test
    // La qualite des itemsclassique ne peut etre inferieure a 0  qd quality < 0 et sellIn > 0
    void classicItemQuality2() {
        final int quality = 0;
        final int sellIn = 10;
        final Item[] items = new Item[] {
            new Item(CLASSIC_ITEM, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(0));
    }

    @Test
    // La qualite des items classique diminue de 2 quand quality > 0 et sellIn < 0

    void classicItemQuality3() {
        final int quality = 25;
        final int sellIn = 0;
        final Item[] items = new Item[] {
            new Item(CLASSIC_ITEM, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality - 2));
    }

    //---------------------------------------sulfurassssssssssss-------------------------------------
    // La qualite de Sulfuras ne change pas quand qualite > 0 et sellIn > 0
    @Test
    void sulfurasQualityUpdate() {
        final int quality = 80;
        final int sellIn = 15;

        final Item[] items = new Item[] {
            new Item(SULFURAS, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality));
    }

    @Test
    // La qualite de Sulfuras ne change pas qaund quality < 0 et sellIn > 0
    void sulfurasQualityUpdate2() {
        final int quality = -15;
        final int sellIn = 10;

        final Item[] items = new Item[] {
            new Item(SULFURAS, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality));
    }

    @Test
    // La qualite de Sulfuras ne change pas quand quality > 0 et sellIn < 0
    void sulfurasQualityUpdate3() {
        final int quality = 80;
        final int sellIn = -20;

        final Item[] items = new Item[] {
            new Item(SULFURAS, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality));
    }

    @Test
    // La qualite de Sulfuras ne change pas quand quality < 0 et sellIn < 0
    void sulfurasQualityUpdate4() {
        final int quality = -1;
        final int sellIn = -2;

        final Item[] items = new Item[] {
            new Item(SULFURAS, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality));
    }


 //-----------------------------Aged Brie--------------------------------------------------------------------------
    @Test
    // La qualite de Aged Brie augmente de 1 quand quality > 0 et sellIn > 0
    void AgedBrieQuality1() {
        final int quality = 12;
        final int sellIn = 6;
        final Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 1));
    }

    @Test
    // La qualite de Aged Brie augmente de 1 quand quality < 0 et sellIn > 0
    void AgedBrieQuality2() {
        final int quality = -1;
        final int sellIn = 1;
        final Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 1));
    }

    @Test
    // La qualite de Aged Brie ne peut pas depasser 50 quand quality = 50 et sellIn > 0
    void AgedBrieQuality3() {
        final int quality = 50;
        final int sellIn = 1;
        final Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(50));
    }

    @Test
    // La qualite de Aged Brie augmente de 2 quand quality > 0 et sellIn < 0
    void AgedBrieQuality4() {
        final int quality = 1;
        final int sellIn = 0;
        final Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 2));
    }

    @Test
    // La qualite de Aged Brie augmente de 2 quand quality <= 0 et sellIn <= 0.
    void AgedBrieQuality5() {
        final int quality = 0;
        final int sellIn = 0;
        final Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 2));
    }

    @Test
    // La qualite de Aged Brie ne peut depasser 50 quand quality = 49 et sellIn < 0
    void AgedBrieQuality6() {
        final int quality = 49;
        final int sellIn = 0;
        final Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(50));
    }


    //---------------------------------------------Backstage-------------------------------------------


    @Test
    // La qualite de Backstage passes augmente de 3 quand quality > 0 et 0 < sellIn <= 5
    void BackstageQuality1() {
        final int quality = 4;
        final int sellIn = 5;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 3));
    }

    @Test
    // La qualite de Backstage passes augmente de 3 qd quality < 0 et 0 < sellIn <= 5
    void BackstageQuality2() {
        final int quality = -1;
        final int sellIn = 5;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 3));
    }

    @Test
    // La qualite de Backstage ne peut pas d�passer 50 quand quality = 48 et 0 < sellIn <= 5
    void backstageQuality3() {
        final int quality = 48;
        final int sellIn = 5;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(50));
    }

    @Test
    // La qualite de Backstage augmente de 2 qd quality => 0 et 6 <= sellIn <= 10
    void backstageQuality4() {
        final int quality = 0;
        final int sellIn = 6;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 2));
    }

    @Test
    // La qualite de Backstage augmente de 2 qd quality < 0 et 6 <= sellIn <= 10
    void backstageQuality5() {
        final int quality = -1;
        final int sellIn = 6;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 2));
    }

    @Test
    // La qualite de Backstage ne peut pas depasser 50 / quality = 49, 6 <= sellIn <= 10
    void backstageQuality6() {
        final int quality = 49;
        final int sellIn = 6;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(50));
    }


    @Test
    // La qualite de Backstage augmente de 1 quand quality > 0 et sellIn >= 11
    void backstageQuality7() {
        final int quality = 1;
        final int sellIn = 11;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 1));
    }

    @Test
    // La qualite de Backstage passes augmente de 1 quand quality < 0 et sellIn >= 11
    void backstageQuality8() {
        final int quality = -1;
        final int sellIn = 11;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(quality + 1));
    }

    @Test
    // La qualite de Backstage ne peut pas depasser 50 qd quality = 50, sellIn >= 11
    void backstagePassesQuality9() {
        final int quality = 50;
        final int sellIn = 11;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(50));
    }

    @Test
    // La qualite de Backstage est � 0 quand sellIn <= 0 et quality > 0
    void backstageQuality10() {
        final int quality = 25;
        final int sellIn = 0;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].quality, is(0));
    }

    @Test
    // La qualite de Backstage est � 0 quand sellIn <= 0 et quality < 0
    void backstageQuality11() {
        final int quality = -10;
        final int sellIn = 0;
        final Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);

        app.updateQuality();
        // affichage
        System.out.println(app.items[0].toString());

        assertThat(app.items[0].quality, is(0));
    }


    //// Tests unitaires sur le SellIn //



    //sellIn de Aged Brie diminue de 1 quand quality > 0
    @Test
    void AgedBrieSellIn1() {
        int quality = 5;
        int sellIn = 15;
        Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));
    }


    //sellIn de Aged Brie diminue de 1 quand qualit� <= 0
    @Test
    void AgedBrieSellIn2() {
        int quality = 0;
        int sellIn = 15;
        Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));;
    }

    //sellIn de Aged Brie diminue de 1 quand qualit� = 50
    @Test
    void AgedBrieSellIn3() {
        int quality = 50;
        int sellIn = 15;
        Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));;
    }

    //sellIn de Aged Brie diminue de 1 quand qualit� >0 et sellIn <= 0
    @Test
    void AgedBrieSellIn4() {
        int quality = 15;
        int sellIn = 0;
        Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));
    }


    //sellIn de Aged Brie diminue de 1 quand qualit� <=0 et sellIn <= 0
    @Test
    void AgedBrieSellIn5() {
        int quality = 0;
        int sellIn = 0;
        Item[] items = new Item[] {
            new Item(AGED_BRIE, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));
    }


    //sellIn de Backstage diminue de 1 quand sellIn > 10
    @Test
    void BackstageSellIn1() {
        int quality = 0;
        int sellIn = 11;
        Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));
    }

    //sellIn de Backstage diminue de 1 quand 5<=sellIn <= 10
    @Test
    void BackstageSellIn2() {
        int quality = 0;
        int sellIn = 10;
        Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));
    }

    //sellIn de Backstage diminue de 1 quand 0 <= sellIn <= 5
    @Test
    void BackstageSellIn3() {
        int quality = 0;
        int sellIn = 5;
        Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));
    }

    //sellIn de Backstage diminue de 1 quand est <= -1 //????????????????????????????
    @Test
    void BackstageSellIn4() {
        int quality = 10;
        int sellIn = 0;
        Item[] items = new Item[] {
            new Item(BACKSTAGE_PASSES, sellIn, quality)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn, is(sellIn - 1));
    }

    @Test
    // sellIn de Sulfuras ne change pas quand quality > 0 et sellIn > 0
    void sulfurasSellIn1() {
        final int quality = 80;
        final int sellIn = 10;


        final Item[] items = new Item[] {
            new Item(SULFURAS, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn, is(sellIn));
    }


    @Test
    // quality > 0 et sellIn < 0
    void sulfurasSellIn2() {
        final int quality = -80;
        final int sellIn = 10;


        final Item[] items = new Item[] {
            new Item(SULFURAS, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn, is(sellIn));
    }

    @Test
    // sellIn de Sulfuras ne change pas quand quality < 0 et sellIn > 0
    void sulfurasSellIn3() {
        final int quality = 80;
        final int sellIn = -10;

        final Item[] items = new Item[] {
            new Item(SULFURAS, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn, is(sellIn));
    }



    @Test
    // quality < 0 et sellIn < 0
    void sulfurasSellInd3() {
        final int quality = -80;
        final int sellIn = -10;

        final Item[] items = new Item[] {
            new Item(SULFURAS, sellIn, quality)
        };

        final GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn, is(sellIn));
    }







}