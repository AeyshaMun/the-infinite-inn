package entity;

import java.util.ArrayList;

public class Client implements Person {
    private final String name;
    private final String accommodations;
    private final ArrayList<Integer> order;
    private final EventBooking eventBooking;

    public Client(String name, String accommodations, ArrayList<Integer> order, EventBooking eventBooking) {
        this.name = name;
        this.accommodations = accommodations;
        this.order = order;
        this.eventBooking = eventBooking;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getAccommodations() {
        return accommodations;
    }

    @Override
    public ArrayList<Integer> getOrder() {
        return order;
    }

    @Override
    public double getPrice() {
        return eventBooking.getLocation().getPrice();
    }

    @Override
    public int getRoomNumber() {
        return eventBooking.getLocation().getRoomNumber();
    }

    public String getEventDate() {
        return eventBooking.getDate();
    }

    public int getPartySize() {
        return eventBooking.getLocation().getPartySize();
    }

    public Boolean isIndoor() {
        return eventBooking.isIndoor();
    }
}
