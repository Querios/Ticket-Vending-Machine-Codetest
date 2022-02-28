package com.codetest.TicketVendingMachine.Classes.Destination;

import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
