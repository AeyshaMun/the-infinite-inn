package main.java.entity;

public class SuiteRoom implements Suite {

    private static int roomCounter = 0;
    private final String name;
    private final String room_type;
    private int roomNumber;
    private final double price;

    public SuiteRoom(String name, String room_type) {
        this.name = name;
        this.room_type = room_type;
        generateRoomNumber();
        this.price = calculatePrice();
    }

    public String getName() {
        return name;
    }

    @Override
    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public void generateRoomNumber() {
        this.roomNumber = roomCounter++; // Assign current room number, then increment the counter
    }

    @Override
    public double calculatePrice() {
        if (room_type == "single") {
            return 120;
        } else if (room_type == "double") {
            return 180;
        } else if (room_type == "family") {
            return 220;
        } else {
            return 120;
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getRoomType() {
        return room_type;
    };

}



