package com.codetest.TicketVendingMachine.FrontEnd.Home;

import com.codetest.TicketVendingMachine.Classes.Destination.DestinationService;
import com.codetest.TicketVendingMachine.FrontEnd.Controller.AppController;
import com.vaadin.flow.component.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeViewController {
    private final DestinationService destinationService;

    @Autowired
    public HomeViewController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    public void navigateToDestinationsView(Component cmp) {
        cmp.getUI().ifPresent(ui ->
                ui.navigate("/Destinations"));
    }

    public void navigateToTicketView(Component cmp) {
        cmp.getUI().ifPresent(ui ->
                ui.navigate("/Tickets"));
    }

    public void navigateToMoneyTransactionView(Component cmp) {
        cmp.getUI().ifPresent(ui ->
                ui.navigate("/MoneyTransaction"));
    }

    public void navigateToRefundMoneyView(Component cmp) {
        cmp.getUI().ifPresent(ui ->
                ui.navigate("/RefundMoney"));
    }
}
