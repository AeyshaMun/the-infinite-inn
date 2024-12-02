package use_case.logged_in;

/**
 * The loggedIn Interactor.
 */


public class LoggedInInteractor implements LoggedInInputBoundary {

    private final LoggedInOutputBoundary loggedInPresenter;

    public LoggedInInteractor(LoggedInOutputBoundary loggedInPresenter) {
        this.loggedInPresenter = loggedInPresenter;
    }


    @Override
    public void switchToRoomServiceView() {
        loggedInPresenter.switchToRoomServiceView();
    }

    @Override
    public void switchToAccommodationsView() {
        loggedInPresenter.switchToAccommodationsView();
    }

    @Override
    public void switchToCheckOutView() {
        loggedInPresenter.switchToCheckOutView();
    }
}
