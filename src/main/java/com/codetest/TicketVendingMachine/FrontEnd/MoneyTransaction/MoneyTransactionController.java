package com.codetest.TicketVendingMachine.FrontEnd.MoneyTransaction;

import com.codetest.TicketVendingMachine.Classes.MoneyBalance.MoneyBalance;
import com.vaadin.flow.component.html.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.Resource;

@Controller
public class MoneyTransactionController {

    @Resource(name = "moneyBalance")
    MoneyBalance moneyBalance;

    public MoneyTransactionController() {
    }

    public void insertCoin(Label coinLabel, int coinValue) {
        int newCoinCount = Integer.parseInt(coinLabel.getText()) + 1;
        coinLabel.setText(String.valueOf(newCoinCount));
        moneyBalance.updateCoinCount(coinValue);
    }

    public String getCoinCount(Integer coinValue) {
        return String.valueOf(moneyBalance.getCoinCount(coinValue));
    }
}
