package entity;

public interface Suite extends Room {

    /**
     * Returns the room number.
     * @return the room number.
     */
    @Override
    int getRoomNumber();

    /**
     * Generates a unique room number for this room.
     */
    @Override
    void generateRoomNumber();

    /**
     * Calculates the rental price based on room type and other factors.
     * @return the calculated price of the room.
     */
    @Override
    double calculatePrice();

    /**
     * Returns the price for renting the room.
     * @return the price of the room.
     */
    @Override
    double getPrice();

    String getRoomType();

    String getName();
}
