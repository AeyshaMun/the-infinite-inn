package use_case.BookRoom;

public class BookRoomOutputData {

    private final int room_num;
    private final String room_type;
    private final double price;

    public BookRoomOutputData(int room_num, String room_type, double price) {
        this.room_num = room_num;
        this.room_type = room_type;
        this.price = price;
    }

    public int getRoomNum() {
        return room_num;
    }

    public String getRoomType() {
        return room_type;
    }

    public double getPrice() {
        return price;
    }
}
