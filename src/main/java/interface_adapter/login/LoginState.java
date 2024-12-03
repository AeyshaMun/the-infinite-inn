package interface_adapter.login;

/**
 * The state for the Login View Model.
 */
public class LoginState {
    private String name = "";
    private String loginError;
    private int roomNumber;

    public String getName() {
        return name;
    }

    public String getLoginError() {
        return loginError;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setName(String name) {
        this.name = this.name;
    }

    public void setLoginError(String nameError) {
        this.loginError = nameError;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

}
