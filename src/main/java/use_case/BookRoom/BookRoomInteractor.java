package main.java.use_case.BookRoom;

import main.java.entity.RoomFactory;
import main.java.entity.SuiteFactories.SingleFactory;

public class BookRoomInteractor implements BookRoomInputBoundary {
    private final BookRoomDataAccessInterface roomDataAccessObject;
    private final BookRoomOutputBoundary roomPresenter;
    private final RoomFactory roomFactory;

    public BookRoomInteractor(BookRoomDataAccessInterface roomDataAccessObject,
                              BookRoomOutputBoundary roomPresenter,
                              RoomFactory roomFactory) {
        this.roomDataAccessObject = roomDataAccessObject;
        this.roomPresenter = roomPresenter;
        this.roomFactory = roomFactory;
    }

    @Override
    public void execute(BookRoomInputData bookroomInputData) {

        if (bookroomInputData.getRoomType() == "single") {

        } else if (bookroomInputData.getRoomType() == "double") {

        } else if (bookroomInputData.getRoomType() == "family") {

        } else {

        }

        final Suite suite = SingleFactory.create(bookroomInputData.getName(), bookroomInputData.getRoomType());
        roomDataAccessObject.save(suite);

            final SignupOutputData signupOutputData = new SignupOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(signupOutputData);

    }

}
