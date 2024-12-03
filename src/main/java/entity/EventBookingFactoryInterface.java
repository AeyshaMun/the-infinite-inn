package main.java.entity;

public interface EventBookingFactoryInterface extends BookingFactory {
    EventBooking createEventBooking(Room eventHall, String eventDate);
}
