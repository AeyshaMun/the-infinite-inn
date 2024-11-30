package main.java.entity;

/**
 * The interface representing a general room.
 * This interface defines the common properties and behavior
 * that all types of rooms (such as Suite and EventHall) must implement.
 */
public interface Room {

    /**
     * Returns the name of the person occupying the room.
     * @return the name of the person.
     */
    String getPersonName();

    /**
     * Sets the name of the person occupying the room.
     * @param personName the name of the person to be set.
     */

    /**
     * Returns the room number.
     * @return the room number.
     */
    String getRoomNumber();

    /**
     * Returns the price for renting the room.
     * @return the price of the room.
     */
    String getPrice();
}

