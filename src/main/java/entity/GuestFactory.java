package entity;

import entity.Person;

public class GuestFactory implements PersonFactory {

    @Override
    public Person create(String name, String accommodations) {
            return new Guest(name, accommodations);
        }

}
