package main.java.entity;

import java.util.ArrayList;

public class GuestFactory implements GuestFactoryInterface {

    @Override
    public Person createGuest(String name, String accommodations, ArrayList<Integer> order, SuiteRoom suiteRoom) {
            return new Guest(name, accommodations, order, suiteRoom);
        }

}
