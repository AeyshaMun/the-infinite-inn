package interface_adapter.signup;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Signup View.
 */
public class SignupViewModel extends ViewModel<SignupState> {

    public static final String TITLE_LABEL = "Sign Up";
    public static final String USERNAME_LABEL = "Enter name";
    public static final String EMAIL_LABEL = "Enter e-mail";
    public static final String PHONE_LABEL = "Enter phone number";
    public static final String ARRIVAL_LABEL = "Enter arrival date (dd-mm-yyyy)";
    public static final String DEPARTURE_LABEL = "Enter departure date (dd-mm-yyyy)";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";

    public SignupViewModel() {
        super("sign up");
        setState(new SignupState());
    }

}
