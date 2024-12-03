package use_case.checkout;

public interface CheckoutOutputBoundary {
    /**
     * Prepares the success view
     * @param checkoutOutputData the output data
     */
    void prepareSuccessView(CheckoutOutputData checkoutOutputData);

    /**
     * Prepares the failure view
     * @param failureMessage the explanation of the failure
     */
    void prepareFailView(String failureMessage);
}
