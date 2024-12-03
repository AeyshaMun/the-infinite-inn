package main.java.entity;

public class SuiteRoomFactory implements InterfaceSuiteFactory {

    @Override
    public Suite createSuite(String name, String room_type) {
        return new SuiteRoom(name, room_type);
    }
}
