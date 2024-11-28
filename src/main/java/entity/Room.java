package main.java.entity;

public class Room {
    private final String name;
    private final String room_num;
    private final String room_type;
    private final String price;

    public Room(String name, String room_num, String room_type, String price) {
        this.name = name;
        this.room_num = room_num;
        this.room_type = room_type;
        this.price = price;
    }

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
}
