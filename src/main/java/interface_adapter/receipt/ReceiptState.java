package interface_adapter.receipt;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the Receipt View Model.
 */
public class ReceiptState {
    private ArrayList<Integer> order;

    public List<Integer> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Integer> order) {
        this.order = order;
    }


}
