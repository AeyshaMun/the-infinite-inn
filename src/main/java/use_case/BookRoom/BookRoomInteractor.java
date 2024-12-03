package main.java.use_case.BookRoom;

import main.java.entity.Suite;
import main.java.entity.InterfaceSuiteFactory;

public class BookRoomInteractor implements BookRoomInputBoundary {
    private final BookRoomDataAccessInterface suiteDataAccessObject;
    private final BookRoomOutputBoundary suitePresenter;
    private final InterfaceSuiteFactory suiteFactory;

    public BookRoomInteractor(BookRoomDataAccessInterface suiteDataAccessObject,
                              BookRoomOutputBoundary suitePresenter,
                              InterfaceSuiteFactory suiteFactory) {
        this.suiteDataAccessObject = suiteDataAccessObject;
        this.suitePresenter = suitePresenter;
        this.suiteFactory = suiteFactory;
    }

    @Override
    public void execute(BookRoomInputData bookroomInputData) {

        if (bookroomInputData.getName().isBlank()) {
            suitePresenter.prepareFailView("Please type a valid name.");
        } else if (bookroomInputData.getRoomType().isBlank()) {
            suitePresenter.prepareFailView("Please select a room type.");
        } else {
            final Suite suite = suiteFactory.createSuite(bookroomInputData.getName(), bookroomInputData.getRoomType());
            suiteDataAccessObject.save(suite);

            final BookRoomOutputData bookRoomOutputData = new BookRoomOutputData(suite.getRoomNumber(), suite.getRoomType(), suite.getPrice(), false);
            suitePresenter.prepareSuccessView(bookRoomOutputData);
        }

    }

    @Override
    public void switchToConfirmationView() {
        suitePresenter.switchToConfirmationView();
    }
}
