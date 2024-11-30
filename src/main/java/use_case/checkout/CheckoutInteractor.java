package use_case.checkout;

/**
 * The Checkout Interactor.
 */
public class CheckoutInteractor implements CheckoutInputBoundary {
    private CheckoutUserDAI userDataAccessObject;
    private CheckoutOutputBoundary checkoutPresenter;

    public CheckoutInteractor(CheckoutUserDAI userDataAccessInterface,
                              CheckoutOutputBoundary checkoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.checkoutPresenter = checkoutOutputBoundary;
    }

    @Override
    public void execute(CheckoutInputData checkoutInputData) {
        String guestID = checkoutInputData.getGuestID();
        String roomNumber = checkoutInputData.getRoomNumber();

        // Validate guest eligibility for checkout
        if (!userDataAccessObject.isCheckoutEligible(guestID)) {
            checkoutPresenter.prepareFailView("Guest is not eligible for checkout");
            return;
        }

        // Check if room is assigned
        if (roomNumber == null || !roomNumber.equals(userDataAccessObject.getRoomNumberForGuest(guestID))) {
            checkoutPresenter.prepareFailView("No room assigned to this guest");
            return;
        }

        // Perform checkout
        boolean checkoutSuccess = userDataAccessObject.performCheckout(guestID, roomNumber);

        if (checkoutSuccess) {
            // Reset guest information
            userDataAccessObject.resetGuestInfo(guestID);

            CheckoutOutputData successOutput = new CheckoutOutputData(
                    guestID,
                    "SUCCESS",
                    "Checkout completed successfully"
            );
            checkoutPresenter.prepareSuccessView(successOutput);
        } else {
            checkoutPresenter.prepareFailView("Checkout process failed");
        }
    }
}
