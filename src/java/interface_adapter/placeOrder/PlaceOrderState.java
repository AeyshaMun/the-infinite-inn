package java.interface_adapter.placeOrder;

/**
 * The state for the place order View Model.
 */
public class PlaceOrderState {
    private int item1;
    private int item2;
    private int item3;
    private int roomNumber;
    private String orderError;

    public int getItem1() {
        return item1;
    }


    public int getItem2() {
        return item2;
    }

    public int getItem3() {
        return item3;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getOrderError() {
        return orderError;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public void setRoomNumber(int item3) {
        this.item3 = item3;
    }

    public void setOrderError(String emptyError) {
        this.orderError = orderError;
    }

    @Override
    public String toString() {
        return "PlaceOrderState{"
                + "Fish and Chips: '" + String.valueOf(item1) + '\''
                + "Cabbage Soup: '" + String.valueOf(item2) + '\''
                + "Root Beer: '" + String.valueOf(item3) + '\''
                + '}';
    }
}
