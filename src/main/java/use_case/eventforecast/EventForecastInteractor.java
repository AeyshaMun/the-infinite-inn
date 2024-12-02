package use_case.eventforecast;

import entity.*;
import interface_adapter.eventforecast.WeatherService;

/**
 * The Event Forecast Interactor.
 */
public class EventForecastInteractor implements EventForecastInputBoundary {
    private final EventForecastUserDataAccessInterface eventBookingDataAccessObject;
    private final EventForecastOutputBoundary eventBookingPresenter;
    private final ClientFactory clientFactory;
    private final EventHallFactory eventHallFactory;
    private final EventBookingFactory eventBookingFactory;
    private final WeatherService weatherService; // Add weather service dependency


    public EventForecastInteractor(EventForecastUserDataAccessInterface eventForecastDataAccessInterface,
                                   EventForecastOutputBoundary eventForecastOutputBoundary,
                                   ClientFactory clientFactory, EventHallFactory eventHallFactory,
                                   EventBookingFactory eventBookingFactory, WeatherService weatherService) {
        this.eventBookingDataAccessObject = eventForecastDataAccessInterface;
        this.eventBookingPresenter = eventForecastOutputBoundary;
        this.clientFactory = clientFactory;
        this.eventHallFactory = eventHallFactory;
        this.eventBookingFactory = eventBookingFactory;
        this.weatherService = weatherService;
    }

    @Override
    public void execute(EventForecastInputData eventForecastInputData) {
        // Fetch the weather forecast for the given event date
        EventForecast eventForecast = weatherService.fetchWeatherForecast(eventForecastInputData.getEventDate());
        boolean isUnsuitableForOutdoor = eventForecast.isUnsuitableForOutdoor();
        eventBookingPresenter.prepareForecastView(eventForecast);

        if (eventForecastInputData.isIndoor() == null) {
            eventBookingPresenter.prepareFailView("Please make a selection.");
        }
        final Client client = clientFactory.create(eventForecastInputData.getName());
        final EventHall eventHall = (EventHall) eventHallFactory.create(eventForecastInputData.getPartySize());
        final EventBooking eventBooking = eventBookingFactory.create(client, eventHall, eventForecastInputData.getEventDate());

        eventBookingDataAccessObject.save(eventBooking);

        final EventForecastOutputData eventForecastOutputData = new EventForecastOutputData(eventForecastInputData.getName(), eventForecastInputData.getEventDate(), eventForecastInputData.getPartySize(), eventForecastInputData.isIndoor(), eventBooking.getEventHall().getRoomNumber(), eventBooking.getEventHall().getPrice(), false);
        eventBookingPresenter.prepareSuccessView(eventForecastOutputData);
    }

    @Override
    public void switchToSummaryView() {
        eventBookingPresenter.switchToSummaryView();
    }

    @Override
    public void switchToHomeView() {
        eventBookingPresenter.switchToHomeView();
    }
}






