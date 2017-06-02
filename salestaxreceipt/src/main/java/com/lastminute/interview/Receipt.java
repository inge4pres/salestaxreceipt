package com.lastminute.interview;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
/**
 * Print output receipt for list of Items
 */
public class Receipt implements Cashier
{
    
    Item[] items;

    // Create a receipt froma list of Item
    public Receipt(Item[] list) {
        items = list;
    }

    public String printItem(Item i) {
        //formatter
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat f = new DecimalFormat("#0.00", symbols);
        //how to desume the quantity per Item taxation?
        return i.quantity+" "+i.name+": "+f.format(i.itemTotal);
    }

    @Override
    public String printSalesTax() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat f = new DecimalFormat("#0.00", symbols);
        return "Sales Taxes: "+f.format(salesTax());
    }
    
    @Override
    public String printTotal() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat f = new DecimalFormat("#0.00", symbols);
        return "Total: "+f.format(total());
    }

    @Override
    public String printList()
    {
        String out = "";
        for (Item i : items) {
            out += printItem(i)+System.getProperty("line.separator");
        }
        return out;
    }
    
    private Double total() 
    {
        Double tot = 0.0;
        for (Item i : items) {
          tot += i.itemTotal;
        }
        return tot;
    }


    private Double salesTax() 
    {
        Double tot = 0.0;
        for (Item i : items) {
          tot += i.itemTax;
        }
        return tot;
    }

}