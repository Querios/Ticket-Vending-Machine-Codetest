package com.codetest.TicketVendingMachine.FrontEnd.Seat;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Destination.DestinationService;
import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import com.codetest.TicketVendingMachine.Classes.Seat.SeatController;
import com.codetest.TicketVendingMachine.Classes.Seat.SeatService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SeatViewController {
    private final SeatService seatService;
    private long destinationId;

    @Autowired
    public SeatViewController(SeatService seatService) {
        this.seatService = seatService;
    }

    public void setDestinationId(long destinationId) {
        this.destinationId = destinationId;
    }

    public List<Seat> getSeats() {
        return seatService.getSeats(destinationId);
    }

    public void navigateToTicketSummaryView(Component cmp, Optional<Seat> selectedSeat) {
        selectedSeat.ifPresent(seat -> {
            if (seat.isAvailable())
                cmp.getUI().ifPresent(ui ->
                        ui.navigate("/TicketTransaction/" + seat.getId()));
        });
    }
}
