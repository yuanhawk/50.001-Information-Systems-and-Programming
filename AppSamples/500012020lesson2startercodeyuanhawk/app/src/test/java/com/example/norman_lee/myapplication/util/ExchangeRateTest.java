package com.example.norman_lee.myapplication.util;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ExchangeRateTest {

    @Test
    public void exchangeRateDefaultRate_isBigDecimal() {
        String defaultExchangeRate = "2.95000";
        assertEquals(new BigDecimal(defaultExchangeRate), new ExchangeRate().getExchangeRate());
    }

    @Test
    public void calculateAmount_BigDecimalAmount() {
        assertEquals(new ExchangeRate().calculateAmount("1"), new BigDecimal("2.95000"));
    }
}