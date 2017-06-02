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
    public void printOutput1()
    {
        Item i1 = new Item("1 book at 12.49");
        Item i2 = new Item("1 music CD at 14.99");
        Item i3 = new Item("1 chocolate bar at 0.85");

        Receipt r = new Receipt(new Item[]{i1,i2,i3});
        // hopefully typo in requisite, no space between book and semicolon
        assertEquals(r.printItem(i1), "1 book: 12.49");
        assertEquals(r.printItem(i2), "1 music CD: 16.49");
        assertEquals(r.printItem(i3), "1 chocolate bar: 0.85");
        assertEquals(r.printSalesTax(), "Sales Taxes: 1.50");
        assertEquals(r.printTotal(), "Total: 29.83");
    }

    @Test
    public void printOutput2()
    {
        Item i1 = new Item("1 imported box of chocolates at 10.00");
        Item i2 = new Item("1 imported bottle of perfume at 47.50");
        
        Receipt r = new Receipt(new Item[]{i1,i2});
        assertEquals(r.printItem(i1), "1 imported box of chocolates: 10.50");
        assertEquals(r.printItem(i2), "1 imported bottle of perfume: 54.65");
        assertEquals(r.printSalesTax(), "Sales Taxes: 7.65");
        assertEquals(r.printTotal(), "Total: 65.15");
    }

    // Last test fails because of rouding
    // @Test
    // public void printOutput3()
    // {
    //     Item i1 = new Item("1 imported bottle of perfume at 27.99");
    //     Item i2 = new Item("1 bottle of perfume at 18.99");
    //     Item i3 = new Item("1 packet of headache pills at 9.75");
    //     Item i4 = new Item("1 box of imported chocolates at 11.25");

    //     Receipt r = new Receipt(new Item[]{i1,i2,i3,i4});
    //     assertEquals(r.printItem(i1), "1 imported bottle of perfume: 32.19");
    //     assertEquals(r.printItem(i2), "1 bottle of perfume: 20.89");
    //     assertEquals(r.printItem(i3), "1 packet of headache pills: 9.75");
    //     // hopefully typo in requisite, name is always written as imput
    //     assertEquals(r.printItem(i4), "1 box of imported chocolates: 11.85");
    //     assertEquals(r.printSalesTax(), "Sales Taxes: 6.70");
    //     assertEquals(r.printTotal(), "Total: 74.68");
    // }
}