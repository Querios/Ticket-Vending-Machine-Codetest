package com.codetest.TicketVendingMachine.FrontEnd.TicketTransaction;

import com.codetest.TicketVendingMachine.Classes.Coin.Coin;
import com.codetest.TicketVendingMachine.Classes.Ticket.TicketItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Route("/TicketTransaction")
@PageTitle("Ticket Transaction | Ticket Vending Machine")
public class TicketTransactionView extends VerticalLayout implements HasUrlParameter<Long> {
    private final TicketTransactionViewController ticketTransactionViewController;

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        ticketTransactionViewController.setSeatId(parameter);

        var grid = new Grid<Coin>();

        HorizontalLayout hz = new HorizontalLayout();
        Label ticketPriceLabel = new Label("Ticket Price: ");
        Label totalMoneyValueLabel = new Label("0");
        Label euroLabel = new Label("€");
        Label backslashLabel = new Label("/");
        Label ticketPriceValueLabel = new Label(ticketTransactionViewController.getTicketPrice());


        hz.add(ticketPriceLabel);
        hz.add(totalMoneyValueLabel);
        hz.add(euroLabel);
        hz.add(backslashLabel);
        hz.add(ticketPriceValueLabel);
        hz.add(euroLabel);

        grid.setSizeFull();
        grid.addColumn(coin -> coin.getCoinValueName());
        grid.addComponentColumn(coin -> addCoinButton(coin, totalMoneyValueLabel));
        grid.setItems(ticketTransactionViewController.getCoinList());

        add(grid);
        add(hz);

        Button btn = new Button("Back");
        btn.addClickListener(buttonClickEvent -> this.getUI().ifPresent(ui -> ui.getPage().getHistory().back()));
        add(btn);

        setSizeFull();
    }

    @Autowired
    public TicketTransactionView(TicketTransactionViewController ticketTransactionViewController) {
        this.ticketTransactionViewController = ticketTransactionViewController;
    }

    private Button addCoinButton(Coin coin, Label totalMoneyValueLabel) {
        Button button = new Button("*Adds " + coin.getCoinValueName() + " Coin*");
        button.addClickListener(click -> {
            String newTotalCoinValueStr = ticketTransactionViewController.
                    calculatePayment(coin.getCoinValue(), totalMoneyValueLabel);
            totalMoneyValueLabel.setText(newTotalCoinValueStr);
        });
        return button;
    }
}
