package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceListenerImpl;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {

    private String security;
    private double sellPrice;
    private double buyPrice;

    private PriceListenerImpl priceListener = new PriceListenerImpl();

    private ExecutionService executionService;

    public TradingStrategy(){
        this.security = "IBM";
        this.sellPrice = 0.0;
        this.buyPrice = 0.0;
    }

    public TradingStrategy(String security, int sell, int buy){
        this.security = "IBM";
        this.sellPrice = sell;
        this.buyPrice = buy;
    }

    public void checkAndExecute(){

            // check the price for the security
            // priceListener.getSecurities -> check price for Security
            if(priceListener.getSecurityPrice() < buyPrice){
                executionService.buy(security, buyPrice, 100);
                // if the price < buyPrice then executionService.buy(buyquantity)
            }else if ( priceListener.getSecurityPrice() > sellPrice ) {
                executionService.sell(security, buyPrice, 100);
            }
    }
}
