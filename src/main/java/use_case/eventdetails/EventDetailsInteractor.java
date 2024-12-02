package use_case.eventdetails;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import use_case.eventdetails.EventDetailsUserDataAccessInterface;
import use_case.eventdetails. EventDetailsOutputBoundary;

/**
 * The Event Details Interactor.
 */
public class EventDetailsInteractor implements EventDetailsInputBoundary {
    private final EventDetailsUserDataAccessInterface eventDetailsDataAccessObject;
    private final EventDetailsOutputBoundary eventDetailsPresenter;
//    private final ClientFactory clientFactory;
//    private final EventHallFactory eventHallFactory;
//    private final EventBookingFactory eventBookingFactory;


    public EventDetailsInteractor(EventDetailsUserDataAccessInterface eventDetailsDataAccessInterface,
                            EventDetailsOutputBoundary eventDetailsOutputBoundary) {
        this.eventDetailsDataAccessObject = eventDetailsDataAccessInterface;
        this.eventDetailsPresenter = eventDetailsOutputBoundary;
//        this.clientFactory = clientFactory;
//        this.eventHallFactory = eventHallFactory;
//        this.eventBookingFactory = eventBookingFactory;
    }

    @Override
    public void execute(EventDetailsInputData eventDetailsInputData) {
        if (eventDetailsDataAccessObject.existsByName(eventDetailsInputData.getName())) {
            eventDetailsPresenter.prepareNameFailView("A booking already exists under this name.");
        }
        else if (!isValidDate(eventDetailsInputData.getEventDate())) {
            eventDetailsPresenter.prepareEventDateFailView("Please make sure that the event date is in 'yyyy-mm-dd' format.");
        }
        else if (!partySizeGreaterThan800(eventDetailsInputData.getPartySize())) {
            eventDetailsPresenter.preparePartySizeFailView("Please make sure that the party size is less than 800. If your event expects more than 800 attendees I'm afraid we won't be able to accommodate you.");
        }
        else if (!partySizeInvalid(eventDetailsInputData.getPartySize())) {
            eventDetailsPresenter.preparePartySizeFailView("Please make sure that the party size is a POSITIVE INTEGER number greater than 0.");
        }
        else {
//            final Client client = clientFactory.create(eventDetailsInputData.getName());
//            final EventHall eventHall = (EventHall) eventHallFactory.create(eventDetailsInputData.getPartySize());
//            final EventBooking eventBooking = eventBookingFactory.create(client, eventHall, eventDetailsInputData.getEventDate());

            final EventDetailsOutputData eventDetailsOutputData = new EventDetailsOutputData(eventDetailsInputData.getName(), eventDetailsInputData.getEventDate(), eventDetailsInputData.getPartySize(), false);
            eventDetailsPresenter.prepareSuccessView(eventDetailsOutputData);
        }
    }

    @Override
    public void switchToEventForecastView() {
        eventDetailsPresenter.switchToEventForecastView();
    }

    @Override
    public void switchToHomeView() {
        eventDetailsPresenter.switchToHomeView();
    }

    public boolean isValidDate(String date) {
        try {
            // Ensure strict format matching
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            return true; // Date is valid
        } catch (DateTimeParseException e) {
            return false; // Invalid date
        }
    }

    public boolean partySizeGreaterThan800(int partySize) {
        return partySize <= 800;
    }

    public boolean partySizeInvalid(int partySize) {
        return partySize > 0;
    }
}

