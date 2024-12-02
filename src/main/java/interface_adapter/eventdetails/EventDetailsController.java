package interface_adapter.eventdetails;

import use_case.eventdetails.EventDetailsInputBoundary;
import use_case.eventdetails.EventDetailsInputData;

/**
 * Controller for the Event Details Use Case.
 */
public class EventDetailsController {

    private final EventDetailsInputBoundary userEventDetailsUseCaseInteractor;

    public EventDetailsController(EventDetailsInputBoundary userEventDetailsUseCaseInteractor) {
        this.userEventDetailsUseCaseInteractor = userEventDetailsUseCaseInteractor;
    }

    /**
     * Executes the Event Details Use Case.
     * @param name the name of the client
     * @param eventDate the date of the event
     * @param partySizeStr the number of people attending the event
     */
    public void execute(String name, String eventDate, String partySizeStr) {
        try {
            int partySize = convertToInt(partySizeStr);

            final EventDetailsInputData eventDetailsInputData = new EventDetailsInputData(
                    name, eventDate, partySize);

            userEventDetailsUseCaseInteractor.execute(eventDetailsInputData);
        }
        catch (IllegalArgumentException e) {
            int partySize = -1;

            final EventDetailsInputData eventDetailsInputData = new EventDetailsInputData(
                    name, eventDate, partySize);

            userEventDetailsUseCaseInteractor.execute(eventDetailsInputData);
        }
    }

    /**
     * Executes the "switch to EventForecastView" Use Case.
     */
    public void switchToEventForecastView() {
        userEventDetailsUseCaseInteractor.switchToEventForecastView();
    }

    /**
     * Executes the "switch to HomeView" Use Case.
     */
    public void switchToHomeView() {
        userEventDetailsUseCaseInteractor.switchToHomeView();

    }

    // Conversion method
    public int convertToInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + input);
        }
    }
}
