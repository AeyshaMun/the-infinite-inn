package main.java.entity;

public class EventBooking {
    private final Client client;
    private final EventHall eventHall;
    private final String eventDate;
    private Boolean isIndoor;

    public EventBooking(Client client, EventHall eventHall, String eventDate) {
        this.client = client;
        this.eventHall = eventHall;
        this.eventDate = eventDate;
        this.isIndoor = true;
    }

    public Client getClient() {
        return client;
    }

    public EventHall getEventHall() {
        return eventHall;
    }

    public String getEventDate() {
        return eventDate;
    }

    public Boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean isIndoor) {
        this.isIndoor = isIndoor;
    }
}
