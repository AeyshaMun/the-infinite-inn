package use_case.eventdetails;

public class EventDetailsOutputData {
    private final String name;
    private final String eventDate;
    private final int partySize;
    private final boolean useCaseFailed;

    public EventDetailsOutputData(String name, String eventDate, int partySize, boolean useCaseFailed) {
        this.name = name;
        this.eventDate = eventDate;
        this.partySize = partySize;
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

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }
}
