package main.java.entity;

public class EventHallFactory implements RoomFactory {
    private int capacity;
    private boolean isIndoors;

    public EventHallFactory(int capacity, boolean isIndoors) {
        this.capacity = capacity;
        this.isIndoors = isIndoors;
    }

    @Override
    public Room create() {
        // Create and return a new EventHall instance
        return new EventHall(capacity, isIndoors);
    }
}



