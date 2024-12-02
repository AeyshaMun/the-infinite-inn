package main.java.use_case.eventforecast;

import main.java.use_case.eventforecast.EventForecastInputData;

public interface EventForecastInputBoundary {
    /**
     * Executes the event details use case.
     * @param eventForecastInputData the input data
     */
    void execute(EventForecastInputData eventForecastInputData);

    /**
     * Executes the switch to summary view use case.
     */
    void switchToSummaryView();

    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();
}
