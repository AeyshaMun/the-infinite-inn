package main.java.use_case.eventsummary;

public interface EventSummaryInputBoundary {
    /**
     * Executes the event details use case.
     * @param eventSummaryInputData the input data
     */
    void execute(EventSummaryInputData eventSummaryInputData);

    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();
}
