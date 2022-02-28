package com.codetest.TicketVendingMachine.Classes.ChangeStored;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Destination.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChangeStoredService {
    private final ChangeStoredRepository changeStoredRepository;

    @Autowired
    public ChangeStoredService(ChangeStoredRepository changeStoredRepository) {
        this.changeStoredRepository = changeStoredRepository;
    }


    public List<ChangeStored> getChangeStored() {
        return changeStoredRepository.findAll();
    }
}
