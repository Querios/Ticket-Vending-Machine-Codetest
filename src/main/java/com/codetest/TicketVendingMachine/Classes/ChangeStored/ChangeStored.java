package com.codetest.TicketVendingMachine.Classes.ChangeStored;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ChangeStored {
    @Id

    private String coinType;
    private int amount;

    public ChangeStored() {
    }

    public ChangeStored(String coinType, int amount) {
        this.coinType = coinType;
        this.amount = amount;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
