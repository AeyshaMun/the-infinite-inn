package java.use_case.checkout;

public interface CheckoutInputBoundary {

    /**
     * Executes the Checkout use case.
     * @param CheckoutInputData the input data
     */
    void execute(CheckoutInputData CheckoutInputData);
}
