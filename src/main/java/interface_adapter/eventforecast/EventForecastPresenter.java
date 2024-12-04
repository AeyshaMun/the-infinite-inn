package main.java.interface_adapter.eventforecast;

import main.java.entity.eventbooking.EventForecast;
import main.java.interface_adapter.ViewManagerModel;
import main.java.interface_adapter.eventsummary.EventSummaryState;
import main.java.interface_adapter.eventsummary.EventSummaryViewModel;
import main.java.use_case.eventforecast.EventForecastOutputBoundary;
import main.java.use_case.eventforecast.EventForecastOutputData;
import interface_adapter.eventforecast.EventForecastViewModel;
import use_case.eventforecast.EventForecastInputBoundary;
import main.java.interface_adapter.main_page.MainPageViewModel;

import java.io.IOException;

/**
 * The Presenter for the EventForecast Use Case.
 */
public class EventForecastPresenter implements EventForecastOutputBoundary {

    private final EventForecastViewModel eventForecastViewModel;
    private final EventSummaryViewModel eventSummaryViewModel;
    private final ViewManagerModel viewManagerModel;
    private final MainPageViewModel homeViewModel;


    public EventForecastPresenter(ViewManagerModel viewManagerModel,
                                  EventForecastViewModel eventForecastViewModel,
                                  EventSummaryViewModel summaryViewModel, MainPageViewModel mainPageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.eventSummaryViewModel = summaryViewModel;
        this.eventForecastViewModel = eventForecastViewModel;
        this.homeViewModel = mainPageViewModel;
    }

    @Override
    public void prepareSuccessView(EventForecastOutputData response) throws IOException {
        final EventSummaryState eventSummaryState = eventSummaryViewModel.getState();
        eventSummaryState.setEventDate(response.getEventDate());// send event date to the next use case!
        eventSummaryState.setName(response.getName()); // send name to next use case
        eventSummaryState.setPartySize((String.valueOf(response.getPartySize()))); // send party size over there
        eventSummaryState.setIsIndoor(response.isIndoor()); // send is indoor over there
        eventSummaryState.setRoomNumber(response.getRoomNumber()); // send room number over there
        eventSummaryState.setAmountDue(response.getAmountDue()); // send amount due over there

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

        // Notify that the state has been updated
        eventForecastViewModel.firePropertyChanged();
    }

    @Override
    public void prepareChoices(boolean isUnsuitableForOutdoors) {
        // Update EventForecastViewModel with weather data and suitability
        final EventForecastState eventForecastState = eventForecastViewModel.getState();
        eventForecastState.setOutdoorSuitable(isUnsuitableForOutdoors);

        // Notify that the state has been updated
        eventForecastViewModel.firePropertyChanged();

    }
}


