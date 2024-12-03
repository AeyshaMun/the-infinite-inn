package app;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

// Import data access objects and factories
import data_access.DBPersonDataAccessObject;

import entity.*;

// Import necessary view classes
import view.AccommodationsView;
import view.BookRoomConfirmView;
import view.BookRoomView;
import view.CheckoutView;
import view.EventDetailsView;
import view.EventForecastView;
import view.EventSummaryView;
import view.LoggedInView;
import view.LoginView;
import view.MainPageView;
import view.ReceiptView;
import view.RoomServiceView;
import view.ViewManager;

// Import view models
import interface_adapter.ViewManagerModel;
import interface_adapter.accommodations.*;
import interface_adapter.BookRoom.*;
import interface_adapter.BookRoomConfirm.*;
import interface_adapter.checkout.*;
import interface_adapter.eventdetails.*;
import interface_adapter.eventforecast.*;
import interface_adapter.eventsummary.*;
import interface_adapter.logged_in.*;
import interface_adapter.login.*;
import interface_adapter.main_page.*;
import interface_adapter.receipt.*;
import interface_adapter.placeOrder.*;


// Import use case input boundaries
import use_case.accommodations.*;
import use_case.BookRoom.*;
import use_case.checkout.*;
import use_case.eventdetails.*;
import use_case.eventforecast.*;
import use_case.eventsummary.*;
import use_case.logged_in.*;
import use_case.login.*;
import use_case.main_page.*;
import use_case.place_order.*;

/**
 * AppBuilder for constructing the application using Clean Architecture principles.
 * Responsible for wiring up views, view models, controllers, and use cases.
 */
/**
 * AppBuilder for constructing the application using Clean Architecture principles.
 * Responsible for wiring up views, view models, controllers, and use cases.
 */
public class AppBuilder {
    // Core application components
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // Data access object
    private DBPersonDataAccessObject personDataAccessObject = new DBPersonDataAccessObject();

    // Factories
    private PersonFactory guestFactory = new GuestFactory();
    private ClientFactoryInterface clientFactory = new ClientFactory();
    private RoomFactory roomFactory = new SuiteRoomFactory();
    private EventHallFactoryInterface eventhallFactory= new EventHallFactory();
    private SuiteFactoryInterface suiteRoomFactory = new SuiteRoomFactory();
    private EventBookingFactory eventBookingFactory =  new EventBookingFactory();


    // Views
    private AccommodationsView accommodationsView;
    private BookRoomConfirmView bookRoomConfirmView;
    private BookRoomView bookRoomView;
    private CheckoutView checkoutView;
    private EventDetailsView eventDetailsView;
    private EventForecastView eventForecastView;
    private EventSummaryView eventSummaryView;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private MainPageView mainPageView;
    private ReceiptView receiptView;
    private RoomServiceView roomServiceView;

    // View Models
    private AccommodationsViewModel accommodationsViewModel;
    private BookRoomViewModel bookRoomViewModel;
    private BookRoomConfirmViewModel bookRoomConfirmViewModel;
    private CheckoutViewModel checkoutViewModel;
    private EventDetailsViewModel eventDetailsViewModel;
    private EventForecastViewModel eventForecastViewModel;
    private EventSummaryViewModel eventSummaryViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoginViewModel loginViewModel;
    private MainPageViewModel mainPageViewModel;
    private PlaceOrderViewModel placeOrderViewModel;
    private ReceiptViewModel receiptViewModel;

    /**
     * Constructor with dependency injection for factories and data access
     */
    public AppBuilder() {
        // Initialize with default implementations
        this.personDataAccessObject = new DBPersonDataAccessObject();
        this.guestFactory = new GuestFactory();
        this.clientFactory = new ClientFactory();
        this.roomFactory = new SuiteRoomFactory();
        this.eventhallFactory = new EventHallFactory();
        this.suiteRoomFactory = new SuiteRoomFactory();
        this.eventBookingFactory = new EventBookingFactory();

        // Set up card layout
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Alternative constructor allowing custom dependency injection
     */
    public AppBuilder(
            DBPersonDataAccessObject personDataAccessObject,
            PersonFactory guestFactory,
            ClientFactoryInterface clientFactory,
            RoomFactory roomFactory,
            EventHallFactoryInterface eventHallFactory,
            SuiteFactoryInterface suiteRoomFactory,
            EventBookingFactory eventBookingFactory
    ) {
        this.personDataAccessObject = personDataAccessObject;
        this.guestFactory = guestFactory;
        this.clientFactory = clientFactory;
        this.roomFactory = roomFactory;
        this.eventhallFactory = eventHallFactory;
        this.suiteRoomFactory = suiteRoomFactory;
        this.eventBookingFactory = eventBookingFactory;

        // Set up card layout
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Initializes views and view models
     * @return this builder for method chaining
     */
    public AppBuilder initializeViews() {
        // Initialize view models
        loginViewModel = new LoginViewModel();
        mainPageViewModel = new MainPageViewModel();
        accommodationsViewModel = new AccommodationsViewModel();
        bookRoomViewModel = new BookRoomViewModel();
        bookRoomConfirmViewModel = new BookRoomConfirmViewModel();

        // Initialize views
        loginView = new LoginView(loginViewModel);
        mainPageView = new MainPageView(mainPageViewModel);
        accommodationsView = new AccommodationsView(accommodationsViewModel);
        bookRoomView = new BookRoomView(bookRoomViewModel);
        bookRoomConfirmView = new BookRoomConfirmView(bookRoomConfirmViewModel);

        // Add views to card panel
        cardPanel.add(loginView, loginView.getViewName());
        cardPanel.add(mainPageView, mainPageView.getViewName());
        cardPanel.add(accommodationsView, accommodationsView.getViewName());
        cardPanel.add(bookRoomView, bookRoomView.getViewName());
        cardPanel.add(bookRoomConfirmView, bookRoomConfirmView.getViewName());

        return this;
    }

    /**
     * Builds and returns the application frame
     * @return constructed JFrame
     */
    public JFrame build() {
        JFrame application = new JFrame("Infinite Inn");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        // Set initial view
        viewManagerModel.setState(loginView.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setLocationRelativeTo(null);

        return application;
    }

    /**
     * Provides access to the card panel
     * @return JPanel containing all views
     */
    public JPanel getCardPanel() {
        return cardPanel;
    }

    /**
     * Provides access to the view manager model
     * @return ViewManagerModel
     */
    public ViewManagerModel getViewManagerModel() {
        return viewManagerModel;
    }
}