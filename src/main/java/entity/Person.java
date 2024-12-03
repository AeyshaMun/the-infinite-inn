package main.java.entity;

import java.util.ArrayList;

/**
 * The representation of a person in our program.
 */
public interface Person {

    /**
     * Returns the name of the person.
     * @return the name of the person.
     */
    String getName();

    String getAccommodations();

    ArrayList<Integer> getOrder();

    double getPrice();

    int getRoomNumber();
}
