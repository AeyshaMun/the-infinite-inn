package use_case.login;

/**
 * The Login Interactor implements the login use case logic.
 */
public class LoginInteractor implements LoginInputBoundary {
    private final LoginDataAccessInterface guestDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    /**
     * Constructor for LoginInteractor.
     *
     * @param guestDataAccessInterface Data access interface for guest operations
     * @param loginOutputBoundary Presenter for login output
     */
    public LoginInteractor(
            LoginDataAccessInterface guestDataAccessInterface,
            LoginOutputBoundary loginOutputBoundary
    ) {
        this.guestDataAccessObject = guestDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    /**
     * Executes the login process based on input data.
     *
     * @param loginInputData Input data for login attempt
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        final String name = loginInputData.getName();
        final int roomNumber = loginInputData.getRoomNumber();

        // Validate guest exists and name matches
        if ((!guestDataAccessObject.roomExists(roomNumber))) {
            loginPresenter.prepareFailView("Enter a valid room Number");
        }

        else if (!guestDataAccessObject.getName(roomNumber).equals(name)) {
            loginPresenter.prepareFailView("Name and room number do not match");
        }

        // Set current guest and prepare success view
        guestDataAccessObject.setCurrentGuest(name);
        final LoginOutputData loginOutputData = new LoginOutputData(name, false);
        loginPresenter.prepareSuccessView(loginOutputData);
    }

    @Override
    public void switchToMainView() {loginPresenter.switchToMainView();}

}
