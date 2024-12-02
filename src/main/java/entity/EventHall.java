package entity;

/**
 * Represents an Event Hall, a type of room in the system.
 * This class implements the Room interface and includes additional functionality
 * specific to an Event Hall, including price calculation based on capacity.
 */
public class EventHall implements Room {
    private static int roomCounter = 0; // Static counter for room numbers
    private int roomNumber;
    private double price;
    private int capacity;
    private boolean isIndoors;

    public EventHall(int capacity, boolean isIndoors) {
        this.capacity = capacity;
        this.isIndoors = isIndoors;
        generateRoomNumber(); // Automatically generate a unique room number
        this.price = calculatePrice(); // Calculate the price based on capacity
    }

    @Override
    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void generateRoomNumber() {
        roomNumber = roomCounter++; // Assign current room number, then increment the counter
    }

    @Override
    public double calculatePrice() {
        // Your provided price calculation logic based on capacity
        if (capacity < 30) {
            return 200.0;  // Price for small events
        } else if (capacity < 100) {
            return 350.0;  // Price for medium events
        } else if (capacity < 300) {
            return 500.0;  // Price for large events
        } else {
            return 1500.0;  // Price for extra-large events ( < 500)
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    // Additional getter methods
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setIsIndoors(boolean isIndoors) {
        this.isIndoors = isIndoors;
    }

    public boolean getIsIndoors() {
        return isIndoors;
    }
}
