package java.interface_adapter.logged_in;

import java.use_case.logged_in.LoggedInInputBoundary;

/**
 * Controller for the place order Use Case.
 */
public class LoggedInController {

    private final LoggedInInputBoundary loggedInInteractor;

    public LoggedInController(LoggedInInputBoundary loggedInInteractor) {
        this.loggedInInteractor = loggedInInteractor;
    }

    public void switchToRoomServiceView() {loggedInInteractor.switchToRoomServiceView();}

    public void switchToAccommodationsView() {loggedInInteractor.switchToAccommodationsView();}

    public void switchToCheckOutView() {loggedInInteractor.switchToCheckOutView();}
}
