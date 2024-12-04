package use_case.BookRoom;

import entity.*;
import entity.*;
import java.util.ArrayList;

public class BookRoomInteractor implements BookRoomInputBoundary {
    private final BookRoomDataAccessInterface suiteDataAccessObject;
    private final BookRoomOutputBoundary suitePresenter;
    private final SuiteFactoryInterface suiteFactory;
    private final BookRoomInputData bookRoomInputData;
    private final GuestFactoryInterface guestFactory;

    public BookRoomInteractor(BookRoomDataAccessInterface suiteDataAccessObject,
                              BookRoomOutputBoundary suitePresenter,
                              SuiteFactoryInterface suiteFactory, BookRoomInputData bookRoomInputData, GuestFactoryInterface guestFactory) {
        this.suiteDataAccessObject = suiteDataAccessObject;
        this.suitePresenter = suitePresenter;
        this.suiteFactory = suiteFactory;
        this.bookRoomInputData = bookRoomInputData;
        this.guestFactory = guestFactory;
    }

    @Override
    public void execute(BookRoomInputData bookroomInputData) {

        if (bookroomInputData.getName().isBlank()) {
            suitePresenter.prepareFailView("Please type a valid name.");
        } else if (bookroomInputData.getRoomType().isBlank()) {
            suitePresenter.prepareFailView("Please select a room type.");
        } else {
            final Suite suite = suiteFactory.createSuite(bookroomInputData.getName(), bookroomInputData.getRoomType());

            final BookRoomOutputData bookRoomOutputData = new BookRoomOutputData(suite.getRoomNumber(), suite.getRoomType(), suite.getPrice(), false);
            suitePresenter.prepareSuccessView(bookRoomOutputData);

            ArrayList<Integer> order = new ArrayList<>();
            final Person guest = guestFactory.createGuest(bookRoomInputData.getName(), "", order, (SuiteRoom) suite);

            suiteDataAccessObject.savePerson(guest);

        }

    }

    @Override
    public void switchToConfirmationView() {
        suitePresenter.switchToConfirmationView();
    }
}
