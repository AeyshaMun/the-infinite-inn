package interface_adapter.eventdetails;

/**
 * The state for the Event Details View Model.
 */
public class EventDetailsState {
    private String name = "";
    private String nameError;
    private String eventDate = "";
    private String eventDateError;
    private String partySize = "";
    private String partySizeError = "";

    public String getName() {
        return name;
    }

    public Object getNameError() {
        return nameError;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventDateError() {
        return eventDateError;
    }

    public String getPartySize() {
        return partySize;
    }

    public String getPartySizeError() {
        return partySizeError;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventDateError(String eventDateError) {
        this.eventDateError = eventDateError;
    }

    public void setPartySize(String partySize) {
        this.partySize = partySize;
    }

    public void setPartySizeError(String partySizeError) {
        this.partySizeError = partySizeError;
    }

    @Override
    public String toString() {
        return "EventDetailsState{"
                + "name='" + name + '\''
                + ", eventDate='" + eventDate + '\''
                + ", partySize='" + partySize + '\''
                + '}';
    }
}
