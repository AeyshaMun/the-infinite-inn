package use_case.eventdetails;

/**
 * The Input Data for the Event Details Use Case.
 */
public class EventDetailsInputData {

    private final String name;
    private final String eventDate;
    private final int partySize;

    public EventDetailsInputData(String name, String eventDate, int partySize) {
        this.name = name;
        this.eventDate = eventDate;
        this.partySize = partySize;
    }

    String getName() {
        return name;
    }

    public String getEventDate() {
        return eventDate;
    }

    public int getPartySize() {
        return partySize;
    }
}
