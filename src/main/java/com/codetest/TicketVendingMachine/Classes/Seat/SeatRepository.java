package com.codetest.TicketVendingMachine.Classes.Seat;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("SELECT s FROM Seat s WHERE s.destinationId = ?1")
    List<Seat> findSeatByDestinationId(Destination destination);

    @Modifying
    @Query("update Seat s set s.isAvailable = ?1 where s.id = ?2")
    void updateSeatAvailability(Boolean isAvailable, long seatId);
}
