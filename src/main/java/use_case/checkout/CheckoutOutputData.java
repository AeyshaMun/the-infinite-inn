package use_case.checkout;

public class CheckoutOutputData {
    private final String name;
    private final int roomNumber;
    private final boolean isEventHall;
    private final boolean success;
    private final String message;

    public CheckoutOutputData(String name, int roomNumber, boolean isEventHall, boolean success, String message
    ) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.isEventHall = isEventHall;
        this.success = success;
        this.message = message;
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

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
