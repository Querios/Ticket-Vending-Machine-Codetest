package com.codetest.TicketVendingMachine.Classes.Ticket;

import com.codetest.TicketVendingMachine.VisualState.AppVisualState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping(path = "/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @PostMapping
    public RedirectView executeTicketSale(
            @RequestBody Ticket ticket,
            @ModelAttribute("visualState") AppVisualState visualState,
            RedirectAttributes attributes) {
        ticketService.saveNewTicket(ticket);
        attributes.addFlashAttribute("visualState", visualState);
        return new RedirectView("/ticketSubmission");
    }
}
