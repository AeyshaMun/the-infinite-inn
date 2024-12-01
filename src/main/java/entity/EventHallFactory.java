package main.java.entity;

public class EventHallFactory {

    /**
     * Creates a new EventHall with the given party size.
     * @param partySize the size of the party for the event
     * @return a new EventHall instance
     */
    public Room create(int partySize) {
        return new EventHall(partySize);  // Return as Room type
    }
}
