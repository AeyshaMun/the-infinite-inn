package java.interface_adapter.eventsummary;

public class EventSummaryState {
    private String summary = "";
    private String name = "";
    private String partySize = "";
    private Boolean isIndoor = null;
    private int roomNumber = 0;
    private double amountDue = 0.0;


    public void setSummaryText(String summaryText) {
        this.summary = summaryText;
    }

    public String getSummaryText() {
        return summary;
    }

    public void setEventDate(String eventDate) {
        this.name = eventDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartySize(String partySize) {
        this.partySize = partySize;
    }

    public void setIsIndoor(Boolean isIndoor) {
        this.isIndoor = isIndoor;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }
}
