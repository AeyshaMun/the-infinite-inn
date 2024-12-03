package main.java.entity;

public class EventBooking implements Booking {
    private final EventHall eventHall;
    private final String eventDate;
    private final Boolean isIndoor;

    public EventBooking(EventHall eventHall, String eventDate) {
        this.eventHall = eventHall;
        this.eventDate = eventDate;
        this.isIndoor = true;
    }

    public EventHall getLocation() {
        return eventHall;
    }

    public String getDate() {
        return eventDate;
    }

    public Boolean isIndoor() {
        return isIndoor;
    }
}
