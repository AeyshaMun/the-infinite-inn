package main.java.use_case.eventforecast;

import java.io.IOException;

public interface EventForecastInputBoundary {
    /**
     * Executes the event details use case.
     * @param eventForecastInputData the input data
     */
    void execute(EventForecastFirstInputData eventForecastInputData, EventForecastSecondInputData eventForecastSecondInputData) throws IOException;

    /**
     * Executes the switch to summary view use case.
     */
    void switchToSummaryView();

    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();
}
