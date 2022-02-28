package com.codetest.TicketVendingMachine.FrontEnd.TicketTransaction;

import com.codetest.TicketVendingMachine.Classes.Coin.Coin;
import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import com.codetest.TicketVendingMachine.Classes.Ticket.Ticket;
import com.codetest.TicketVendingMachine.Classes.Ticket.TicketService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TicketTransactionViewController {
    private final TicketService ticketService;
    private final List<Coin> coinList;
    private long seatId;
    private int totalCoinValue;
    private int ticketPrice;

    @Autowired
    public TicketTransactionViewController(TicketService ticketService) {
        this.ticketService = ticketService;
        coinList = new ArrayList<>();
        coinList.add(new Coin("One Euro", 1));
        coinList.add(new Coin("Two Euros", 2));
        coinList.add(new Coin("Five Euros", 5));
        coinList.add(new Coin("Ten Euros", 10));
        coinList.add(new Coin("Twenty Euros", 20));
        coinList.add(new Coin("Fifty Euros", 50));
        coinList.add(new Coin("One Hundred Euros", 100));
        coinList.add(new Coin("Two Hundred Euros", 200));
        coinList.add(new Coin("Five Hundred Euros", 500));
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
        ticketPrice = ticketService.getTicketPriceValue(seatId);
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public int getTotalCoinValue() {
        return totalCoinValue;
    }

    public void setTotalCoinValue(int totalCoinValue) {
        this.totalCoinValue = totalCoinValue;
    }

    public String calculatePayment(int coinValue, Component cmp) {
        totalCoinValue += coinValue;
        if (ticketPrice <= totalCoinValue) {
            performTransaction(cmp);
        }
        return String.valueOf(totalCoinValue);
    }

    private void performTransaction(Component cmp) {
        ticketService.saveNewTicket(createTicket());
        ticketService.reserveSeat(seatId);
        Notification notification = Notification.show("TICKET BOUGHT!");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        navigateToHomeViewView(cmp);
    }

    private void navigateToHomeViewView(Component cmp) {
        cmp.getUI().ifPresent(ui ->
                ui.navigate("/Home"));
    }

    private Ticket createTicket() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return new Ticket(ticketService.getSeatById(seatId), date);
    }

    public String getTicketPrice() {
        return ticketService.getTicketPrice(seatId);
    }
}
