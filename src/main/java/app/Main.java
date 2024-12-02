package app;

import javax.swing.JFrame;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                //View
                .addMainPageView()
                .addBookEventView()
                .addBookRoomView()
                .addLoginView()

                .addLoggedInView()

                .addAccommodationsView()
                .addRoomServiceView()
                .addReceiptView()
                .addCheckoutView()

                //UseCase
                .addMainPageUseCase()
                .addBookEventUseCase()
                .addBookRoomUseCase()
                .addLoginUseCase()

                .addLoggedInUseCase()

                .addBookRoomUseCase()
                .addAccommodationUseCase()
                .addPlaceOrderUseCase()
                .addCheckoutUseCase()
                .build();

        application.pack();
        application.setVisible(true);
    }
}
