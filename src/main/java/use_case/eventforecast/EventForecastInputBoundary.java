package use_case.eventforecast;

import use_case.eventforecast.EventForecastInputData;

import java.io.IOException;

public interface EventForecastInputBoundary {
    /**
     * Executes the event details use case.
     * @param eventForecastInputData the input data
     */
    void execute(EventForecastInputData eventForecastInputData) throws IOException;

    /**
     * Executes the switch to summary view use case.
     */
    void switchToSummaryView();

    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();
}
