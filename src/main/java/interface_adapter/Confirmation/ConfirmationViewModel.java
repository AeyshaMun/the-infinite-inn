package main.java.interface_adapter.Confirmation;
import main.java.interface_adapter.ViewModel;

public class ConfirmationViewModel extends ViewModel<ConfirmationState> {

    public static final String MESSAGE = "Congratulations! You have made your booking.";

    public ConfirmationViewModel() {
        super("Book Room Confirmation");
        setState(new ConfirmationState());
    }
}

