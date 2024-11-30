package main.java.entity.SuiteFactories;

import main.java.entity.Room;
import main.java.entity.RoomFactory;
import main.java.entity.Suite;

public class AccessibleFactory implements RoomFactory {

    @Override
    public Room create(String personName, String roomNumber) {
        String roomType = "accessible";
        String roomPrice = "$120";
        return new Suite(personName, roomNumber, roomType, roomPrice);
    }
}

