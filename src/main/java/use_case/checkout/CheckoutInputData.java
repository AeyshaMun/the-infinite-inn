package java.use_case.checkout;

public class CheckoutInputData {
    private final String guestID;
    private final String roomID;

    public CheckoutInputData(String guestID, String roomID) {
        this.guestID = guestID;
        this.roomID = roomID;
    }

    public String getGuestID() {
        return guestID;
    }
    public String getRoomID() {return roomID;}

}
