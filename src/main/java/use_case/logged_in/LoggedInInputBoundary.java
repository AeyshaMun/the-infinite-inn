package use_case.logged_in;

/**
 * Input Boundary for actions which are related to room service, accommodations, and checkout.
 */
public interface LoggedInInputBoundary {

    void switchToRoomServiceView();

    void switchToAccommodationsView();

    void switchToCheckOutView();
}
