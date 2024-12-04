package main.java.entity.eventbooking;

import main.java.entity.Person;
import main.java.entity.PersonFactory;

import java.util.ArrayList;

public interface ClientFactoryInterface extends PersonFactory {
    Person createClient(String name, String accommodations, ArrayList<Integer> order, EventBooking eventBooking);

}
