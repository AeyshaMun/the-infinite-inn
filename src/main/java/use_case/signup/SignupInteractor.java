package UseCase.signup;

import Entity.Guest;
import Entity.GuestFactory;

public class SignupInteractor implements SignupInputBoundary {
    private final SignupUserDataAccessInterface guestDataAccessObject;
    private final SignupOutputBoundary guestPresenter;
    private final GuestFactory guestFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            GuestFactory guestFactory) {
        this.guestDataAccessObject = signupDataAccessInterface;
        this.guestPresenter = signupOutputBoundary;
        this.guestFactory = guestFactory;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (guestDataAccessObject.existsByName(signupInputData.getUsername())) {
            guestPresenter.prepareFailView("User already exists.");
        }
        else {
            final Guest guest = guestFactory.create(signupInputData.getUsername(), signupInputData.getEmail(), signupInputData.getPhone(), signupInputData.getArrival(), signupInputData.getDeparture());
            guestDataAccessObject.save(guest);

            final SignupOutputData signupOutputData = new SignupOutputData(false);
            guestPresenter.prepareSuccessView(signupOutputData);
        }
    }

    @Override
    public void switchToLoginView() {
        guestPresenter.switchToLoginView();
    }
}
