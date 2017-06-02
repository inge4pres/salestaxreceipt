package com.lastminute.interview;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ItemTest {
    @Test
    public void attributeCategoryToItemByName()
    {
        Item i = new Item("1 book at 12.49");
        assertEquals(i.category, Item.EXEMPT);
        i = new Item("1 music CD at 14.99");
        assertEquals(i.category,  Item.REGULAR);
    }

    @Test
    public void attributeImportedToItemByName()
    {
        Item i = new Item("1 imported box of chocolates at 10.00");
        assertEquals(i.imported, true);
        i = new Item("1 bottle of perfume at 18.99");
        assertEquals(i.imported, false);
    }

    @Test
    public void itemTotalWithTaxstandardRate()
    {
        Item i = new Item("1 bottle of perfume at 18.99");
        assertEquals(20.89, i.itemTotal, 0.001);
    }
}
   

