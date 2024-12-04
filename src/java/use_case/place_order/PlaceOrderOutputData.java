package use_case.place_order;

import java.util.ArrayList;

/**
 * Output Data for the place order Use Case.
 */
public class PlaceOrderOutputData {

    private final ArrayList<Integer> order;

    private final boolean useCaseFailed;

    public PlaceOrderOutputData(ArrayList<Integer> order, boolean useCaseFailed) {
        this.order = order;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<Integer> getOrder() {
        return order;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
