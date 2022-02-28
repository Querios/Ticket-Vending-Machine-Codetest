package com.codetest.TicketVendingMachine.Classes.Seat;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Seat {
    @Id
    @Column(name = "seat_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destinationId;

    private int seatNo;
    private boolean isAvailable;

    public Seat(Destination destinationId, int seatNo, boolean isAvailable) {
        this.destinationId = destinationId;
        this.seatNo = seatNo;
        this.isAvailable = isAvailable;
    }

    public Seat() {
    }

    public Long getId() {
        return id;
    }

    public Destination getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Destination destinationId) {
        this.destinationId = destinationId;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String isAvailableAsText() {
        return isAvailable ? "Yes" : "No";
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDestinationName() {
        return destinationId.getName();
    }
}
