package main.java.use_case.BookRoom;

/**
 * The Input Data for the BookRoom Use Case.
 */
public class BookRoomInputData {

    private final String name;
    private final String room_type;
    private final String price;

    public BookRoomInputData(String name, String room_type, String price) {
        this.name = name;
        this.room_type = room_type;
        this.price = price;
    }

    String getName() {
        return name;
    }

    String getRoom_type() {
        return room_type;
    }

    String getPrice() {
        return price;
    }
}