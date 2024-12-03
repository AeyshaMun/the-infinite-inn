package main.java.interface_adapter.BookRoomConfirm;
import main.java.interface_adapter.ViewModel;

public class BookRoomConfirmViewModel extends ViewModel<BookRoomConfirmState> {

    public static final String MESSAGE = "Congratulations! You have made your booking.";

    public BookRoomConfirmViewModel() {
        super("Book Room Confirmation");
        setState(new BookRoomConfirmState());
    }
}

