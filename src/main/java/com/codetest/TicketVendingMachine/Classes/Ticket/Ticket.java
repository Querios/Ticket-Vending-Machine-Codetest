package com.codetest.TicketVendingMachine.Classes.Ticket;

import com.codetest.TicketVendingMachine.Classes.Seat.Seat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue

    private Long id;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seatId;

    private Date dateCreated;

    @Transient
    private String destinationName;
    @Transient
    private String destinationDate;
    @Transient
    private String destinationPrice;
    @Transient
    private String seatNo;

    public Ticket() {
    }

    public Ticket(Seat seatId, Date dateCreated) {
        this.seatId = seatId;
        this.dateCreated = dateCreated;
    }

    public Ticket(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public Seat getSeatId() {
        return seatId;
    }

    public void setSeatId(Seat seatId) {
        this.seatId = seatId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDestinationName() {
        return seatId.getDestinationName();
    }

    public String getDestinationDate() {
        return String.valueOf(seatId.getDestinationId().getDate());
    }

    public String getDestinationPrice() {
        return String.valueOf(seatId.getDestinationId().getPrice());
    }

    public String getSeatNo() {
        return String.valueOf(seatId.getSeatNo());
    }
}
