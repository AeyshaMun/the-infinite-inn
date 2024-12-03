package main.java.entity;

public interface InterfaceSuiteFactory extends RoomFactory {
    /**
     * Creates a new Suite room.
     *
     * @return the created Suite object.
     */
    public Suite createSuite(String name, String room_type);
}
