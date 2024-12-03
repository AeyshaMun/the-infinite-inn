package use_case.checkout;

/**
 * The Checkout Interactor.
 */
public class CheckoutInteractor implements CheckoutInputBoundary {
    private CheckoutUserDataAccessInterface userDataAccessObject;
    private CheckoutOutputBoundary checkoutPresenter;

    public CheckoutInteractor(CheckoutUserDataAccessInterface userDataAccessInterface,
                              CheckoutOutputBoundary checkoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.checkoutPresenter = checkoutOutputBoundary;
    }

    @Override
    public void execute(CheckoutInputData checkoutInputData) {
        final String name = checkoutInputData.getName();
        final int roomNumber = checkoutInputData.getRoomNumber();
        final boolean isEventHall = checkoutInputData.isEventHall();

        try {
            if (userDataAccessObject.existsByName(name)) {
                checkoutPresenter.prepareFailView("User not found.");
            }
            else {
                // Perform checkout
                boolean checkoutSuccessful = userDataAccessObject.removeUser(name, roomNumber);

                if (checkoutSuccessful) {
                    // Prepare success output
                    CheckoutOutputData outputData = new CheckoutOutputData(
                            name, roomNumber, isEventHall, true, "Checkout successful."
                    );
                    checkoutPresenter.prepareSuccessView(outputData);
                } else {
                    // Prepare failure output
                    checkoutPresenter.prepareFailView("Failed to complete checkout.");
                }
            }
        } catch (Exception e) {
            // Handle unexpected exceptions
            checkoutPresenter.prepareFailView("An error occurred during checkout: " + e.getMessage());
        }
    }

    @Override
    public void switchtoLoggedInView() {
        checkoutPresenter.switchtoLoggedInView();
    }
}
