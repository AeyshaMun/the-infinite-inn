package use_case.place_order;

import java.util.ArrayList;

/**
 * DAO for the place order Use Case.
 */
public interface PlaceOrderDataAccessInterface {

    /**
     * Saves the food order.
     * @param items the order to save
     */
    void saveOrder(ArrayList<Integer> items, int room);

    /**
     * Gets the food order.
     * @param room the room of guest the guest to retrieve food order from

     */
    ArrayList<Integer> getOrder(int room);


}
