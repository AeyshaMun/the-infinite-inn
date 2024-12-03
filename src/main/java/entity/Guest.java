package main.java.entity;

import data_access.DBPersonDataAccessObject;

import java.util.ArrayList;

public class Guest implements Person {
    /**
     * The name and accommodations of the guest.
     */
    private final String name;
    private final String accommodations;
    private final ArrayList<Integer> order;
    private final SuiteRoom suiteRoom;

    public Guest(String name, String accommodations, ArrayList<Integer> order, SuiteRoom suiteRoom) {
        this.name = name;
        this.accommodations = "";
        this.order = order;
        this.suiteRoom = suiteRoom;

        DBPersonDataAccessObject.savePerson(this);
    }

    public String getName() {
        return name;
    }

    public String getAccommodations() {
        return accommodations;
    }

    @Override
    public ArrayList<Integer> getOrder() {
        return order;
    }

    @Override
    public double getPrice() {
        return suiteRoom.getPrice();
    }

    @Override
    public int getRoomNumber() {
        return suiteRoom.getRoomNumber();
    }

    public String getRoomType() {
        return suiteRoom.getRoomType();
    }
}
