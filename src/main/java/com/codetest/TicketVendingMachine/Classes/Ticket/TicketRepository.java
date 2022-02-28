package com.codetest.TicketVendingMachine.Classes.Ticket;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
