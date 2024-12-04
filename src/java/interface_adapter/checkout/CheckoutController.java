package java.interface_adapter.checkout;

import use_case.checkout.CheckoutInputBoundary;
import use_case.checkout.CheckoutInputData;

public class CheckoutController {
    private final CheckoutInputBoundary checkoutInteractor;

    public CheckoutController(CheckoutInputBoundary checkoutInteractor) {
        this.checkoutInteractor = checkoutInteractor;
    }
    /**
     * Handles the checkout request.
     * @param name the name of the guest or client.
     * @param roomNumber the room or event hall number.
     * @param isEventHall true if checking out from an event hall, false otherwise.
     */
    public void execute(String name, int roomNumber, boolean isEventHall) {
        final CheckoutInputData inputData = new CheckoutInputData(name, roomNumber, isEventHall);

        checkoutInteractor.execute(inputData);
    }
}