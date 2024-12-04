package main.java.interface_adapter.eventforecast;

import use_case.eventforecast.EventForecastInputBoundary;


/**
 * Controller for the Event Forecast Use Case.
 */
public class EventForecastController {

    private final EventForecastInputBoundary userEventForecastUseCaseInteractor;

    public EventForecastController(EventForecastInputBoundary userEventForecastUseCaseInteractor) {
        this.userEventForecastUseCaseInteractor = userEventForecastUseCaseInteractor;
    }

    /**
     * Executes the "switch to Summary" Use Case.
     */
    public void switchToSummaryView() {
            userEventForecastUseCaseInteractor.switchToSummaryView();
    }

    /**
     * Executes the "switch to HomeView" Use Case.
     */
    public void switchToHomeView() {
            userEventForecastUseCaseInteractor.switchToHomeView();

    }
}

