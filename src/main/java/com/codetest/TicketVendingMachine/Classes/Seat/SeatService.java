package com.codetest.TicketVendingMachine.Classes.Seat;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Destination.DestinationRepository;
import com.codetest.TicketVendingMachine.Classes.Ticket.Ticket;
import com.codetest.TicketVendingMachine.Classes.Ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final DestinationRepository destinationRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository, DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeats(Long destinationId) {
        return seatRepository.findSeatByDestinationId(destinationRepository.getById(destinationId));
    }

    public Destination getDestinationBySeat(Destination destination) {
        return destinationRepository.findById(destination.getId()).get();
    }

}
