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
    void setPersonName(String personName);

    /**
     * Returns the room number.
     * @return the room number.
     */
    int getRoomNumber();

    /**
     * Sets the room number for this room.
     * @param roomNumber the room number to be set.
     */
    void setRoomNumber(int roomNumber);

    /**
     * Returns the price for renting the room.
     * @return the price of the room.
     */
    double getPrice();

    /**
     * Sets the price for renting the room.
     * @param price the price to be set for the room.
     */
    void setPrice(double price);
}

