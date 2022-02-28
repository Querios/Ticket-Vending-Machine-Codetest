package com.codetest.TicketVendingMachine.FrontEnd.Ticket;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Ticket.Ticket;
import com.codetest.TicketVendingMachine.Classes.Ticket.TicketItem;
import com.codetest.TicketVendingMachine.FrontEnd.Destination.DestinationViewController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/Tickets")
@PageTitle("All Tickets | Ticket Vending Machine")
public class TicketView extends VerticalLayout {

    private final TicketViewController ticketViewController;

    @Autowired
    public TicketView(TicketViewController ticketViewController) {
        this.ticketViewController = ticketViewController;
        var grid = new Grid<Ticket>();

        grid.setSizeFull();
        grid.addColumn(Ticket::getDestinationName).setHeader("Destination");
        grid.addColumn(Ticket::getDestinationDate).setHeader("Date");
        grid.addColumn(Ticket::getSeatNo).setHeader("Seat Number");
        grid.addColumn(Ticket::getDestinationPrice).setHeader("Price");
        grid.addColumn(Ticket::getDateCreated).setHeader("Date Bought");
        grid.addComponentColumn(this::sellTicketButton);
        grid.setItems(ticketViewController.getTickets());

        add(grid);

        Button btn = new Button("Back");
        btn.addClickListener(buttonClickEvent -> this.getUI().ifPresent(ui -> ui.getPage().getHistory().back()));
        add(btn);

        setSizeFull();
    }

    private Button sellTicketButton(Ticket ticket) {
        Button button = new Button("Sell");
        button.addClickListener(e -> ticketViewController.sellTicket(ticket));
        return button;
    }
}
