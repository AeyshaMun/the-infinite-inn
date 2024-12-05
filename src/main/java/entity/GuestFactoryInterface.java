package entity;

import java.util.ArrayList;

public interface GuestFactoryInterface extends PersonFactory {
    Person createGuest(String name, String accommodations, ArrayList<Integer> order, SuiteRoom suiteRoom);
}
