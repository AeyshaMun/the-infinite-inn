package interface_adapter.checkout;

import interface_adapter.ViewManagerModel;

import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.checkout.CheckoutOutputBoundary;
import use_case.checkout.CheckoutOutputData;

/**
 * The presenter for the Checkout use case.
 */
public class CheckoutPresenter implements CheckoutOutputBoundary {

    private final LoggedInViewModel loggedInViewModel;
    private final LoginViewModel loginViewModel;
    private final CheckoutViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public CheckoutPresenter(LoggedInViewModel loggedInViewModel, LoginViewModel loginViewModel,
                             CheckoutViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CheckoutOutputData response) {
        // 1. Get the LoggedInState out of the appropriate View Model
        final LoggedInState loggedInState = loggedInViewModel.getState();

        // 2. Clear user details after checkout (acts like a logout)
        loggedInState.setName("");  // Clear the name (log out the user)

        // 3. Set the state in the LoggedInViewModel to the updated state
        loggedInViewModel.setState(loggedInState);

        // 4. Fire PropertyChangeEvent to notify the view of the updated state
        loggedInViewModel.firePropertyChanged();

        // 5. Get the LoginState and clear it as well
        final LoginState loginState = loginViewModel.getState();
        loginState.setName("");  // Clear the login information
        loginState.setRoomNumber(0);  // Clear the room number

        // 6. Set the updated state in the LoginViewModel
        loginViewModel.setState(loginState);

        // 7. Fire PropertyChangeEvent to notify the view of the updated state
        loginViewModel.firePropertyChanged();

        // 8. This code tells the View Manager to switch to the LoginView (log out the user)
        this.viewManagerModel.setState(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String error) {
        // 1. Get the CheckoutState out of the CheckoutViewModel
        CheckoutState newState = viewModel.getState();

        // 2. Update the state for failure
        newState.setMessage(error);

        // Set the updated state in the CheckoutViewModel
        viewModel.setState(newState);

        // Fire PropertyChangeEvent to notify the view of the updated state
        viewModel.firePropertyChanged();
    }

    @Override
    public void switchtoLoggedInView(){
        viewManagerModel.setState(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

