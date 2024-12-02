package main.java.use_case.eventforecast;

public class EventForecastInputData {
    private String name;
    private String eventDate;
    private int partySize;
    private Boolean isIndoor;

    public EventForecastInputData(String name, String eventDate, int partySize, Boolean isIndoor) {
        this.name = name;
        this.eventDate = eventDate;
        this.partySize = partySize;
        this.isIndoor = isIndoor;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    Boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(Boolean indoor) {
        isIndoor = indoor;
    }
}
