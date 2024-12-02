package interface_adapter.login;

import main.java.interface_adapter.ViewManagerModel;
import main.java.interface_adapter.logged_in.LoggedInState;
import main.java.interface_adapter.logged_in.LoggedInViewModel;
import main.java.interface_adapter.main_page.MainPageViewModel;
import main.java.use_case.login.LoginOutputBoundary;
import main.java.use_case.login.LoginOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final MainPageViewModel mainPageViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
        this.mainPageViewModel = mainPageViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        final LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setName(response.getName());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setState(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final LoginState loginState = loginViewModel.getState();
        loginState.setLoginError(error);
        loginViewModel.firePropertyChanged();
    }

    @Override
    public void switchToMainView() {
        viewManagerModel.setState(mainPageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
