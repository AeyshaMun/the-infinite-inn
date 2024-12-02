package use_case.checkout;
/**
 * DAO for the Checkout Use Case.
 */
public interface CheckoutUserDAI {
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
}