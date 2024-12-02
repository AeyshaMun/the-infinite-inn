package entity;

import entity.Room;

/**
 * Factory for creating rooms.
 * This factory provides methods to create different types of rooms, such as Suites and EventHalls.
 */
public interface RoomFactory {

    /**
     * Creates a new Suite room.
     *
     * @return the created Suite object.
     */
    Room createSuite(String name, String room_type);

    /**
     * Creates a new EventHall room with the specified party size.
     *
     * @param partySize the number of attendees for the event hall.
     * @return the created EventHall object.
     */
    Room createEventHall(int partySize);
}

