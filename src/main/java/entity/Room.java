package entity;

public interface Room {
    /**
     * Returns the room number.
     * @return the room number.
     */
    int getRoomNumber();

    /**
     * Generates a unique room number for this room.
     */
    void generateRoomNumber();

    /**
     * Calculates the rental price based on room type and other factors.
     * @return the calculated price of the room.
     */
    double calculatePrice();

    /**
     * Returns the price for renting the room.
     * @return the price of the room.
     */
    double getPrice();
}

