package java.use_case.checkout;
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
        // Step 1: Get the current guest and room information
        String guestID = userDataAccessObject.getCurrentUsername();
        String roomID = userDataAccessObject.getRoomIDForGuest(guestID);
        userDataAccessObject.setCurrentUsername(null);

        final CheckoutOutputData checkoutOutputData = new CheckoutOutputData(
                guestID,
                true,
                "Checkout Successfully");
        checkoutPresenter.prepareSuccessView(checkoutOutputData);
    }

}
