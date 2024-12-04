package java.interface_adapter.login;

import java.use_case.login.LoginInputBoundary;
import java.use_case.login.LoginInputData;

/**
 * The controller for the Login Use Case.
 */
public class LoginController {

    private final LoginInputBoundary loginInteractor;

    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     * @param name the name of the guest logging in
     * @param roomNumber the room number of the guest logging in
     */
    public void execute(String name, int roomNumber) {
        final LoginInputData loginInputData = new LoginInputData(
                name, roomNumber);

        loginInteractor.execute(loginInputData);
    }

    public void switchToMainView() {loginInteractor.switchToMainView();}
}
