package use_case.accommodations;

public interface AccommodationsOutputBoundary {

    void prepareSuccessView(AccommodationsOutputData outputData);

    void prepareFailView(String errorMessage);
}
