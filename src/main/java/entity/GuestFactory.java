package main.java.entity;

/**
 * The Guest Factory, which creates a Guest object.
 */
public class GuestFactory implements PersonFactory {

    @Override
    public Person create(String name, String accommodations) {
        return new Guest(name, accommodations);
    }
}
