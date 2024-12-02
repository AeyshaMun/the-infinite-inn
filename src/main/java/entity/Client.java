package main.java.entity;

public class Client implements Person {
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
