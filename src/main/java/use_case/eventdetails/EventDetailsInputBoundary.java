package use_case.eventdetails;

public interface EventDetailsInputBoundary {
    /**
     * Executes the event details use case.
     * @param eventDetailsInputData the input data
     */
    void execute(EventDetailsInputData eventDetailsInputData);

    /**
     * Executes the switch to event forecast view use case.
     */
    void switchToEventForecastView();

    /**
     * Executes the switch to home view use case.
     */
    void switchToHomeView();
}
