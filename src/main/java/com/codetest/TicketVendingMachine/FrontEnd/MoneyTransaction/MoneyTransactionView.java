package com.codetest.TicketVendingMachine.FrontEnd.MoneyTransaction;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.MoneyBalance.MoneyBalance;
import com.codetest.TicketVendingMachine.FrontEnd.Destination.DestinationViewController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.html.Label;

import java.util.HashMap;
import java.util.Map;

@Route("/MoneyTransaction")
public class MoneyTransactionView extends VerticalLayout {

    @Autowired
    public MoneyTransactionView(MoneyTransactionController moneyTransactionController) {

        Map<String, Integer> coinValuesMap = Map.of(
                "one", 1,
                "two", 2,
                "five", 5,
                "ten", 10,
                "twenty", 20,
                "fifty", 50,
                "oneHundred", 100,
                "twoHundred", 200,
                "fiveHundred", 500
        );

        for (String value : coinValuesMap.keySet()) {
            String coinLabelName = value.replace("H", " h");

            HorizontalLayout hl = new HorizontalLayout();

            Label coinDescriptionLabel = new Label(coinLabelName + " euro coins:");
            Label coinCountLabel = new Label(moneyTransactionController.getCoinCount(coinValuesMap.get(value)));
            Button btn = new Button("*inserts " + coinLabelName + " coin*");
            btn.addClickListener(buttonClickEvent -> moneyTransactionController.insertCoin(coinCountLabel, coinValuesMap.get(value)));

            hl.add(coinDescriptionLabel);
            hl.add(coinCountLabel);
            hl.add(btn);

            add(hl);
        }

        Button btn = new Button("Back");
        btn.addClickListener(buttonClickEvent -> this.getUI().ifPresent(ui -> ui.getPage().getHistory().back()));
        add(btn);

        setSizeFull();
    }
}
