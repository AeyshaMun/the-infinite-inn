package use_case.main_page;

/**
 * The main page Interactor.
 */


public class MainPageInteractor implements MainPageInputBoundary {

    private final MainPageOutputBoundary mainPagePresenter;

    public MainPageInteractor(MainPageOutputBoundary mainPagePresenter) {
        this.mainPagePresenter = mainPagePresenter;
    }


    @Override
    public void switchToBookRoomView() {
        mainPagePresenter.switchToBookRoomView();
    }

    @Override
    public void switchToBookEventView() {
        mainPagePresenter.switchToBookEventView();
    }

    @Override
    public void switchToLoginView() {
        mainPagePresenter.switchToLoginView();
    }
}
