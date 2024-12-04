package use_case.checkout;
/**
 * DAO for the Checkout Use Case.
 */
public interface CheckoutUserDataAccessInterface {
    /**
     * Removes the user associated with this name and room number.
     * @param name The name of the user.
     */
    boolean removeUser(String name, int roomNumber);

    /**
     * Checks if a user exists by name.
     * @param name The name of the user.
     */
    boolean existsByName(String name);
}