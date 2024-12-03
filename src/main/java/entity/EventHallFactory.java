package main.java.entity;

public class EventHallFactory implements EventHallFactoryInterface {

    @Override
    public Room createEventHall(int partySize) {
        // Create and return a new EventHall with the specified party size
        return new EventHall(partySize); // Assuming EventHall constructor takes partySize
    }
}
