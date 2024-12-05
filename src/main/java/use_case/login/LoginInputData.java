package use_case.login;

/**
 * The Input Data for the Login Use Case.
 */
public class LoginInputData {

    private final String name;
    private final int roomNumber;

    public LoginInputData(String name, int roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
    }

    String getName() {
        return name;
    }

    int getRoomNumber() {
        return roomNumber;
    }

}
