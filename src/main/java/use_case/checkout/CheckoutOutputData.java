package java.use_case.checkout;

public class CheckoutOutputData {
    private String guestID;
    private boolean success;
    private String message;

    public CheckoutOutputData(String guestID, boolean success, String message) {
        this.guestID = guestID;
        this.success = success;
        this.message = message;
    }

    public String getGuestID() {
        return guestID;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
