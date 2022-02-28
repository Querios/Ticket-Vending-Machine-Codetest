package com.codetest.TicketVendingMachine.FrontEnd.Destination;

import com.codetest.TicketVendingMachine.Classes.Destination.Destination;
import com.codetest.TicketVendingMachine.Classes.Destination.DestinationService;
import com.codetest.TicketVendingMachine.Classes.MoneyBalance.MoneyBalance;
import com.codetest.TicketVendingMachine.VisualState.AppVisualState;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.data.selection.SingleSelectionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class DestinationViewController {
    private final DestinationService destinationService;

    @Autowired
    public DestinationViewController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    public List<Destination> getDestinations() {
        return destinationService.getDestinations();
    }

    public void navigateToSeatsView(Component cmp, Optional<Destination> selectedDestination) {
        selectedDestination.ifPresent(destination ->
                cmp.getUI().ifPresent(ui ->
                        ui.navigate("/Seats/" + destination.getId())));
    }
}
