package com.codetest.TicketVendingMachine.Classes.Destination;

import com.codetest.TicketVendingMachine.VisualState.AppVisualState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping(path = "/destination")
public class DestinationController {
    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getDestinations() {
        return destinationService.getDestinations();
    }

    @PostMapping
    public RedirectView navigateToSeatsSelection(
            @RequestBody Destination destination,
            @ModelAttribute("visualState") AppVisualState visualState,
            RedirectAttributes attributes) {
        visualState.setDestination(destination);
        attributes.addFlashAttribute("visualState", visualState);
        return new RedirectView("/seats");
    }
}
