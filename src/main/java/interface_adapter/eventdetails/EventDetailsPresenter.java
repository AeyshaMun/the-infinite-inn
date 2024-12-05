package interface_adapter.eventdetails;

import interface_adapter.ViewManagerModel;
import interface_adapter.eventforecast.EventForecastState;
import interface_adapter.eventforecast.EventForecastViewModel;
import interface_adapter.main_page.MainPageViewModel;
import use_case.eventdetails.EventDetailsOutputBoundary;
import use_case.eventdetails.EventDetailsOutputData;


/**
 * The Presenter for the EventDetails Use Case.
 */
public class EventDetailsPresenter implements EventDetailsOutputBoundary {

    private final EventDetailsViewModel eventDetailsViewModel;
    private final EventForecastViewModel eventForecastViewModel;
    private final ViewManagerModel viewManagerModel;

    public EventDetailsPresenter(ViewManagerModel viewManagerModel,
                                 EventDetailsViewModel eventDetailsViewModel,
                                 EventForecastViewModel eventForecastViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.eventDetailsViewModel = eventDetailsViewModel;
        this.eventForecastViewModel = eventForecastViewModel;
    }

    @Override
    public void prepareSuccessView(EventDetailsOutputData response) {
        final EventForecastState eventForecastState = eventForecastViewModel.getState();
        eventForecastState.setEventDate(response.getEventDate());// send event date to the next use case!
        eventForecastState.setName(response.getName()); // send name to next use case
        eventForecastState.setPartySize((String.valueOf(response.getPartySize()))); // send party size over there
        this.eventForecastViewModel.setState(eventForecastState);
        eventForecastViewModel.firePropertyChanged();

        viewManagerModel.setState(eventForecastViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareNameFailView(String error) {
        final EventDetailsState eventDetailsState = eventDetailsViewModel.getState();
        eventDetailsState.setNameError(error);
        eventDetailsViewModel.firePropertyChanged();
    }

    @Override
    public void prepareEventDateFailView(String error) {
        final EventDetailsState eventDetailsState = eventDetailsViewModel.getState();
        eventDetailsState.setEventDateError(error);
        eventDetailsViewModel.firePropertyChanged();
    }

    @Override
    public void preparePartySizeFailView(String error) {
        final EventDetailsState eventDetailsState = eventDetailsViewModel.getState();
        eventDetailsState.setPartySizeError(error);
        eventDetailsViewModel.firePropertyChanged();
    }

    @Override
    public void switchToEventForecastView() {
        viewManagerModel.setState(eventForecastViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToHomeView() {
        viewManagerModel.setState(MainPageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

