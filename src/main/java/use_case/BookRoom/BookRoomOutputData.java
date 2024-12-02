package use_case.BookRoom;

public class BookRoomOutputData {

    private final String room_num;
    private final String room_type;
    private final String price;

    public BookRoomOutputData(String room_num, String room_type, String price) {
        this.room_num = room_num;
        this.room_type = room_type;
        this.price = price;
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
}
