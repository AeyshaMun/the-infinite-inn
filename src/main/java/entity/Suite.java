package main.java.entity;

public class Suite implements Room {

    private final String personName;
    private final String roomNumber;
    private final String roomType;
    private final String roomPrice;

    public Suite(String personName, String roomNumber, String roomType, String roomPrice) {
        this.personName = personName;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    @Override
    public String getPersonName() {
        return personName;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String getPrice() {
        return roomPrice;
    }
}
