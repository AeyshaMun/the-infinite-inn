package main.java.entity;

public class SuiteFactory implements RoomFactory {

    @Override
    public Room createSuite(String name, String room_type) {
        return new Suite(name, room_type);
    }

    @Override
    public Room createEventHall(int partySize) {
        throw new UnsupportedOperationException("SuiteFactory cannot create EventHall.");
    }
}
