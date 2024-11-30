package java.use_case.checkout;
/**
 * DAO for the Checkout Use Case.
 */
public interface CheckoutUserDAI {
    /**
     * Validates if the guest is eligible for checkout
     * @param guestID the guest to validate
     * @return true if checkout is possible, false otherwise
     */
    boolean isCheckoutEligible(String guestID);

    /**
     * Sets the guest ID indicating who is the current guest of the application.
     * @param guestID the new current username
     */
    void setCurrentUsername(String guestID);

    /**
     * Returns the RoomID of the curren user of the application.
     * @return the RoomID of the current user
     */

    String getRoomNumberForGuest(String guestID);

    /**
     * Perform the actual checkout process
     * @param guestID the guest to check out
     * @param roomNumber the room to be checked out
     * @return true if checkout was successful
     */

    boolean performCheckout(String guestID, String roomNumber);

    /**
     * Reset guest and room information after checkout
     * @param guestID the guest to reset
     */
    void resetGuestInfo(String guestID);

}