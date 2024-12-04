package main.java.entity.eventbooking;

import main.java.entity.Room;

public class EventHallFactory implements EventHallFactoryInterface {

    @Override
    public Room createEventHall(int partySize) {
        // Create and return a new EventHall with the specified party size
        return new EventHall(partySize); // Assuming EventHall constructor takes partySize
    }
}
