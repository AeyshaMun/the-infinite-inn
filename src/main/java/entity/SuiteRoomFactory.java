package entity;

public class SuiteRoomFactory implements SuiteFactoryInterface {

    @Override
    public Suite createSuite(String name, String room_type) {
        return new SuiteRoom(name, room_type);
    }
}
