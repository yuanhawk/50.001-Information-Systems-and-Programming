package com.example.norman_lee.myapplication.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ExchangeRate {

    private BigDecimal exchangeRate;
    private static String defaultRate = "2.95000";
    private static final int DEFAULT_PRECISION = 2;
    private int precision = DEFAULT_PRECISION;
    private MathContext mathContext;


    public ExchangeRate(){
        exchangeRate = new BigDecimal(defaultRate);
        instantiateMathContext(DEFAULT_PRECISION);
    }

    public ExchangeRate(String exchangeRate){
        this.exchangeRate = new BigDecimal(exchangeRate);
        instantiateMathContext(DEFAULT_PRECISION);
    }

    public ExchangeRate(String home, String foreign) {
        BigDecimal homeVal = new BigDecimal(home);
        BigDecimal foreignVal = new BigDecimal(foreign);

        instantiateMathContext(DEFAULT_PRECISION);
        //TODO 3.13a The constructor initializes exchangeRate by calculating the exchangeRate
        exchangeRate = homeVal.divide(foreignVal, mathContext);
    }

    public BigDecimal getExchangeRate(){
        return exchangeRate;
    }

    public BigDecimal calculateAmount(String foreign){
        //TODO 2.5a complete this method to return the amount
        BigDecimal foreignVal = new BigDecimal(foreign);

        return foreignVal.multiply(exchangeRate);
    }

    public void setPrecision(int precision){
        this.precision = precision;
        instantiateMathContext(precision);
    }

    private void instantiateMathContext(int precision){
        mathContext = new MathContext(precision, RoundingMode.HALF_UP);
    }
}
