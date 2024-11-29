package java.use_case.checkout;

public class CheckoutOutputData {
    private String guestID;
    private boolean success;


    public CheckoutOutputData(String guestID, boolean success) {
        this.guestID = guestID;
        this.success = success;
    }

    public String getGuestID() {
        return guestID;
    }

    public boolean isSuccess() {
        return success;
    }
}
