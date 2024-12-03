package main.java.entity;

public interface InterfaceEventHallFactory extends RoomFactory {
    /**
     * Creates a new EventHall room with the specified party size.
     *
     * @param partySize the number of attendees for the event hall.
     * @return the created EventHall object.
     */
    Room createEventHall(int partySize);
}
