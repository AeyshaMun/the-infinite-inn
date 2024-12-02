package use_case.eventsummary;

public class EventSummaryOutputData {
    private String name;
    private String eventDate;
    private int partySize;
    private Boolean isIndoor;
    private int roomNumber;
    private double amountDue;

    public EventSummaryOutputData(String name, String eventDate, int partySize, Boolean isIndoor, int roomNumber, double amountDue) {
        this.name = name;
        this.eventDate = eventDate;
        this.partySize = partySize;
        this.isIndoor = isIndoor;
        this.roomNumber = roomNumber;
        this.amountDue = amountDue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public Boolean getIsIndoor() {
        return isIndoor;
    }

    public void setIsIndoor(Boolean isIndoor) {
        this.isIndoor = isIndoor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }
}
