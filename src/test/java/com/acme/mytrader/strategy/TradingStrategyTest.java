package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListenerImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TradingStrategyTest {

    @Mock
    ExecutionService executionService;

    @Mock
    PriceListenerImpl priceListener;

    @InjectMocks
    TradingStrategy tradingStrategy = new TradingStrategy("IBM", 100, 100);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_ibm_sell_100(){

       when(priceListener.getSecurityPrice()).thenReturn(110.0);

       tradingStrategy.checkAndExecute();

       verify(executionService, times(1)).sell("IBM", 100.0, 100);

    }
}
