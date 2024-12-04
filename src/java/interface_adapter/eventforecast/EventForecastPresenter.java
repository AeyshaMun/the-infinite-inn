package java.interface_adapter.eventforecast;

import entity.EventForecast;
import java.interface_adapter.ViewManagerModel;
import java.interface_adapter.eventsummary.EventSummaryState;
import java.interface_adapter.eventsummary.EventSummaryViewModel;
import java.use_case.eventforecast.EventForecastOutputBoundary;
import java.use_case.eventforecast.EventForecastOutputData;

/**
 * The Presenter for the EventForecast Use Case.
 */
public class EventForecastPresenter implements EventForecastOutputBoundary {

    private final EventForecastViewModel eventForecastViewModel;
    private final EventSummaryViewModel eventSummaryViewModel;
    private final ViewManagerModel viewManagerModel;

    public EventForecastPresenter(ViewManagerModel viewManagerModel,
                                  EventForecastViewModel eventForecastViewModel,
                                  EventSummaryViewModel summaryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.eventSummaryViewModel = summaryViewModel;
        this.eventForecastViewModel = eventForecastViewModel;
    }

    @Override
    public void prepareSuccessView(EventForecastOutputData response) {
        final EventSummaryState eventSummaryState = eventSummaryViewModel.getState();
        eventSummaryState.setEventDate(response.getEventDate());// send event date to the next use case!
        eventSummaryState.setName(response.getName()); // send name to next use case
        eventSummaryState.setPartySize((String.valueOf(response.getPartySize()))); // send party size over there
        eventSummaryState.setIsIndoor(response.isIndoor()); // send party size over there
        eventSummaryState.setRoomNumber(response.getRoomNumber()); // send party size over there
        eventSummaryState.setAmountDue(response.getAmountDue()); // send party size over there

        this.eventSummaryViewModel.setState(eventSummaryState);
        eventSummaryViewModel.firePropertyChanged();

        viewManagerModel.setState(eventSummaryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final EventForecastState eventForecastState = eventForecastViewModel.getState();
        eventForecastState.setError(error);
        eventForecastViewModel.firePropertyChanged();
    }

    @Override
    public void switchToSummaryView() {
        viewManagerModel.setState(eventSummaryViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToHomeView() {
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareForecastView(EventForecast eventForecast) {
        // Update EventForecastViewModel with weather data and suitability
        final EventForecastState eventForecastState = eventForecastViewModel.getState();
        eventForecastState.setWeatherDescription(eventForecastState.getWeatherDescription());
        eventForecastState.setEstimated(eventForecast.isEstimated());
        eventForecastState.setOutdoorSuitable(eventForecastState.isOutdoorSuitable());

        // Notify that the state has been updated
        eventForecastViewModel.firePropertyChanged();
    }
}


