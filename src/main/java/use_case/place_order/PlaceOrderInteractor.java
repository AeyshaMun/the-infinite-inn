package use_case.place_order;


/**
 * The placeOrder Interactor.
 */

public class PlaceOrderInteractor implements PlaceOrderInputBoundary {
    private final PlaceOrderDataAccessInterface guestData;
    private final PlaceOrderOutputBoundary placeOrderPresenter;

    public PlaceOrderInteractor(PlaceOrderDataAccessInterface placeOrderDataAccessInterface,
                                PlaceOrderOutputBoundary placeOrderOutputBoundary) {
        this.guestData = placeOrderDataAccessInterface;
        this.placeOrderPresenter = placeOrderOutputBoundary;
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
