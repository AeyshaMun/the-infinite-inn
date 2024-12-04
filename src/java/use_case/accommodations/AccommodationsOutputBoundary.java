package use_case.accommodations;

public interface AccommodationsOutputBoundary {
    /**
     * Prepare the success view.
     * @param outputData the output data for this use case.
     */
    void prepareSuccessView(AccommodationsOutputData outputData);

    void prepareFailView(String errorMessage);
}
