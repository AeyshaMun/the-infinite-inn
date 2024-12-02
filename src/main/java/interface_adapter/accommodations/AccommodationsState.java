package interface_adapter.accommodations;

public class AccommodationsState {
    private boolean isAccommodationsSaved;

    public boolean isAccommodationsSaved() {
        return isAccommodationsSaved;
    }

    public void setAccommodationsSaved(boolean accommodationsSaved) {
        isAccommodationsSaved = accommodationsSaved;
    }
}