package interface_adapter.BookRoom;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Signup View.
 */
public class BookRoomViewModel extends ViewModel<BookRoomState> {

    public static final String TITLE_LABEL = "Book Room View";
    public static final String NAME_LABEL = "Enter name";
    public static final String ROOM_LABEL = "Select Room";
    public static final String SINGLE_ROOM_LABEL = "Single Room";
    public static final String DOUBLE_ROOM_LABEL = "Double Room";
    public static final String FAMILY_ROOM_LABEL = "Family Room";
    public static final String ACCESSIBLE_ROOM_LABEL = "Accessible Room";

    public static final String SINGLE_ROOM = "A cozy room for one person.";
    public static final String DOUBLE_ROOM = "A comfortable room for two people.";
    public static final String FAMILY_ROOM = "A luxurious suite for a family.";
    public static final String ACCESSIBLE_ROOM = "An accessible room with barrier-free design and adaptive features.";

    public static final String SUBMIT_BUTTON_LABEL = "Book Room";
    public BookRoomViewModel() {
        super("Book Room");
        setState(new BookRoomState());
    }
}