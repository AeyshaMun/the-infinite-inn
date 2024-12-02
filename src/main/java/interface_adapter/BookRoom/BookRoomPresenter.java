package interface_adapter.BookRoom;

import interface_adapter.ViewManagerModel;
import use_case.BookRoom.BookRoomOutputData;
import use_case.BookRoom.BookRoomOutputBoundary;
import interface_adapter.BookRoom.BookRoomViewModel;

public class BookRoomPresenter implements BookRoomOutputBoundary {
    private final BookRoomViewModel bookroomViewModel;
    private final ViewManagerModel viewManagerModel;

    public BookRoomPresenter(BookRoomViewModel bookroomViewModel, ViewManagerModel viewManagerModel) {
        this.bookroomViewModel = bookroomViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(BookRoomOutputData response) {
        // On success, switch to the login view.
//        final LoginState loginState = loginViewModel.getState();
//        loginState.setUsername(response.getUsername());
//        this.loginViewModel.setState(loginState);
//        loginViewModel.firePropertyChanged();

    }

}

