package com.codetest.TicketVendingMachine.Classes.Coin;

public class Coin {
    private String coinValueName;
    private int coinValue;

    public Coin(String coinValueName, int coinValue) {
        this.coinValueName = coinValueName;
        this.coinValue = coinValue;
    }

    public String getCoinValueName() {
        return coinValueName;
    }

    public void setCoinValueName(String coinValueName) {
        this.coinValueName = coinValueName;
    }

    public int getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }
}
