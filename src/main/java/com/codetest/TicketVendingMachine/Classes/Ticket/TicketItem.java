package com.codetest.TicketVendingMachine.Classes.Ticket;

public class TicketItem {
    private Long ticketId;
    private String destinationName;
    private String ticketDate;
    private String ticketPrice;
    private String ticketNo;

    public TicketItem(Long ticketId, String destinationName, String ticketDate, String ticketPrice, String ticketNo) {
        this.ticketId = ticketId;
        this.destinationName = destinationName;
        this.ticketDate = ticketDate;
        this.ticketPrice = ticketPrice;
        this.ticketNo = ticketNo;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }
}
