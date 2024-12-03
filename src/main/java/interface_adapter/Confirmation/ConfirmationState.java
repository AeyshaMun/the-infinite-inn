package main.java.interface_adapter.Confirmation;

public class ConfirmationState {
    private int room_num;
    private String room_type;
    private double price;

    public int getRoomNum() {
        return room_num;
    }

    public String getRoomType() {
        return room_type;
    }

    public double getPrice() {
        return price;
    }

    public void setRoomNum(int room_num) {
        this.room_num = room_num;
    }

    public void setRoomType(String room_type) {
        this.room_type = room_type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "room_num ='" + room_num + '\''
                + ", room_type ='" + room_type + '\''
                + ", price ='" + price + '\'';
    }
}

