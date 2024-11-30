package use_case.checkout;

public class CheckoutOutputData {
    private final String guestID;
    private final String status;
    private final String message;

    public CheckoutOutputData(String guestID, String status, String message) {
        this.guestID = guestID;
        this.status = status;
        this.message = message;
    }

    public String getGuestID() {
        return guestID;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
