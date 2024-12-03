package main.java.use_case.BookRoom;

/**
 * The output boundary for the BookRoom Use Case.
 */
public interface BookRoomOutputBoundary {

    /**
     * Prepares the success view for the BookRoom Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(BookRoomOutputData outputData);

    /**
     * Prepares the failure view for the BookRoom Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Executes the switch to confirmation view use case.
     */
    void switchToConfirmationView();
}
