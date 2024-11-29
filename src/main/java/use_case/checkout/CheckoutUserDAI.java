package java.use_case.checkout;
/**
 * DAO for the Checkout Use Case.
 */
public interface CheckoutUserDAI {
    /**
     * Returns the guest ID of the current guest of the application.
     * @return the guest ID of the current guest
     */
    String getCurrentUsername();

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

}