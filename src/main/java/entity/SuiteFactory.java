package main.java.entity;

public class SuiteFactory implements RoomFactory {

    private String name;
    private String room_type;

    public SuiteFactory(String name, String room_type) {
        this.name = name;
        this.room_type = room_type;
    }
    @Override
    public Room create() {
        return new Suite(name, room_type);
    }
}
