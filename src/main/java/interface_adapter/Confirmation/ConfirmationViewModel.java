package interface_adapter.Confirmation;
import interface_adapter.ViewModel;

public class ConfirmationViewModel extends ViewModel<ConfirmationState> {

    public static final String MESSAGE = "Congratulations! You have made your booking.";
    public static final String BUTTON_LABEL = "Exit";

    public ConfirmationViewModel() {
        super("Book Room Confirmation");
        setState(new ConfirmationState());
    }
}

