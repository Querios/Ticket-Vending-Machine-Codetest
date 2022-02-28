package com.codetest.TicketVendingMachine.Classes.Destination;

import com.codetest.TicketVendingMachine.Classes.Seat.Seat;
import com.codetest.TicketVendingMachine.Classes.Seat.SeatRepository;
import com.codetest.TicketVendingMachine.VisualState.AppVisualState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Service
public class DestinationService {
    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }


    public List<Destination> getDestinations() {
        return destinationRepository.findAll();
    }
}
