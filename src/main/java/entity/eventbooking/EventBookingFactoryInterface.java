package main.java.entity.eventbooking;

import main.java.entity.Room;

public interface EventBookingFactoryInterface extends BookingFactory {
    EventBooking createEventBooking(Room eventHall, String eventDate);
}
