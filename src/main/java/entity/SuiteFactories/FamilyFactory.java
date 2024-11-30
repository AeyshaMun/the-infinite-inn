package main.java.entity.SuiteFactories;

import main.java.entity.Room;
import main.java.entity.RoomFactory;
import main.java.entity.Suite;

public class FamilyFactory implements RoomFactory {

    @Override
    public Room create(String personName, String roomNumber) {
        String roomType = "family";
        String roomPrice = "$220";
        return new Suite(personName, roomNumber, roomType, roomPrice);
    }
}