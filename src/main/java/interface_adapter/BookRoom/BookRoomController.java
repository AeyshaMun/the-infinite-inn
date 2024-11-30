package main.java.interface_adapter.BookRoom;

import main.java.use_case.BookRoom.BookRoomInputBoundary;
import main.java.use_case.BookRoom.BookRoomInputData;

/**
 * Controller for the Signup Use Case.
 */
public class BookRoomController {

    private final BookRoomInputBoundary bookroomUseCaseInteractor;

    public BookRoomController(BookRoomInputBoundary bookroomUseCaseInteractor) {
        this.bookroomUseCaseInteractor = bookroomUseCaseInteractor;
    }

    public void execute(String name, String room_type) {
        final BookRoomInputData bookroomInputData = new BookRoomInputData(
                name, room_type);

        bookroomUseCaseInteractor.execute(bookroomInputData);
    }
}
