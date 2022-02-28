package com.codetest.TicketVendingMachine.Classes.Ticket;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Destination.DestinationRepository;
import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import com.codetest.TicketVendingMachine.Classes.Seat.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;
    private final DestinationRepository destinationRepository;

    private Seat seat;
    private Destination destination;

    @Autowired
    public TicketService(
            TicketRepository ticketRepository,
            SeatRepository seatRepository,
            DestinationRepository destinationRepository) {
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
        this.destinationRepository = destinationRepository;
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public Seat getSeatById(long seatId) {
        return seatRepository.getById(seatId);
    }

    public Ticket saveNewTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    private Destination getDestination(long seatId) {
        long destinationId = getSeatById(seatId).getDestinationId().getId();
        return destinationRepository.findById(destinationId).get();
    }

    public String getTicketDestinationName(long seatId) {
        return String.valueOf(getDestination(seatId).getName());
    }

    public String getTicketDate(long seatId) {
        return String.valueOf(getDestination(seatId).getDate());
    }

    public int getTicketPriceValue(long seatId) {
        return getDestination(seatId).getPrice();
    }

    public String getTicketPrice(long seatId) {
        return String.valueOf(getTicketPriceValue(seatId));
    }

    public String getSeatNo(Long seatId) {
        return String.valueOf(getSeatNo(seatId));
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void sellTicket(Long ticketId) {
        long seatId = ticketRepository.getById(ticketId).getSeatId().getId();
        ticketRepository.deleteById(ticketId);
        unreserveSeat(seatId);
    }

    public void reserveSeat(long seatId) {
        seatRepository.updateSeatAvailability(false, seatId);
    }

    public void unreserveSeat(long seatId) {
        seatRepository.updateSeatAvailability(true, seatId);
    }
}
