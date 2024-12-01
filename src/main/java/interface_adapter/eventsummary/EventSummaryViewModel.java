package main.java.interface_adapter.eventsummary;

import main.java.interface_adapter.ViewModel;

/**
 * The ViewModel for the Event Summary View.
 */
public class EventSummaryViewModel extends ViewModel<EventSummaryState> {

    public static final String TITLE_LABEL = "Event Booking Summary";

    public static final String BACK_BUTTON_LABEL = "Back";

    public EventSummaryViewModel() {
        super("event summary");
        setState(new EventSummaryState());
    }

    public void setSummaryText(String summaryText) {
        // Update the summaryText in the state
        getState().setSummaryText(summaryText);
        // Notify listeners that the state has changed
        firePropertyChanged();
    }
}

