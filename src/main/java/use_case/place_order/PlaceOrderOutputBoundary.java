package use_case.place_order;

/**
 * The output boundary for the place order Use Case.
 */
public interface PlaceOrderOutputBoundary {

    /**
     * Prepares the success view for the place order Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(PlaceOrderOutputData outputData);

    /**
     * Prepares the failure view for the place order Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);


    void switchToLoggedInView();
}
