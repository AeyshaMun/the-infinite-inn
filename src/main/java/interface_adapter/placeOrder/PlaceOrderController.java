package interface_adapter.placeOrder;

import use_case.place_order.PlaceOrderInputBoundary;
import use_case.place_order.PlaceOrderInputData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controller for the place order Use Case.
 */
public class PlaceOrderController {

    private final PlaceOrderInputBoundary placeOrderInteractor;

    public PlaceOrderController(PlaceOrderInputBoundary placeOrderInteractor) {
        this.placeOrderInteractor = placeOrderInteractor;
    }

    /**
     * Executes the Signup Use Case.
     * @param item1 the quantity of item1
     * @param item2 the quantity of item2
     * @param item3 the quantity of item3
     * @param roomNumber the roomNumber
     */
    public void execute(String item1, String item2, String item3, String roomNumber) {
        List<String> list = Arrays.asList(item1, item2, item3, roomNumber);
        ArrayList<Integer> items = new ArrayList<>();
        for (String item : list) {
            if (item == null) {
                items.add(0);
            } else {
                items.add(Integer.parseInt(item));
            }
        }
        int room = items.get(2);
        items.remove(2);

        final PlaceOrderInputData placeOrderInputData = new PlaceOrderInputData(items, room);

        placeOrderInteractor.execute(placeOrderInputData);
    }

    public void switchToLoggedInView() {placeOrderInteractor.switchToLoggedInView();}
}
