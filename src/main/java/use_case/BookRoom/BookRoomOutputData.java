package main.java.use_case.BookRoom;

public class BookRoomOutputData {

    private final int room_num;
    private final String room_type;
    private final double price;
    private final boolean useCaseFailed;

    public BookRoomOutputData(int room_num, String room_type, double price, boolean useCaseFailed) {
        this.room_num = room_num;
        this.room_type = room_type;
        this.price = price;
        this.useCaseFailed = useCaseFailed;
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

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
