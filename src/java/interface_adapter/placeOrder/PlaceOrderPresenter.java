package java.interface_adapter.placeOrder;

import java.interface_adapter.ViewManagerModel;
import java.interface_adapter.logged_in.LoggedInViewModel;
import java.interface_adapter.receipt.ReceiptState;
import java.interface_adapter.receipt.ReceiptViewModel;
import java.use_case.place_order.PlaceOrderOutputBoundary;
import java.use_case.place_order.PlaceOrderOutputData;

/**
 * The Presenter for the PlaceOrder Use Case.
 */
public class PlaceOrderPresenter implements PlaceOrderOutputBoundary {

    private final PlaceOrderViewModel placeOrderViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;
    private final ReceiptViewModel receiptViewModel;

    public PlaceOrderPresenter(ViewManagerModel viewManagerModel,
                               PlaceOrderViewModel placeOrderViewModel,
                               ReceiptViewModel receiptViewModel, LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.placeOrderViewModel = placeOrderViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.receiptViewModel = receiptViewModel;
    }

    @Override
    public void prepareSuccessView(PlaceOrderOutputData response) {
        // On success, switch to the receipt view.
        final ReceiptState receiptState = receiptViewModel.getState();
        receiptState.setOrder(response.getOrder());
        this.receiptViewModel.setState(receiptState);
        receiptViewModel.firePropertyChanged();

        viewManagerModel.setState(receiptViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final PlaceOrderState placeOrderState = placeOrderViewModel.getState();
        placeOrderState.setOrderError(error);
        placeOrderViewModel.firePropertyChanged();
    }

    @Override
    public void switchToLoggedInView() {
        viewManagerModel.setState(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
