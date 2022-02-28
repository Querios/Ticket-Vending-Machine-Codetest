package com.codetest.TicketVendingMachine.FrontEnd.Seat;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import com.codetest.TicketVendingMachine.FrontEnd.Destination.DestinationViewController;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/Seats")
@PageTitle("Seats | Ticket Vending Machine")

public class SeatView extends VerticalLayout implements HasUrlParameter<Long> {

    public final SeatViewController seatViewController;

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        seatViewController.setDestinationId(parameter);
        var grid = new Grid<Seat>();

        grid.setSizeFull();
        grid.addColumn(Seat::getId).setHeader("ID");
        grid.addColumn(Seat::getDestinationName).setHeader("Destination");
        grid.addColumn(Seat::getSeatNo).setHeader("Seat Number");
        grid.addColumn(Seat::isAvailableAsText).setHeader("Availability");
        grid.setItems(seatViewController.getSeats());

        grid.addSelectionListener(eventListenerEvent -> seatViewController.navigateToTicketSummaryView(this, eventListenerEvent.getFirstSelectedItem()));
        add(grid);

        Button btn = new Button("Back");
        btn.addClickListener(buttonClickEvent -> this.getUI().ifPresent(ui -> ui.getPage().getHistory().back()));
        add(btn);

        setSizeFull();
    }

    @Autowired
    public SeatView(SeatViewController seatViewController) {
        this.seatViewController = seatViewController;
    }
}
