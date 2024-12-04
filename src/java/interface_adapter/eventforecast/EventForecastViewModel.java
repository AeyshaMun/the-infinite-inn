package java.interface_adapter.eventforecast;

import main.java.interface_adapter.ViewModel;

/**
 * The ViewModel for the Event Details View.
 */
public class EventForecastViewModel extends ViewModel<EventForecastState> {

    public static final String TITLE_LABEL = "Event Forecast";

    public static final String INDOORS_BUTTON_LABEL = "Indoor Event Hall";
    public static final String OUTDOORS_BUTTON_LABEL = "Outdoor Event Hall";

    public static final String BACK_BUTTON_LABEL = "Back";
    public static final String SUBMIT_BUTTON_LABEL = "Submit Booking";

    public EventForecastViewModel() {
        super("event forecast");
        setState(new EventForecastState());
    }
}
