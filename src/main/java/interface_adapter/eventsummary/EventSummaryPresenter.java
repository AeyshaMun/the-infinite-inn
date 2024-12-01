package main.java.interface_adapter.eventsummary;

import main.java.interface_adapter.ViewManagerModel;
import main.java.use_case.eventsummary.EventSummaryOutputBoundary;
import main.java.use_case.eventsummary.EventSummaryOutputData;

/**
 * The Presenter for the EventSummary Use Case.
 */
public class EventSummaryPresenter implements EventSummaryOutputBoundary {

    private final EventSummaryViewModel eventSummaryViewModel;
    private final ViewManagerModel viewManagerModel;

    public EventSummaryPresenter(ViewManagerModel viewManagerModel,
                                  EventSummaryViewModel summaryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.eventSummaryViewModel = summaryViewModel;
    }

    @Override
    public void prepareSuccessView(EventSummaryOutputData outputData) {
        String summaryText = formatEventSummary(outputData);
        eventSummaryViewModel.setSummaryText(summaryText); // Assuming a setter for summaryText in ViewModel
        // Notify the view that the state has changed
        eventSummaryViewModel.firePropertyChanged();
    }

    @Override
    public void switchToHomeView() {
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    private String formatEventSummary(EventSummaryOutputData outputData) {
        StringBuilder summary = new StringBuilder();
        summary.append("Event Summary:\n\n");
        summary.append("Name: ").append(outputData.getName()).append("\n");
        summary.append("Event Date: ").append(outputData.getEventDate()).append("\n");
        summary.append("Party Size: ").append(outputData.getPartySize()).append("\n");
        summary.append("Room Number: ").append(outputData.getRoomNumber()).append("\n");
        summary.append("Event Hall Type: ").append(outputData.getIsIndoor() ? "Indoor" : "Outdoor").append("\n");
        summary.append("Amount Due: $").append(outputData.getAmountDue()).append("\n");

        return summary.toString();
    }
}
