package interface_adapter.checkout;

public class CheckoutState {
    private String guestID;
    private boolean checkoutStatus;
    private String message;
    private String errorStatus;

    // Getters and setters
    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public boolean isCheckoutStatus() {
        return checkoutStatus;
    }
    public void setCheckoutStatus(boolean checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }
    // Create a copy method for immutability
    public CheckoutState copy() {
        CheckoutState newState = new CheckoutState();
        newState.guestID = this.guestID;
        newState.checkoutStatus = this.checkoutStatus;
        newState.message = this.message;
        newState.errorStatus = this.errorStatus;
        return newState;
    }
}
