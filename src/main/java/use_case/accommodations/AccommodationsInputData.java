package use_case.accommodations;

/**
 * The input data for the Accommodations Use Case
 */
public class AccommodationsInputData {
    private final String accommodations;

    public AccommodationsInputData(String accommodations) {
        this.accommodations = accommodations;
    }
    String getAccommodations() {
        return accommodations;
    }
}
