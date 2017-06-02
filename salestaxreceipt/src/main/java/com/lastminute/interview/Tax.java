package com.lastminute.interview;

import java.text.DecimalFormat;

public class Tax 
{
    final static Double StdRate = 0.10;
    final static Double ImportRate = 0.05;

    // https://stackoverflow.com/questions/11815135/best-method-to-round-up-to-the-nearest-0-05-in-java
    private static Double roundToFraction(Double x) {
        return Math.round(x * 20) / 20.0;
    }

    public static Double Calc(Double price, Double rate) {
        return Math.round((price * rate) * 20) / 20.0;
    }
}
