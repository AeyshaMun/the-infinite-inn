package interface_adapter.BookRoom;

import main.java.interface_adapter.ViewManagerModel;
import interface_adapter.Confirmation.ConfirmationState;
import interface_adapter.Confirmation.ConfirmationViewModel;
import java.use_case.BookRoom.BookRoomOutputData;
import java.use_case.BookRoom.BookRoomOutputBoundary;

public class BookRoomPresenter implements BookRoomOutputBoundary {

    private final BookRoomViewModel bookroomViewModel;
    private final ConfirmationViewModel confirmationViewModel;
    private final ViewManagerModel viewManagerModel;

    public BookRoomPresenter(BookRoomViewModel bookroomViewModel, ConfirmationViewModel confirmationViewModel, ViewManagerModel viewManagerModel) {
        this.bookroomViewModel = bookroomViewModel;
        this.confirmationViewModel = confirmationViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(BookRoomOutputData response) {
        // On success, switch to the confirmation view
        final ConfirmationState confirmationState = confirmationViewModel.getState();
        confirmationState.setRoomNum(response.getRoomNum());
        confirmationState.setRoomType(response.getRoomType());
        confirmationState.setPrice(response.getPrice());
        this.confirmationViewModel.setState(confirmationState);
        confirmationViewModel.firePropertyChanged();

        viewManagerModel.setState(confirmationViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final BookRoomState bookRoomState = bookroomViewModel.getState();
        bookRoomState.setNameError(error);
        bookroomViewModel.firePropertyChanged();
    }

    @Override
    public void switchToConfirmationView() {
        viewManagerModel.setState(confirmationViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

