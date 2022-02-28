package com.codetest.TicketVendingMachine.FrontEnd.TicketSummary;

import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import com.codetest.TicketVendingMachine.FrontEnd.Seat.SeatViewController;
import com.codetest.TicketVendingMachine.FrontEnd.Ticket.TicketViewController;
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

@Route("/TicketSummary")
@PageTitle("Ticket Summary | Ticket Vending Machine")
public class TicketSummaryView extends VerticalLayout implements HasUrlParameter<Long> {
    public final TicketSummaryViewController ticketSummaryViewController;

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        ticketSummaryViewController.setSeatId(parameter);

        HorizontalLayout destinationHl = new HorizontalLayout();
        destinationHl.add(new Label("Destination: "));
        destinationHl.add(new Label(ticketSummaryViewController.getTicketDestinationName()));
        add(destinationHl);

        HorizontalLayout dateHl = new HorizontalLayout();
        dateHl.add(new Label("Date: "));
        dateHl.add(new Label(ticketSummaryViewController.getTicketDate()));
        add(dateHl);

        HorizontalLayout seatNoHl = new HorizontalLayout();
        seatNoHl.add(new Label("Seat Number: "));
        seatNoHl.add(new Label(ticketSummaryViewController.getTicketSeatNo()));
        add(seatNoHl);

        HorizontalLayout ticketPriceHl = new HorizontalLayout();
        ticketPriceHl.add(new Label("Price: "));
        ticketPriceHl.add(new Label(ticketSummaryViewController.getTicketPrice()));
        add(ticketPriceHl);

        HorizontalLayout buttonHl = new HorizontalLayout();

        Button confirmButton = new Button("Confirm");
        confirmButton.addClickListener(buttonClickEvent -> ticketSummaryViewController.saveTicket(this));
        buttonHl.add(confirmButton);

        Button backButton = new Button("Back");
        backButton.addClickListener(buttonClickEvent -> this.getUI().ifPresent(ui -> ui.getPage().getHistory().back()));
        buttonHl.add(backButton);

        add(buttonHl);

        setSizeFull();
    }

    @Autowired
    public TicketSummaryView(TicketSummaryViewController ticketSummaryViewController) {
        this.ticketSummaryViewController = ticketSummaryViewController;
    }
}
