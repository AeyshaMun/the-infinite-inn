package main.java.interface_adapter.BookRoom;

import main.java.interface_adapter.ViewModel;

/**
 * The ViewModel for the Signup View.
 */
public class BookRoomViewModel extends ViewModel<BookRoomState> {

    public static final String TITLE_LABEL = "Book Room View";
    public static final String NAME_LABEL = "Enter name";
    public static final String ROOM_LABEL = "Select Room";

    public static final String SUBMIT_BUTTON_LABEL = "Submit Request";

    public BookRoomViewModel() {
        super("Book Room");
        setState(new BookRoomState());
    }

}