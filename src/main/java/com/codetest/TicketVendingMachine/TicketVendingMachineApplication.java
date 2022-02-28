package com.codetest.TicketVendingMachine;

import com.codetest.TicketVendingMachine.Classes.MoneyBalance.MoneyBalance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
@ComponentScan
public class TicketVendingMachineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketVendingMachineApplication.class, args);
    }
}
