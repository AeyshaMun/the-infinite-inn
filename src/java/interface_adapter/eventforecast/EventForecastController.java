package java.interface_adapter.eventforecast;

import java.use_case.eventforecast.EventForecastInputBoundary;
import java.use_case.eventforecast.EventForecastInputData;


/**
 * Controller for the Event Forecast Use Case.
 */
public class EventForecastController {

    private final EventForecastInputBoundary userEventForecastUseCaseInteractor;

    public EventForecastController(EventForecastInputBoundary userEventForecastUseCaseInteractor) {
        this.userEventForecastUseCaseInteractor = userEventForecastUseCaseInteractor;
    }

    /**
     * Executes the Event Forecast Use Case.
     * @param name the name of the client
     * @param eventDate the date of the event
     * @param partySizeStr the number of people attending the event
     * @param isIndoor whether or not the event hall is indoors
     */
    public void execute(String name, String eventDate, String partySizeStr, boolean isIndoor) {
        try {
            int partySize = convertToInt(partySizeStr);

            final EventForecastInputData eventForecastInputData = new EventForecastInputData(
                    name, eventDate, partySize, isIndoor);

            userEventForecastUseCaseInteractor.execute(eventForecastInputData); // pass off to interactor
        } catch (IllegalArgumentException e) {
            int partySize = -1;

            final EventForecastInputData eventForecastInputData = new EventForecastInputData(
                    name, eventDate, partySize, isIndoor);

            userEventForecastUseCaseInteractor.execute(eventForecastInputData); // pass off to interactor
        }
    }

    /**
     * Executes the "switch to Summary" Use Case.
     */
    public void switchToSummaryView() {
            userEventForecastUseCaseInteractor.switchToSummaryView();
    }

    /**
     * Executes the "switch to HomeView" Use Case.
     */
    public void switchToHomeView() {
            userEventForecastUseCaseInteractor.switchToHomeView();

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

