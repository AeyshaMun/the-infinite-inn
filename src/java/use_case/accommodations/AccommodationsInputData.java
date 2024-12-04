package use_case.accommodations;

/**
 * The input data for the Accommodations Use Case.
 */
public class AccommodationsInputData {
    /**
     * The specific comment of the accommodations.
     */
    private final String name;
    private final String accommodations;

    public AccommodationsInputData(String name, String accommodations) {
        this.name = name;
        this.accommodations = accommodations;
    }

    public String getName() {
        return name;
    }

    public String getAccommodations() {
        return accommodations;
    }
}
