package main.java.entity.roombooking;

public interface SuiteFactoryInterface extends RoomFactory {
    /**
     * Creates a new Suite room.
     *
     * @return the created Suite object.
     */
    Room createSuite(String name, String room_type);
}
