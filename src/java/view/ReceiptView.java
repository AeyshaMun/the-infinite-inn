package view;

import java.interface_adapter.placeOrder.PlaceOrderState;
import java.interface_adapter.receipt.ReceiptViewModel;

/**
 * The View for the PlaceOrder Use Case.
 */
public class ReceiptView extends JPanel {
    private final String viewName = "receipt";
    private final ReceiptViewModel receiptViewModel;
    private final PlaceOrderState placeOrderState;

    public ReceiptView(ReceiptViewModel receiptViewModel, PlaceOrderState placeOrderState) {
        this.receiptViewModel = receiptViewModel;
        this.placeOrderState = placeOrderState;

        final JLabel title = new JLabel(ReceiptViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextPane receipt = new JTextPane();
        receipt.setText(placeOrderState.toString());
    }

    public String getViewName() {return viewName;}
}

