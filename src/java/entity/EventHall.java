package java.entity;

public class EventHall implements Room {
    private static int roomCounter;
    private int roomNumber;
    private final int partySize;
    private final double price;

    public EventHall(int partySize) {
        this.partySize = partySize;
        this.price = calculatePrice();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getPartySize() {
        return partySize;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void generateRoomNumber() {
        this.roomNumber = roomCounter++; // Assign current room number, then increment the counter
    }

    @Override
    public double calculatePrice() {
        // Your provided price calculation logic based on capacity
        if (partySize <= 30) {
            return 200.0;  // Price for small events
        } else if (partySize <= 100) {
            return 350.0;  // Price for medium events
        } else if (partySize <= 300) {
            return 500.0;  // Price for large events
        } else {
            return 1500.0;  // Price for extra-large events
        }
    }

}
