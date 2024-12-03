package main.java.use_case.BookRoom;

import main.java.entity.Room;
import main.java.entity.SuiteFactory;
import main.java.entity.RoomFactory;

public class BookRoomInteractor implements BookRoomInputBoundary {
    private final BookRoomDataAccessInterface suiteDataAccessObject;
    private final BookRoomOutputBoundary suitePresenter;
    private final SuiteFactory suiteFactory;

    public BookRoomInteractor(BookRoomDataAccessInterface roomDataAccessObject,
                              BookRoomOutputBoundary roomPresenter,
                              SuiteFactory suiteFactory) {
        this.suiteDataAccessObject = roomDataAccessObject;
        this.suitePresenter = roomPresenter;
        this.suiteFactory = suiteFactory;
    }

    @Override
    public void execute(BookRoomInputData bookroomInputData) {
        final Room suite = suiteFactory.createSuite(bookroomInputData.getName(), bookroomInputData.getRoomType());
        suiteDataAccessObject.save(suite);

        final BookRoomOutputData bookRoomOutputData = new BookRoomOutputData(suite.getRoomNumber(), suite.getRoomType(), suite.getPrice());
        suitePresenter.prepareSuccessView(bookRoomOutputData);
    }
}
