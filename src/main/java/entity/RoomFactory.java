package entity;

import entity.Room;

/**
 * Factory for creating rooms.
 * This factory provides a method to create different types of rooms, such as Suites and EventHalls.
 */
public interface RoomFactory {

    /**
     * Creates a new room of the specified type.
     *
     * @return the created room object
     */
    Room create();
}
