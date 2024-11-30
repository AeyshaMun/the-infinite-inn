package main.java.entity;

/**
 * Factory for creating rooms.
 * This factory provides a method to create different types of rooms, such as Suites and EventHalls.
 */
public interface RoomFactory {

    /**
     * Creates a new room of the specified type.
     *
     * @param personName the name of the person occupying the room
     * @param roomNumber the number of the room
     * @param price the price for renting the room
     * @return the created room object
     */
    Room create(String personName, String roomNumber, String price);
}
