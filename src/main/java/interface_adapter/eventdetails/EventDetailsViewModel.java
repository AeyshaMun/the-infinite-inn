package interface_adapter.eventdetails;

import main.java.interface_adapter.ViewModel;

/**
 * The ViewModel for the Event Details View.
 */
public class EventDetailsViewModel extends ViewModel<EventDetailsState> {

    public static final String TITLE_LABEL = "Enter Event/Client Details";
    public static final String NAME_LABEL = "Enter client name";
    public static final String EVENT_DATE_LABEL = "Enter event date";
    public static final String PARTY_SIZE_LABEL = "Enter party size";

    public static final String BACK_BUTTON_LABEL = "Back";
    public static final String NEXT_BUTTON_LABEL = "Next";

    public EventDetailsViewModel() {
        super("event details");
        setState(new EventDetailsState());
    }

}
