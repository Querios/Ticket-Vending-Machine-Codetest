package com.codetest.TicketVendingMachine.Classes.ChangeStored;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Destination.DestinationService;
import com.codetest.TicketVendingMachine.VisualState.AppVisualState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public class ChangeStoredController {
    private final ChangeStoredService changeStoredService;

    @Autowired
    public ChangeStoredController(ChangeStoredService changeStoredService) {
        this.changeStoredService = changeStoredService;
    }

    @GetMapping
    public List<ChangeStored> getChangeStored() {
        return changeStoredService.getChangeStored();
    }

    /*
    @PostMapping
    public RedirectView navigateToSeatsSelection(
            @RequestBody Destination destination,
            @ModelAttribute("visualState") AppVisualState visualState,
            RedirectAttributes attributes) {
        visualState.setDestination(destination);
        attributes.addFlashAttribute("visualState", visualState);
        return new RedirectView("/seats");
    }
    */
}
