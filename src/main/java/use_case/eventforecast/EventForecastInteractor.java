package use_case.eventforecast;

import entity.eventbooking.*;
import main.java.entity.Person;
import main.java.entity.Room;
import main.java.use_case.eventforecast.WeatherService;

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
    public void execute(EventForecastFirstInputData eventForecastFirstInputData, EventForecastSecondInputData eventForecastSecondInputData) throws IOException {
        // Fetch the weather forecast for the given event date
        EventForecast eventForecast = weatherService.fetchWeatherForecast(eventForecastFirstInputData.getEventDate());

        eventBookingPresenter.prepareForecastView(eventForecast);

        boolean isUnsuitableForOutdoor;

        if (eventForecast.getPrecipitation() > 1.0 ||
                    eventForecast.getTemperature() < 10.0 || eventForecast.getTemperature() > 35.0 ||
                eventForecast.getWindspeed() > 20.0 ||
                    eventForecast.getDescription().contains("Thunderstorm") || eventForecast.getDescription().contains("Snow")) {
            isUnsuitableForOutdoor = true;
        }
        else {
            isUnsuitableForOutdoor = false;
        }

        eventBookingPresenter.prepareChoices(isUnsuitableForOutdoor);

        if (eventForecastFirstInputData.isIndoor() == null) {
            eventBookingPresenter.prepareFailView("Please make a selection.");
        }
        final Room eventHall = eventHallFactory.createEventHall(eventForecastFirstInputData.getPartySize());
        final Booking booking = eventBookingFactory.createEventBooking(eventHall, eventForecastFirstInputData.getEventDate());

        if (booking instanceof EventBooking) {
            EventBooking eventBooking = (EventBooking) booking;
            ArrayList<Integer> order = new ArrayList<>();
            final Person client = clientFactory.createClient(eventForecastFirstInputData.getName(), "", order, eventBooking);

            eventBookingDataAccessObject.savePerson(client);

            final EventForecastOutputData eventForecastOutputData = new EventForecastOutputData(eventForecastFirstInputData.getName(), eventForecastFirstInputData.getEventDate(), eventForecastFirstInputData.getPartySize(), eventForecastFirstInputData.isIndoor(), eventBooking.getLocation().getRoomNumber(), eventBooking.getLocation().getPrice(), false);
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






