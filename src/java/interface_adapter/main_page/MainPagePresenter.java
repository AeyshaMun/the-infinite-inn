package java.interface_adapter.main_page;

import interface_adapter.BookRoom.BookRoomViewModel;
import java.interface_adapter.ViewManagerModel;
import java.interface_adapter.eventdetails.EventDetailsViewModel;
import java.interface_adapter.login.LoginViewModel;
import java.use_case.main_page.MainPageOutputBoundary;

/**
 * The Presenter for the Main Page Use Case.
 */
public class MainPagePresenter implements MainPageOutputBoundary {

    private final BookRoomViewModel bookRoomViewModel;
    private final EventDetailsViewModel eventDetailsViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;

    public MainPagePresenter(ViewManagerModel viewManagerModel,
                             BookRoomViewModel bookRoomViewModel,
                             EventDetailsViewModel eventDetailsViewModel,
                             LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.bookRoomViewModel = bookRoomViewModel;
        this.eventDetailsViewModel = eventDetailsViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void switchToBookRoomView() {
        viewManagerModel.setState(bookRoomViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToBookEventView() {
        viewManagerModel.setState(eventDetailsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToLoginView() {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
