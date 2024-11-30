package main.java.entity;

/**
 * A simple implementation of the Person interface.
 */
public class Client implements Person {

    private final String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
