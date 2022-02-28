package com.codetest.TicketVendingMachine.FrontEnd.Controller;

import com.codetest.TicketVendingMachine.FrontEnd.Home.HomeView;
import com.codetest.TicketVendingMachine.VisualState.AppVisualState;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppController {
    private final AppVisualState visualState;

    @Autowired
    public AppController(AppVisualState visualState) {
        this.visualState = visualState;
    }

    public void navigateToSeatsView(Component cmp, String location) {
        cmp.getUI().ifPresent(ui ->
                ui.navigate(location));
    }
}
