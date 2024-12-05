package use_case.logged_in;


/**
 * The output boundary for the Logged in Use Case.
 */
public interface LoggedInOutputBoundary {

    void switchToRoomServiceView();

    void switchToAccommodationsView();

    void switchToCheckOutView();
}
