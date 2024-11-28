package main.java.entity;

public class RoomFactory {

//    Room create(String name, String room_num, String room_type, String price);

    public Room create(String name, String room_num, String room_type, String price) {
        return new Room(name, room_num, room_type, price);
    }

}
