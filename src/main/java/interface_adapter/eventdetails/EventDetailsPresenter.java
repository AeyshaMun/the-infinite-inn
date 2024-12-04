package main.java.interface_adapter.eventdetails;

import interface_adapter.ViewManagerModel;
import main.java.interface_adapter.eventforecast.EventForecastState;
import interface_adapter.eventforecast.EventForecastViewModel;
import main.java.interface_adapter.main_page.MainPageViewModel;
import main.java.use_case.eventdetails.EventDetailsOutputBoundary;
import main.java.use_case.eventdetails.EventDetailsOutputData;
import use_case.eventforecast.EventForecastInputBoundary;
import main.java.use_case.eventforecast.EventForecastFirstInputData;

import java.io.IOException;


/**
 * The Presenter for the EventDetails Use Case.
 */
public class EventDetailsPresenter implements EventDetailsOutputBoundary {

    private final EventDetailsViewModel eventDetailsViewModel;
    private final EventForecastViewModel eventForecastViewModel;
    private final ViewManagerModel viewManagerModel;
    private final EventForecastInputBoundary userEventForecastUseCaseInteractor;
    private final MainPageViewModel homeViewModel;


    public EventDetailsPresenter(ViewManagerModel viewManagerModel,
                                 EventDetailsViewModel eventDetailsViewModel,
                                 EventForecastViewModel eventForecastViewModel, EventForecastInputBoundary userEventForecastUseCaseInteractor, MainPageViewModel homeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.eventDetailsViewModel = eventDetailsViewModel;
        this.eventForecastViewModel = eventForecastViewModel;
        this.userEventForecastUseCaseInteractor = userEventForecastUseCaseInteractor;
        this.homeViewModel = homeViewModel;
    }

    @Override
    public void prepareSuccessView(EventDetailsOutputData response) throws IOException {
        final EventForecastState eventForecastState = eventForecastViewModel.getState();
        eventForecastState.setEventDate(response.getEventDate());// send event date to the next use case!
        eventForecastState.setName(response.getName()); // send name to next use case
        eventForecastState.setPartySize((String.valueOf(response.getPartySize()))); // send party size over there
        this.eventForecastViewModel.setState(eventForecastState);
        eventForecastViewModel.firePropertyChanged();

        viewManagerModel.setState(eventForecastViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        final EventForecastFirstInputData eventForecastInputData = new use_case.eventforecast.EventForecastFirstInputData(
                response.getName(), response.getEventDate(), response.getPartySize());
        userEventForecastUseCaseInteractor.execute(eventForecastInputData);
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
        viewManagerModel.setState(homeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

