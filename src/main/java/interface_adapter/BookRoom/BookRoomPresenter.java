package main.java.interface_adapter.BookRoom;

import main.java.interface_adapter.ViewManagerModel;
import main.java.use_case.BookRoom.BookRoomOutputData;
import main.java.use_case.BookRoom.BookRoomOutputBoundary;

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

