package com.lastminute.interview;

import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Item 
{
    final static String REGULAR = "regular";
    final static String EXEMPT = "exemept";

    private static final Map<String,String> goodsCategory;
    static {
        goodsCategory = new HashMap<String,String>();
        goodsCategory.put("book", EXEMPT);
        goodsCategory.put("music", REGULAR);
        goodsCategory.put("chocolate", EXEMPT);
        goodsCategory.put("perfume", REGULAR);
        goodsCategory.put("pills", EXEMPT);
    }    
    
    String name;
    Double price;
    Double itemTax;
    Double afterTax;
    Double itemTotal;
    int quantity;
    String category;
    Boolean imported;

    public Item(String input) {
        // all attributes are defined from input at instanciation
        parseInput(input);
        setCategory();
        setImported();
        doTaxes();
        setItemTotal();
    }

    private void parseInput(String input) {
        //FIXME expensive computation of regex on each instance ot Item
        Pattern p = Pattern.compile("^(?<qty>\\d+)\\s(?<name>[\\w\\s]+)\\sat\\s(?<price>[\\d\\.]+)$");
        Matcher m = p.matcher(input);
        if (m.matches()) {
			quantity = Integer.parseInt(m.group("qty"));
            name = m.group("name");
            price = Double.parseDouble(m.group("price"));
		} else {
			System.out.println("unexpected input: "+input);
            System.exit(1);
        }
    }

    private void doTaxes() {
        // default is not imported AND exempted (books, food, medicals)
        afterTax = price;
        itemTax = 0.0;
        // imported with std rate exempt
        if (imported && (category == EXEMPT)) {
            itemTax = Tax.Calc(price, Tax.ImportRate);       
        // Maximum taxation
        } else if (imported && (category == REGULAR)) {
            itemTax += Tax.Calc(price, Tax.ImportRate+Tax.StdRate);
        // std rate
        } else if (category == REGULAR) {
            itemTax += Tax.Calc(price, Tax.StdRate);
        }
        afterTax += itemTax;
    }

    private void setItemTotal(){
        itemTotal = quantity*afterTax;
    }

    private void setCategory() {
        for (String k : goodsCategory.keySet()) {
            if (name.contains(k)) {
                category = goodsCategory.get(k);
            }
        }
    }

    private void setImported() {
        imported = name.contains("imported");
    }

}




