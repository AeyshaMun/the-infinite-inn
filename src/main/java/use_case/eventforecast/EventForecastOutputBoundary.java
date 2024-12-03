package use_case.eventforecast;

import entity.EventForecast;
import use_case.eventforecast.EventForecastOutputData;

/**
 * The output boundary for the Event Forecast Use Case.
 */
public interface EventForecastOutputBoundary {
    /**
     * Prepares the success view for the Event details Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(EventForecastOutputData outputData);

    /**
     * Prepares the failure view for the Event Forecast Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Summary View.
     */
    void switchToSummaryView();

    /**
     * Switches to the Home View.
     */
    void switchToHomeView();

    void prepareForecastView(EventForecast eventForecast);
}

