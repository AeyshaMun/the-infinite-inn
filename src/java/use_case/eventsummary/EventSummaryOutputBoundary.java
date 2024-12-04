package use_case.eventsummary;

/**
 * The output boundary for the Event Summary Use Case.
 */
public interface EventSummaryOutputBoundary {
    /**
     * Prepares the success view for the Event details Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(EventSummaryOutputData outputData);

    /**
     * Switches to the Home View.
     */
    void switchToHomeView();
}


