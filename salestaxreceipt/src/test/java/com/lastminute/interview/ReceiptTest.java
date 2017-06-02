package com.lastminute.interview;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReceiptTest {
    @Test
    public void printItemWithExemptTax()
    {
        Item i = new Item("1 book at 12.49");
        Receipt r = new Receipt(new Item[]{i});
        // hopefully typo in requisite, no space between book and semicolon
        assertEquals(r.printItem(i), "1 book: 12.49");
    }

    @Test
    public void printItemWithoutExemptionTax()
    {
        Item i = new Item("1 music CD at 14.99");
        Receipt r = new Receipt(new Item[]{i});
        // hopefully typo in requisite, no space between book and semicolon
        assertEquals(r.printItem(i), "1 music CD: 16.49");
    }
    
    @Test
    public void printImportedItemWithExemptTax()
    {
        Item i = new Item("1 imported box of chocolates at 10.00");
        Receipt r = new Receipt(new Item[]{i});
        // hopefully typo in requisite, no space between book and semicolon
        assertEquals(r.printItem(i), "1 imported box of chocolates: 10.50");
    }

    @Test
    public void printImportedItemWithoutExemptTax()
    {
        Item i = new Item("1 imported bottle of perfume at 47.50");
        Receipt r = new Receipt(new Item[]{i});
        // hopefully typo in requisite, no space between book and semicolon
        assertEquals(r.printItem(i), "1 imported bottle of perfume: 54.65");
    }

    @Test
    public void printSalesTaxOutput1()
    {
        Item i1 = new Item("1 book at 12.49");
        Item i2 = new Item("1 music CD at 14.99");
        Item i3 = new Item("1 chocolate bar at 0.85");

        Receipt r = new Receipt(new Item[]{i1,i2,i3});
        // hopefully typo in requisite, no space between book and semicolon
        assertEquals(r.printSalesTax(), "Sales Taxes: 1.50");
    }

    @Test
    public void printTotalOutput1()
    {
        Item i1 = new Item("1 book at 12.49");
        Item i2 = new Item("1 music CD at 14.99");
        Item i3 = new Item("1 chocolate bar at 0.85");

        Receipt r = new Receipt(new Item[]{i1,i2,i3});
        // hopefully typo in requisite, no space between book and semicolon
        assertEquals(r.printTotal(), "Total: 29.83");
    }
}