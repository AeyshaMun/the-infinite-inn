package interface_adapter.receipt;

import interface_adapter.ViewModel;

/**
 * The View Model for the Receipt View.
 */
public class ReceiptViewModel extends ViewModel<ReceiptState> {

    public static final String TITLE_LABEL = "Order placed. Thank you!";

    public ReceiptViewModel() {
        super("receipt");
        setState(new ReceiptState());
    }

}
