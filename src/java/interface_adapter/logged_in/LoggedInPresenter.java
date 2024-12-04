package java.interface_adapter.logged_in;

import java.interface_adapter.ViewManagerModel;
import java.interface_adapter.accommodations.AccommodationsViewModel;
import java.interface_adapter.checkout.CheckoutViewModel;
import interface_adapter.BookRoom.BookRoomViewModel;
import java.use_case.logged_in.LoggedInOutputBoundary;

/**
 * The Presenter for the Logged In Use Case.
 */
public class LoggedInPresenter implements LoggedInOutputBoundary {

    private final BookRoomViewModel bookRoomViewModel;
    private final AccommodationsViewModel accommodationsViewModel;
    private final CheckoutViewModel checkoutViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoggedInPresenter(ViewManagerModel viewManagerModel,
                             BookRoomViewModel bookRoomViewModel,
                             AccommodationsViewModel accommodationsViewModel,
                             CheckoutViewModel checkoutViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.bookRoomViewModel = bookRoomViewModel;
        this.accommodationsViewModel = accommodationsViewModel;
        this.checkoutViewModel = checkoutViewModel;
    }

    @Override
    public void switchToRoomServiceView() {
        viewManagerModel.setState(bookRoomViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToAccommodationsView() {
        viewManagerModel.setState(accommodationsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToCheckOutView() {
        viewManagerModel.setState(checkoutViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
