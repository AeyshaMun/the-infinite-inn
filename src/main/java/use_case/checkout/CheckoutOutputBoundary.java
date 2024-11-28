package java.use_case.checkout;

public interface CheckoutOutputBoundary {
    /**
     * Prepares the success view
     * @param outputData the output data
     */
    void prepareSuccessView(CheckoutOutputData outputData);

    /**
     * Prepares the failure view
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
