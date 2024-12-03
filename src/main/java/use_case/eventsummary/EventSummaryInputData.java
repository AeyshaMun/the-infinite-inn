package use_case.eventsummary;

public class EventSummaryInputData {
    private final String name;
    private final String eventDate;
    private final int partySize;
    private final Boolean isIndoor;
    private final int roomNumber;
    private final double amountDue;

    public EventSummaryInputData(String name, String eventDate, int partySize, Boolean isIndoor, int roomNumber, double amountDue) {
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
}
