package main.java.use_case.BookRoom;

/**
 * The Input Data for the BookRoom Use Case.
 */
public class BookRoomInputData {

    private final String name;
    private final String room_type;

    public BookRoomInputData(String name, String room_type) {
        this.name = name;
        this.room_type = room_type;
    }

    String getName() {
        return name;
    }

    String getRoomType() {
        return room_type;
    }

}