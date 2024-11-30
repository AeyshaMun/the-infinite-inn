package main.java.entity.SuiteFactories;

import main.java.entity.Room;
import main.java.entity.RoomFactory;
import main.java.entity.Suite;

public class SingleFactory implements RoomFactory {

    @Override
    public Room create(String personName, String roomNumber, String roomPrice) {
        String roomType = "single";
        return new Suite(personName, roomNumber, roomType, roomPrice);
    }
}
