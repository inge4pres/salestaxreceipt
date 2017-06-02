package com.lastminute.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;


public class Main
{
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList <String>();  

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            String item = null;
            while (!(item = br.readLine()).equals("")){
                input.add(item);
            }
        } catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        Item[] list = new Item[input.size()];

        for (int i =0; i<input.size(); i++){
              list[i] = new Item(input.get(i));
        }
        Receipt r = new Receipt(list);
        System.out.println(r.printList());
        System.out.println(r.printSalesTax());
        System.out.println(r.printTotal());
    }
}
