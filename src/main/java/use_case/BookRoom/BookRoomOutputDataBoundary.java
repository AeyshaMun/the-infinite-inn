package use_case.BookRoom;

/**
 * The output boundary for the BookRoom Use Case.
 */
public interface BookRoomOutputDataBoundary {

    /**
     * Prepares the success view for the BookRoom Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(BookRoomOutputData outputData);
}
