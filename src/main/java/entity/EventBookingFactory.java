package entity;

public class EventBookingFactory {

    /**
     * Creates a new EventBooking with the given details.
     * @param client the client making the booking
     * @param eventHall the event hall to be booked
     * @param eventDate the date of the event
     * @return a new EventBooking instance
     */
    public EventBooking create(Client client, EventHall eventHall, String eventDate) {
        // Default to indoor (true), as this is the initial setting
        return new EventBooking(client, eventHall, eventDate);
    }
}

