package interface_adapter.checkout;

import use_case.checkout.CheckoutInputBoundary;
import use_case.checkout.CheckoutInputData;

public class CheckoutController {
    private final CheckoutInputBoundary checkoutInteractor;

    public CheckoutController(CheckoutInputBoundary checkoutInteractor) {
        this.checkoutInteractor = checkoutInteractor;
    }
    /**
     * Executes the Login Use Case.
     * @param guestID the id of the guest logging in
     * @param roomNumber the room Number logging in
     */
    public void execute(String guestID, String roomNumber) {
        final CheckoutInputData inputData = new CheckoutInputData(guestID, roomNumber);

        checkoutInteractor.execute(inputData);
    }
}