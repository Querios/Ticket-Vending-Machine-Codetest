package com.codetest.TicketVendingMachine.Classes.Seat;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Ticket.Ticket;
import com.codetest.TicketVendingMachine.Classes.Ticket.TicketService;
import com.codetest.TicketVendingMachine.VisualState.AppVisualState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping(path = "/seats")
public class SeatController {
    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getSeats(Long destinationId) {
        return seatService.getSeats(destinationId);
    }

    @PostMapping
    public RedirectView navigateToTicketReview(
            @RequestBody Seat seat,
            @ModelAttribute("visualState") AppVisualState visualState,
            RedirectAttributes attributes) {
        visualState.setSeat(seat);
        attributes.addFlashAttribute("visualState", visualState);
        return new RedirectView("/ticket");
    }
}
