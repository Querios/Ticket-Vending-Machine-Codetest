package com.codetest.TicketVendingMachine.Classes.MoneyBalance;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

public class MoneyBalance {

    private int oneEuroCoinCount;
    private int twoEuroCoinCount;
    private int fiveEuroCoinCount;
    private int tenEuroCoinCount;
    private int twentyEuroCoinCount;
    private int fiftyEuroCoinCount;
    private int oneHundredEuroCoinCount;
    private int twoHundredEuroCoinCount;
    private int fiveHundredEuroCoinCount;

    private int totalCoinBalance;

    public MoneyBalance() {
    }

    public MoneyBalance(int oneEuroCoinCount, int twoEuroCoinCount, int fiveEuroCoinCount, int tenEuroCoinCount, int twentyEuroCoinCount, int fiftyEuroCoinCount, int oneHundredEuroCoinCount, int twoHundredEuroCoinCount, int fiveHundredEuroCoinCount) {
        this.oneEuroCoinCount = oneEuroCoinCount;
        this.twoEuroCoinCount = twoEuroCoinCount;
        this.fiveEuroCoinCount = fiveEuroCoinCount;
        this.tenEuroCoinCount = tenEuroCoinCount;
        this.twentyEuroCoinCount = twentyEuroCoinCount;
        this.fiftyEuroCoinCount = fiftyEuroCoinCount;
        this.oneHundredEuroCoinCount = oneHundredEuroCoinCount;
        this.twoHundredEuroCoinCount = twoHundredEuroCoinCount;
        this.fiveHundredEuroCoinCount = fiveHundredEuroCoinCount;
    }

    public int getOneEuroCoinCount() {
        return oneEuroCoinCount;
    }

    public void setOneEuroCoinCount(int oneEuroCoinCount) {
        this.oneEuroCoinCount = oneEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getTwoEuroCoinCount() {
        return twoEuroCoinCount;
    }

    public void setTwoEuroCoinCount(int twoEuroCoinCount) {
        this.twoEuroCoinCount = twoEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getFiveEuroCoinCount() {
        return fiveEuroCoinCount;
    }

    public void setFiveEuroCoinCount(int fiveEuroCoinCount) {
        this.fiveEuroCoinCount = fiveEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getTenEuroCoinCount() {
        return tenEuroCoinCount;
    }

    public void setTenEuroCoinCount(int tenEuroCoinCount) {
        this.tenEuroCoinCount = tenEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getTwentyEuroCoinCount() {
        return twentyEuroCoinCount;
    }

    public void setTwentyEuroCoinCount(int twentyEuroCoinCount) {
        this.twentyEuroCoinCount = twentyEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getFiftyEuroCoinCount() {
        return fiftyEuroCoinCount;
    }

    public void setFiftyEuroCoinCount(int fiftyEuroCoinCount) {
        this.fiftyEuroCoinCount = fiftyEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getOneHundredEuroCoinCount() {
        return oneHundredEuroCoinCount;
    }

    public void setOneHundredEuroCoinCount(int oneHundredEuroCoinCount) {
        this.oneHundredEuroCoinCount = oneHundredEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getTwoHundredEuroCoinCount() {
        return twoHundredEuroCoinCount;
    }

    public void setTwoHundredEuroCoinCount(int twoHundredEuroCoinCount) {
        this.twoHundredEuroCoinCount = twoHundredEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getFiveHundredEuroCoinCount() {
        return fiveHundredEuroCoinCount;
    }

    public void setFiveHundredEuroCoinCount(int fiveHundredEuroCoinCount) {
        this.fiveHundredEuroCoinCount = fiveHundredEuroCoinCount;
        calculateTotalCoinBalance();
    }

    public int getTotalCoinBalance() {
        return totalCoinBalance;
    }

    public void calculateTotalCoinBalance() {
        totalCoinBalance =
                (1 * oneEuroCoinCount) +
                        (2 * twoEuroCoinCount) +
                        (5 * fiveEuroCoinCount) +
                        (10 * tenEuroCoinCount) +
                        (20 * twentyEuroCoinCount) +
                        (50 * fiftyEuroCoinCount) +
                        (100 * oneHundredEuroCoinCount) +
                        (200 * twoHundredEuroCoinCount) +
                        (500 * fiveHundredEuroCoinCount);
    }

    public void updateCoinCount(int coinValue) {
        switch (coinValue) {
            case 1:
                setOneEuroCoinCount(oneEuroCoinCount++);
                break;
            case 2:
                setTwoEuroCoinCount(twoEuroCoinCount++);
                break;
            case 5:
                setFiveEuroCoinCount(fiveEuroCoinCount++);
                break;
            case 10:
                setTenEuroCoinCount(tenEuroCoinCount++);
                break;
            case 20:
                setTwentyEuroCoinCount(twentyEuroCoinCount++);
                break;
            case 50:
                setFiftyEuroCoinCount(fiftyEuroCoinCount++);
                break;
            case 100:
                setOneHundredEuroCoinCount(oneHundredEuroCoinCount++);
                break;
            case 200:
                setTwoHundredEuroCoinCount(twoHundredEuroCoinCount++);
                break;
            case 500:
                setFiveHundredEuroCoinCount(fiveHundredEuroCoinCount++);
                break;
            default:
                break;
        }
    }

    public int getCoinCount(int value) {
        switch (value) {
            case 1:
                return getOneEuroCoinCount();
            case 2:
                return getTwoEuroCoinCount();
            case 5:
                return getFiveEuroCoinCount();
            case 10:
                return getTenEuroCoinCount();
            case 20:
                return getTwentyEuroCoinCount();
            case 50:
                return getFiftyEuroCoinCount();
            case 100:
                return getOneHundredEuroCoinCount();
            case 200:
                return getTwoHundredEuroCoinCount();
            case 500:
                return getFiveHundredEuroCoinCount();
            default:
                return 0;
        }
    }
}