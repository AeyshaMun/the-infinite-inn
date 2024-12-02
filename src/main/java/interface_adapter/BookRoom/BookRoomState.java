package main.java.interface_adapter.BookRoom;

/**
 * The state for the BookRoom View Model.
 */

public class BookRoomState {
    private String name = "";
    private String room_num;
    private String room_type;
    private String price;

    // getter methods
    public String getName() {
        return name;
    }

    public String getRoomNum() {
        return room_num;
    }

    public String getRoomType() {
        return room_type;
    }

    public String getPrice() {
        return price;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
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
        return "BookroomState{"
                + "name='" + name + '\''
                + ", room_num='" + room_num + '\''
                + ", room_type='" + room_type + '\''
                + ", price='" + price + '\''
                + '}';
    }
}
