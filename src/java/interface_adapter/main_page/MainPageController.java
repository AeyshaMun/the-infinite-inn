package java.interface_adapter.main_page;

import java.use_case.main_page.MainPageInputBoundary;

/**
 * Controller for the main page Use Case.
 */
public class MainPageController {

    private final MainPageInputBoundary mainPageInteractor;

    public MainPageController(MainPageInputBoundary mainPageInteractor) {
        this.mainPageInteractor = mainPageInteractor;
    }

    public void switchToBookRoomView() {
        mainPageInteractor.switchToBookRoomView();}

    public void switchToBookEventView() {
        mainPageInteractor.switchToBookEventView();}

    public void switchToLoginView() {
        mainPageInteractor.switchToLoginView();}
}
