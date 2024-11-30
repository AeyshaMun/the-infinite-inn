package interface_adapter.checkout;
import use_case.checkout.CheckoutOutputBoundary;
import use_case.checkout.CheckoutOutputData;
/**
 * The presenter for the Checkout use case.
 * Responsible for preparing the view model state based on the interactor's output.
 */
public class CheckoutPresenter implements CheckoutOutputBoundary {
    private final CheckoutViewModel viewModel;

    public CheckoutPresenter(CheckoutViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(CheckoutOutputData checkoutOutputData) {
        CheckoutState newState = viewModel.getState();
        newState.setCheckoutStatus(true);
        newState.setMessage(checkoutOutputData.getMessage());
        newState.setGuestID(checkoutOutputData.getGuestID());

        viewModel.setState(newState);
    }

    @Override
    public void prepareFailView(String failureMessage) {
        CheckoutState newState = viewModel.getState();
        newState.setCheckoutStatus(false);
        newState.setMessage(failureMessage);
        newState.setErrorStatus("FAILURE");

        viewModel.setState(newState);
    }
}