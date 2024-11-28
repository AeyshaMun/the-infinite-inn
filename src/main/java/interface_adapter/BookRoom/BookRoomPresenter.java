package main.java.interface_adapter.BookRoom;

import main.java.interface_adapter.ViewManagerModel;
import main.java.use_case.BookRoom.BookRoomOutputData;
import main.java.use_case.BookRoom.BookRoomOutputDataBoundary;

public class BookRoomPresenter implements BookRoomOutputDataBoundary {
    private final BookRoomViewModel bookroomViewModel;

    public BookRoomPresenter(ViewManagerModel viewManagerModel,
                             BookRoomViewModel bookroomViewModel) {
        this.bookroomViewModel = bookroomViewModel;
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

