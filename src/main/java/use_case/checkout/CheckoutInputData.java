package use_case.checkout;

public class CheckoutInputData {
    private final String name;
    private final int roomNumber;
    private final boolean isEventHall;

    // Constructor for guest room checkout
    public CheckoutInputData(String name, int roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.isEventHall = false;
    }

    // Constructor for event hall checkout
    public CheckoutInputData(String name, int roomNumber, boolean isEventHall) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.isEventHall = isEventHall;
    }


    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isEventHall() {
        return isEventHall;
    }
}
