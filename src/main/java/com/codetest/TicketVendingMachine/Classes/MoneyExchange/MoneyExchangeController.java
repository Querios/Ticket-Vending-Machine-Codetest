package com.codetest.TicketVendingMachine.Classes.MoneyExchange;

import com.codetest.TicketVendingMachine.Classes.MoneyBalance.MoneyBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.*;

@Controller
public class MoneyExchangeController {
    private final MoneyBalance moneyBalance;

    @Autowired

    public MoneyExchangeController(MoneyBalance moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public void insertCoin(String coin, Label label) {

    }
}
