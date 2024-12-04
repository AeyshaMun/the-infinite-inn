package java.interface_adapter.main_page;

import java.interface_adapter.ViewModel;

/**
 * The View Model for the main page View.
 */
public class MainPageViewModel extends ViewModel<MainPageState> {

    public MainPageViewModel() {
        super("main page");
        setState(new MainPageState());
    }

}