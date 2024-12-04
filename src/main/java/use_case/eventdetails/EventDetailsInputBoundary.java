package main.java.use_case.eventdetails;

import java.io.IOException;

public interface EventDetailsInputBoundary {
    /**
     * Executes the event details use case.
     * @param eventDetailsInputData the input data
     */
    void execute(EventDetailsInputData eventDetailsInputData) throws IOException;

    /**
     * Executes the switch to event forecast view use case.
     */
    void switchToEventForecastView();

    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();
}
