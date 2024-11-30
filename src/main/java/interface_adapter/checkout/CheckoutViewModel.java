package interface_adapter.checkout;

import java.interface_adapter.ViewModel;

/**
 * ViewModel for handling the checkout state in the Inn system.
 */
public class CheckoutViewModel extends ViewModel<CheckoutState> {

    public CheckoutViewModel() {
        super("Checkout");
    }
}
