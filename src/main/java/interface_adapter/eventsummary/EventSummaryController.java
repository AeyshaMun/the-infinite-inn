package main.java.interface_adapter.eventsummary;

import main.java.use_case.eventsummary.EventSummaryInputBoundary;
import main.java.use_case.eventsummary.EventSummaryInputData;

/**
 * Controller for the Event Summary Use Case.
 */
public class EventSummaryController {

    private final EventSummaryInputBoundary userEventSummaryUseCaseInteractor;

    public EventSummaryController(EventSummaryInputBoundary userEventSummaryUseCaseInteractor) {
        this.userEventSummaryUseCaseInteractor = userEventSummaryUseCaseInteractor;
    }

    /**
     * Executes the Event Summary Use Case.
     * @param name the name of the client
     * @param eventDate the date of the event
     * @param partySizeStr the number of people attending the event
     * @param isIndoor whether or not the event hall is indoors
     * @param roomNumber the room number for the event hall
     * @param amountDue the amount to be paid
     */
    public void execute(String name, String eventDate, String partySizeStr, boolean isIndoor, int roomNumber, double amountDue) {
        int partySize = convertToInt(partySizeStr);

        final EventSummaryInputData eventSummaryInputData = new EventSummaryInputData(
                    name, eventDate, partySize, isIndoor, roomNumber, amountDue);

        userEventSummaryUseCaseInteractor.execute(eventSummaryInputData); // pass off to interactor
    }

    /**
     * Executes the "switch to HomeView" Use Case.
     */
    public void switchToHomeView() {
        userEventSummaryUseCaseInteractor.switchToHomeView();

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


