package com.codetest.TicketVendingMachine.FrontEnd.TicketSummary;

import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import com.codetest.TicketVendingMachine.Classes.Seat.SeatService;
import com.codetest.TicketVendingMachine.Classes.Ticket.Ticket;
import com.codetest.TicketVendingMachine.Classes.Ticket.TicketService;
import com.vaadin.flow.component.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TicketSummaryViewController {
    private final TicketService ticketService;
    private Ticket ticket;
    private long seatId;

    @Autowired
    public TicketSummaryViewController(TicketService ticketService) {
        this.ticketService = ticketService;
        ticket = new Ticket();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
        createTicket();
    }

    private void createTicket() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        ticket = new Ticket(ticketService.getSeatById(seatId), date);
    }

    public void saveTicket(Component cmp) {
        if (ticket != null)
            navigateToTicketTransactionView(cmp, ticketService.saveNewTicket(ticket));
    }

    public void navigateToTicketTransactionView(Component cmp, Ticket savedTiket) {
        cmp.getUI().ifPresent(ui ->
                ui.navigate("/TicketTransaction/" + savedTiket.getId()));
    }

    public String getTicketDestinationName() {
        return ticketService.getTicketDestinationName(ticket.getSeatId().getId());
    }

    public String getTicketDate() {
        return ticketService.getTicketDate(ticket.getSeatId().getId());
    }

    public String getTicketSeatNo() {
        return ticketService.getSeatNo(ticket.getSeatId().getId());
    }

    public String getTicketPrice() {
        return ticketService.getTicketPrice(ticket.getSeatId().getId());
    }
}
