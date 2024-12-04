package main.java.use_case.eventforecast;

public class EventForecastFirstInputData {
    private String name;
    private String eventDate;
    private int partySize;

    public EventForecastFirstInputData(String name, String eventDate, int partySize) {
        this.name = name;
        this.eventDate = eventDate;
        this.partySize = partySize;
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
}
