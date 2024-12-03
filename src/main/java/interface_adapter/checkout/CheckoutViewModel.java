package interface_adapter.checkout;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Checkout View.
 */
public class CheckoutViewModel extends ViewModel<CheckoutState> {

    private CheckoutController controller;

    public CheckoutViewModel(CheckoutController controller) {
        super("Checkout");
        this.controller = controller;
        setState(new CheckoutState());
    }

    // This method now simply forwards to the controller
    public void executeCheckout() {
        CheckoutState currentState = getState();
        controller.execute(
                currentState.getName(),
                currentState.getRoomNumber(),
                false  // assuming this is not an event hall, adjust as needed
        );
    }
}

