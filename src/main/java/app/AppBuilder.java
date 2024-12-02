package app;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.DBPersonDataAccessObject;
import entity.PersonFactory;
import entity.RoomFactory;
import entity.SuiteFactory;
import entity.ClientFactory;
import entity.EventHallFactory;
import entity.EventBookingFactory;
import entity.GuestFactory;

import interface_adapter.*;
import interface_adapter.BookRoom.BookRoomViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import use_case.*;
import view.*;


/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */


public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    //DAO
    private final DBPersonDataAccessObject userDataAccessObject= new DBPersonDataAccessObject();
    //entity
    private final PersonFactory guestFactory = new GuestFactory();
    private final PersonFactory clientFactory = new ClientFactory();
    private final RoomFactory roomFactory = new EventHallFactory();
    //Manager Model
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private BookRoomView bookRoomView;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }
    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public AppBuilder addBookRoomView() {
        bookRoomViewModel = new BookRoomViewModel();
        bookRoomView = new BookRoomView(bookRoomViewModel);
        cardPanel.add(bookRoomView, bookRoomView.getViewName());
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */

    public AppBuilder addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    public AppBuilder addMainPageView(){
        mainPageViewModel = new MainPageViewModel();
        mainPageView = new MainPageView(mainPageViewModel);

    }
    public AppBuilder addBookEventView(){}
    public AppBuilder addAccommodationsView(){}
    public AppBuilder addRoomServiceView(){}
    public AppBuilder addReceiptView(){}
    public AppBuilder addCheckoutView(){}

    public AppBuilder addMainPageUseCase(){}
    public AppBuilder addBookEventUseCase(){}
    public AppBuilder addBookRoomUseCase(){}
    public AppBuilder addLoginUseCase(){}
    public AppBuilder addLoggedInUseCase(){}
    public AppBuilder addEventDetailUseCase(){}
    public AppBuilder addEventForecast(){}
    public AppBuilder addEventSummary(){}
    public AppBuilder addAccommodationUseCase(){}
    public AppBuilder addPlaceOrderUseCase(){}
    public AppBuilder addCheckoutUseCase(){}
    public JFrame build() {
        final JFrame application = new JFrame("Infinite Inn");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(MainPageView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }


}
