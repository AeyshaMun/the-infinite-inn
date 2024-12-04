package use_case.eventforecast;

import entity.*;
import java.interface_adapter.eventforecast.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The Event Forecast Interactor.
 */
public class EventForecastInteractor implements EventForecastInputBoundary {
    private final EventForecastUserDataAccessInterface eventBookingDataAccessObject;
    private final EventForecastOutputBoundary eventBookingPresenter;
    private final ClientFactoryInterface clientFactory;
    private final EventHallFactoryInterface eventHallFactory;
    private final EventBookingFactoryInterface eventBookingFactory;
    private final WeatherService weatherService; // Add weather service dependency


    public EventForecastInteractor(EventForecastUserDataAccessInterface eventForecastDataAccessInterface,
                                   EventForecastOutputBoundary eventForecastOutputBoundary,
                                   ClientFactoryInterface clientFactory, EventHallFactoryInterface eventHallFactory,
                                   EventBookingFactoryInterface eventBookingFactory, WeatherService weatherService) {
        this.eventBookingDataAccessObject = eventForecastDataAccessInterface;
        this.eventBookingPresenter = eventForecastOutputBoundary;
        this.clientFactory = clientFactory;
        this.eventHallFactory = eventHallFactory;
        this.eventBookingFactory = eventBookingFactory;
        this.weatherService = weatherService;
    }

    @Override
    public void execute(EventForecastInputData eventForecastInputData) throws IOException {
        // Fetch the weather forecast for the given event date
        EventForecast eventForecast = weatherService.fetchWeatherForecast(eventForecastInputData.getEventDate());
        boolean isUnsuitableForOutdoor = eventForecast.isUnsuitableForOutdoor();
        eventBookingPresenter.prepareForecastView(eventForecast);

        if (eventForecastInputData.isIndoor() == null) {
            eventBookingPresenter.prepareFailView("Please make a selection.");
        }
        final Room eventHall = eventHallFactory.createEventHall(eventForecastInputData.getPartySize());
        final Booking booking = eventBookingFactory.createEventBooking(eventHall, eventForecastInputData.getEventDate());

        if (booking instanceof EventBooking) {
            EventBooking eventBooking = (EventBooking) booking;
            ArrayList<Integer> order = new ArrayList<>();
            final Person client = clientFactory.createClient(eventForecastInputData.getName(), "", order, eventBooking);

            eventBookingDataAccessObject.savePerson(client);

            final EventForecastOutputData eventForecastOutputData = new EventForecastOutputData(eventForecastInputData.getName(), eventForecastInputData.getEventDate(), eventForecastInputData.getPartySize(), eventForecastInputData.isIndoor(), eventBooking.getLocation().getRoomNumber(), eventBooking.getLocation().getPrice(), false);
            eventBookingPresenter.prepareSuccessView(eventForecastOutputData);
        }
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






