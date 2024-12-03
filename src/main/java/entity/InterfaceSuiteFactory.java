package entity;

public interface InterfaceSuiteFactory extends RoomFactory {
    /**
     * Creates a new Suite room.
     *
     * @return the created Suite object.
     */
    Room createSuite(String name, String room_type);
}
