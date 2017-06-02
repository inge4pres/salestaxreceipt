package com.lastminute.interview;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TaxTest
{
    @Test
    public void testTaxationRoundingUp(){
        Item i = new Item("1 box of imported chocolates at 11.25");
        assertEquals(11.85, i.afterTax, 0);
    }
}