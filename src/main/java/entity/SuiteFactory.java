package entity;

public class SuiteFactory implements InterfaceSuiteFactory {

    @Override
    public Room createSuite(String name, String room_type) {
        return new SuiteRoom(name, room_type);
    }
}
