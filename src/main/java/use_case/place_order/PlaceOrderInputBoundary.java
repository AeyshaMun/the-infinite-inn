package use_case.place_order;

/**
 * Input Boundary for actions which are related to placing order.
 */
public interface PlaceOrderInputBoundary {

    /**
     * Executes the place order use case.
     * @param placeOrderInputData the input data
     */
    void execute(PlaceOrderInputData placeOrderInputData);

    void switchToLoggedInView();
}
