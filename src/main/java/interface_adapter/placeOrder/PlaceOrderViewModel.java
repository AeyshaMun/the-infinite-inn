package interface_adapter.placeOrder;

import main.java.interface_adapter.ViewModel;

/**
 * The ViewModel for the place order View.
 */
public class PlaceOrderViewModel extends ViewModel<PlaceOrderState> {

    public static final String TITLE_LABEL = "Order View";
    public static final String ITEM1_LABEL = "Fish and Chips";
    public static final String ITEM2_LABEL = "Cabbage Soup";
    public static final String ITEM3_LABEL = "Root Beer";
    public static final String ROOM_LABEL = "Room number";

    public static final String PLACE_BUTTON_LABEL = "Place order";

    public static final String BACK_BUTTON_LABEL = "back";

    public PlaceOrderViewModel() {
        super("order");
        setState(new PlaceOrderState());
    }

}
