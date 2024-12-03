package use_case.place_order;

import java.util.ArrayList;

/**
 * The Input Data for the place order Use Case.
 */
public class PlaceOrderInputData {

    private final ArrayList<Integer> items;
    private final int roomNumber;

    public PlaceOrderInputData(ArrayList<Integer> items, int roomNumber) {
        this.items = items;
        this.roomNumber = roomNumber;
    }

    int getRoomNumber() {return roomNumber;}

    ArrayList<Integer> getItems() {return items;}

}
