package main.java.use_case.eventforecast;

public class EventForecastOutputData {
    private String name;
    private String eventDate;
    private int partySize;
    private Boolean isIndoor;
    private int roomNumber;
    private double amountDue;
    private boolean useCaseFailed;

    public EventForecastOutputData(String name, String eventDate, int partySize, Boolean isIndoor, int roomNumber, double amountDue, boolean useCaseFailed) {
        this.name = name;
        this.eventDate = eventDate;
        this.partySize = partySize;
        this.isIndoor = isIndoor;
        this.roomNumber = roomNumber;
        this.amountDue = amountDue;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return name;
    }

    public String getEventDate() {
        return eventDate;
    }

    public int getPartySize() {
        return partySize;
    }

    public Boolean isIndoor() {
        return isIndoor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public void setIndoor(Boolean isIndoor) {
        this.isIndoor = isIndoor;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public void setUseCaseFailed(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }
}

