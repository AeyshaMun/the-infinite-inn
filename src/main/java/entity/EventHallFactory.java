package main.java.entity;

public class EventHallFactory implements RoomFactory {

    @Override
    public Room createSuite() {
        // EventHallFactory is not responsible for creating Suites, but we can throw an exception to indicate misuse.
        throw new UnsupportedOperationException("EventHallFactory cannot create Suites.");
    }

    @Override
    public Room createEventHall(int partySize) {
        // Create and return a new EventHall with the specified party size
        return new EventHall(partySize); // Assuming EventHall constructor takes partySize
    }
}
