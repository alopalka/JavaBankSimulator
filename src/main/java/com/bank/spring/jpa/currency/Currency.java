package com.bank.spring.jpa.currency;

public enum Currency {
    USD("USD"),
    PLN("PLN"),
    EUR("EUR"),
//    JPY,
//    GBP,
//    CHF,
//    CAD,
//    AUD,
//    ZAR,
//    CNY,
    ;

    private final String currencyUnit;

    Currency(String currencyUnit){
        this.currencyUnit = currencyUnit;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }
}
