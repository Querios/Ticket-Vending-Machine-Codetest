package com.codetest.TicketVendingMachine.Config;

import com.codetest.TicketVendingMachine.Classes.ChangeStored.ChangeStored;
import com.codetest.TicketVendingMachine.Classes.ChangeStored.ChangeStoredRepository;
import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Destination.DestinationRepository;
import com.codetest.TicketVendingMachine.Classes.MoneyBalance.MoneyBalance;
import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import com.codetest.TicketVendingMachine.Classes.Seat.SeatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    @SessionScope
    public MoneyBalance moneyBalance() {
        return new MoneyBalance();
    }

    @Bean
    CommandLineRunner CommandLineRunner(
            DestinationRepository destinationRepository,
            SeatRepository seatRepository,
            ChangeStoredRepository changeStoredRepository) {
        return args -> {
            if (changeStoredRepository.count() == 0) {
                List<ChangeStored> changeStoredList = new ArrayList<>();
                changeStoredList.add(new ChangeStored("oneEuroCoin", 10));
                changeStoredList.add(new ChangeStored("twoEuroCoin", 10));
                changeStoredList.add(new ChangeStored("fiveEuroCoin", 10));
                changeStoredList.add(new ChangeStored("tenEuroCoin", 10));
                changeStoredList.add(new ChangeStored("twentyEuroCoin", 10));
                changeStoredList.add(new ChangeStored("fiftyEuroCoin", 10));
                changeStoredList.add(new ChangeStored("oneHundredEuroCoin", 10));
                changeStoredList.add(new ChangeStored("twoHundredEuroCoin", 10));
                changeStoredList.add(new ChangeStored("fiveHundredEuroCoin", 10));

                changeStoredRepository.saveAll(changeStoredList);
            }
            if (destinationRepository.count() == 0) {
                String[] destinationNames = {"Athens", "Thessaloniki", "Lamia"};
                List<Destination> destinationsList = new ArrayList<>();

                for (String name : destinationNames)
                    for (int i = 0; i < 3; i++)
                        destinationsList.add(new Destination(
                                name,
                                LocalDate.of(
                                        2022,
                                        Month.APRIL,
                                        20 + i
                                ),
                                20 + i * 5
                        ));
                destinationRepository.saveAll(destinationsList);

                List<Seat> seatsList = new ArrayList<>();

                for (Destination destination : destinationsList)
                    for (int i = 1; i < 10; i++)
                        seatsList.add(new Seat(
                                destination,
                                i,
                                true
                        ));
                seatRepository.saveAll(seatsList);
            }
        };
    }
}
