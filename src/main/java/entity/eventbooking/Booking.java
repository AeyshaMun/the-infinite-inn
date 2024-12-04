package main.java.entity.eventbooking;

import main.java.entity.Room;

public interface Booking {
    Room getLocation();

    String getDate();
}
