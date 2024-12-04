package main.java.interface_adapter.eventforecast;

/**
 * The state for the Event Forecast View Model.
 */
public class EventForecastState {
    private String eventDate = "";
    private String name = "";
    private String partySize = "";
    private Boolean isIndoor = null;
    private boolean isOutdoorSuitable = false;  // Added for outdoor suitability
    private String weatherDescription = "";     // Added to store weather description
    private boolean isEstimated = false;        // Added to indicate if the forecast is estimated
    private String error = "";

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartySize(String partySize) {
        this.partySize = partySize;
    }

    public String getPartySize() {
        return partySize;
    }

    public Boolean getIsIndoor() {
        return isIndoor;
    }

    public void setIsIndoor(Boolean isIndoor) {
        this.isIndoor = isIndoor;
    }

    public boolean isOutdoorSuitable() {
        return isOutdoorSuitable;
    }

    public void setOutdoorSuitable(boolean isOutdoorSuitable) {
        this.isOutdoorSuitable = isOutdoorSuitable;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public boolean isEstimated() {
        return isEstimated;
    }

    public void setEstimated(boolean isEstimated) {
        this.isEstimated = isEstimated;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "EventForecastState{" +
                "name='" + name + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", partySize='" + partySize + '\'' +
                ", isIndoor=" + isIndoor +
                ", isOutdoorSuitable=" + isOutdoorSuitable +
                ", weatherDescription='" + weatherDescription + '\'' +
                ", isEstimated=" + isEstimated +
                '}';
    }
}
