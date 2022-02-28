package com.codetest.TicketVendingMachine.VisualState;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.MoneyBalance.MoneyBalance;
import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AppVisualState {
    private MoneyBalance moneyBalance;
    private Destination destination;
    private Seat seat;

    public AppVisualState() {
        moneyBalance = new MoneyBalance();
    }

    public MoneyBalance getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(MoneyBalance moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
