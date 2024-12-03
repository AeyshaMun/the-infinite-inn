package main.java.interface_adapter.BookRoomConfirm;

public class BookRoomConfirmState {
    private String room_num;
    private String room_type;
    private String price;

    public String getRoomNum() {
        return room_num;
    }

    public String getRoomType() {
        return room_type;
    }

    public String getPrice() {
        return price;
    }

    public void setRoomNum(String room_num) {
        this.room_num = room_num;
    }

    public void setRoomType(String room_type) {
        this.room_type = room_type;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ConfirmationState{"
                + "room_num='" + room_num + '\''
                + ", room_type='" + room_type + '\''
                + ", price='" + price + '\''
                + '}';
    }
}

