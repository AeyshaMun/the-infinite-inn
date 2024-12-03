package use_case.checkout;
/**
 * DAO for the Checkout Use Case.
 */
public interface CheckoutUserDataAccessInterface {
    /**
     * Checks if a user exists by name and room number.
     * @param name The name of the user.
     * @param roomNumber The room number or event hall.
     * @param isEventHall Indicates if it's an event hall.
     * @return true if the user exists, false otherwise.
     */
    boolean findUserByNameAndRoom(String name, int roomNumber, boolean isEventHall);

    /**
     * Removes the association of the user with the room or event hall.
     * @param name The name of the user.
     * @param roomNumber The room number or event hall.
     * @param isEventHall Indicates if it's an event hall.
     * @return true if the removal is successful, false otherwise.
     */
    boolean removeUserAndRoom(String name, int roomNumber, boolean isEventHall);


    /**
     * Returns the username of the curren user of the application.
     * @return the username of the current user
     */
    String getName();

    /**
     * Sets the username indicating who is the current user of the application.
     * @param username the new current username
     */
    void setName(String username);
}