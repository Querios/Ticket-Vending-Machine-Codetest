package com.codetest.TicketVendingMachine.FrontEnd.Destination;

import com.codetest.TicketVendingMachine.Classes.Coin.Coin;
import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/Destinations")
@PageTitle("Destinations | Ticket Vending Machine")
public class DestinationView extends VerticalLayout {


    @Autowired
    public DestinationView(DestinationViewController destinationViewController) {
        Grid<Destination>  grid = new Grid<Destination>();

        grid.setSizeFull();
        grid.addColumn(destination -> destination.getName()).setHeader("Name");
        grid.addColumn(destination -> destination.getDate()).setHeader("Date");
        grid.addColumn(destination -> destination.getPrice()).setHeader("Price");
        grid.setItems(destinationViewController.getDestinations());
        grid.addSelectionListener(event -> destinationViewController.navigateToSeatsView(this, event.getFirstSelectedItem()));
        add(grid);

        Button btn = new Button("Back");
        btn.addClickListener(buttonClickEvent -> this.getUI().ifPresent(ui -> ui.getPage().getHistory().back()));
        add(btn);

        setSizeFull();
    }
}
