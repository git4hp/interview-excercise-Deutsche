package com.acme.mytrader.price;

import java.util.*;

public class PriceListenerImpl implements PriceListener{

    private HashMap<String, Double> securities = new HashMap<String, Double>();

    public double getSecurityPrice() {
        return securities.get("IBM");
    }

    @Override
    public void priceUpdate(String securitySymbol , double price) {

       if(securities.containsKey(securitySymbol)){
           securities.replace(securitySymbol, price);
       }else{
           securities.put(securitySymbol, price);
       }
    }


}
