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
        String guestID = userDataAccessObject.getCurrentUsername();
        String roomNumber = userDataAccessObject.getRoomNumberForGuest(guestID);

        userDataAccessObject.setCurrentUsername(null);
        userDataAccessObject.getRoomNumberForGuest(null);

        final CheckoutOutputData checkoutOutputData = new CheckoutOutputData(
                guestID,
                true);
        checkoutPresenter.prepareSuccessView(checkoutOutputData);
    }

}
