package com.codetest.TicketVendingMachine.FrontEnd.Ticket;

import com.codetest.TicketVendingMachine.Classes.Seat.SeatService;
import com.codetest.TicketVendingMachine.Classes.Ticket.Ticket;
import com.codetest.TicketVendingMachine.Classes.Ticket.TicketItem;
import com.codetest.TicketVendingMachine.Classes.Ticket.TicketService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketViewController {
    private final TicketService ticketService;

    public TicketViewController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public List<Ticket> getTickets() {
        return ticketService.getAllTickets();
    }

    public void sellTicket(Ticket ticket) {
        ticketService.sellTicket(ticket.getId());
    }
}
