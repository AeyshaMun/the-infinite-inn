package main.java.use_case.eventdetails;

/**
 * The output boundary for the Event Details Use Case.
 */
public interface EventDetailsOutputBoundary {
    /**
     * Prepares the success view for the Event details Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(EventDetailsOutputData outputData);

    /**
     * Prepares the name failure view for the Event Details Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareNameFailView(String errorMessage);

    /**
     * Prepares the event date failure view for the Event Details Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareEventDateFailView(String errorMessage);

    /**
     * Prepares the party size failure view for the Event Details Use Case.
     * @param errorMessage the explanation of the failure
     */
    void preparePartySizeFailView(String errorMessage);

    /**
     * Switches to the Event Forecast View.
     */
    void switchToEventForecastView();

    /**
     * Switches to the Home View.
     */
    void switchToHomeView();
}
