package main.java.entity;

/**
 * Factory for creating users.
 */
public interface PersonFactory {
    /**
     * Creates a new Person.
     * @param name the name of the new person
     * @return the new person
     */
    Person create(String name, String accommodations);

}