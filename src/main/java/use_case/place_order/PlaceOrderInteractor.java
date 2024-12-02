package use_case.place_order;

import main.java.entity.OrderFactory;


/**
 * The placeOrder Interactor.
 */

//The interactor executes use case: placing order
//Saves order under "Food Order" for guest in guest data
    // If the order is empty (0,0,0), then prepare fail view
    // If the order is not empty, prepare success view
public class PlaceOrderInteractor implements PlaceOrderInputBoundary {
    private final PlaceOrderDataAccessInterface guestData;
    private final PlaceOrderOutputBoundary placeOrderPresenter;
    private final OrderFactory orderFactory;

    public PlaceOrderInteractor(PlaceOrderDataAccessInterface placeOrderDataAccessInterface,
                                PlaceOrderOutputBoundary placeOrderOutputBoundary,
                                OrderFactory orderFactory) {
        this.guestData = placeOrderDataAccessInterface;
        this.placeOrderPresenter = placeOrderOutputBoundary;
        this.orderFactory = orderFactory;
    }

    @Override
    public void execute(PlaceOrderInputData placeOrderInputData) {
        int sum = 0;
        for (int item : placeOrderInputData.getItems()) {
            sum += item;
        }
        if (sum == 0) {
            placeOrderPresenter.prepareFailView("Add items to order");
        }
        else if (placeOrderInputData.getRoomNumber() == 0) {
            placeOrderPresenter.prepareFailView("Add valid room number");
        }
        //add order to guest and prepare successView
        else {
            guestData.saveOrder(placeOrderInputData.getItems(), placeOrderInputData.getRoomNumber());

            final PlaceOrderOutputData placeOrderOutputData = new PlaceOrderOutputData(
                    guestData.getOrder(placeOrderInputData.getRoomNumber()), false);
            placeOrderPresenter.prepareSuccessView(placeOrderOutputData);
        }
    }

    public void switchToLoggedInView() {
        placeOrderPresenter.switchToLoggedInView();
    }


}
