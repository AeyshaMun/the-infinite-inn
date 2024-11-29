package java.use_case.checkout;

public class CheckoutInputData {
    private final String guestID; //or guestname?
    private final String roomNumber;

    public CheckoutInputData(String guestID, String roomNumber) {
        this.guestID = guestID;
        this.roomNumber = roomNumber;
    }

    public String getGuestID() {
        return guestID;
    }
    public String getRoomNumber() {return roomNumber;}

}
