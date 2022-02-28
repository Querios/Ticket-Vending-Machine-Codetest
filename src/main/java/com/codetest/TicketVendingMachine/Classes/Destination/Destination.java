package com.codetest.TicketVendingMachine.Classes.Destination;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table
public class Destination {
    @Id
    @Column(name = "destination_id")
    @GeneratedValue

    private Long id;
    private String name;
    private LocalDate date;
    private int price;

    public Destination() {
    }

    public Destination(String name, LocalDate date, int price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
