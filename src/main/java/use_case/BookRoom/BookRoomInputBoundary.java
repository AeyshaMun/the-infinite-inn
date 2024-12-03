package main.java.use_case.BookRoom;

public interface BookRoomInputBoundary {

    /**
     * Executes the BookRoom use case.
     * @param bookroomInputData the input data
     */
    void execute(BookRoomInputData bookroomInputData);

    /**
     * Executes the switch to confirmation view use case.
     */
    void switchToConfirmationView();
}
