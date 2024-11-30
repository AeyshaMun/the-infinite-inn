package main.java.entity;

public class SuiteFactory extends RoomFactory {

    @Override
    public Room create(String personName, String roomNumber, String roomType, String roomPrice) {
        return new Suite(personName, roomNumber, roomType, roomPrice);
    }
}
