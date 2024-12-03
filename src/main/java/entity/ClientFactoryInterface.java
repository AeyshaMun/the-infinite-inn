package entity;

import java.util.ArrayList;

public interface ClientFactoryInterface extends PersonFactory {
    Person createClient(String name, String accommodations, ArrayList<Integer> order, EventBooking eventBooking);

}
