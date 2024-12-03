package main.java.entity;

public class EventBookingFactory implements EventBookingFactoryInterface {
    /**
     * Creates a new EventBooking with the given details.
     * @param eventHall the event hall to be booked
     * @param eventDate the date of the event
     * @return a new EventBooking instance
     */
    public EventBooking createEventBooking(EventHall eventHall, String eventDate) {
        return new EventBooking(eventHall, eventDate);
    }
}

