package main.java.use_case.BookRoom;

import main.java.entity.RoomFactory;
import main.java.entity.SuiteFactory;

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
        final SuiteFactory suite = new SuiteFactory(bookroomInputData.getName(), bookroomInputData.getRoomType());
        suite.create();
        suiteDataAccessObject.save(suite);

        final SignupOutputData signupOutputData = new SignupOutputData(room.getName(), false);
        userPresenter.prepareSuccessView(signupOutputData);


    }

}
