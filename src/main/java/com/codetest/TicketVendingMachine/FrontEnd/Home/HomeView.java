package com.codetest.TicketVendingMachine.FrontEnd.Home;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/Home")
@PageTitle("Home | Ticket Vending Machine")
public class HomeView extends VerticalLayout {

    @Autowired
    public HomeView(HomeViewController homeViewController) {
        Button navigateToDestinationsNutton = new Button("Select Destination");
        navigateToDestinationsNutton.addClickListener(click -> homeViewController.navigateToDestinationsView(this));
        add(navigateToDestinationsNutton);

        Button reviewAllTicketsButton = new Button("View / Sell All Tickets");
        reviewAllTicketsButton.addClickListener(click -> homeViewController.navigateToTicketView(this));
        add(reviewAllTicketsButton);

        Button insertMoneyButton = new Button("Insert Money");
        insertMoneyButton.addClickListener(click -> homeViewController.navigateToMoneyTransactionView(this));
        add(insertMoneyButton);

        Button refundInsertedMoneyButton = new Button("Refund Inserted Money");
        refundInsertedMoneyButton.addClickListener(click -> homeViewController.navigateToRefundMoneyView(this));
        add(refundInsertedMoneyButton);

        setSizeFull();
    }
}
