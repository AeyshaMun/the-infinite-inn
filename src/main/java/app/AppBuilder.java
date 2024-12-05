package app;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

// Import data access objects and factories
import data_access.DBPersonDataAccessObject;

import entity.*;

// Import necessary view classes
import interface_adapter.Confirmation.ConfirmationViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.main_page.MainPageInputBoundary;
import use_case.main_page.MainPageInteractor;
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
import view.ViewManager;

// Import view models
import interface_adapter.ViewManagerModel;
import interface_adapter.accommodations.*;
import interface_adapter.BookRoom.*;
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
import use_case.*;


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
    private DBPersonDataAccessObject personDataAccessObject;

    // Factories
    private PersonFactory guestFactory;
    private ClientFactoryInterface clientFactory;
    private RoomFactory roomFactory;
    private EventHallFactoryInterface eventhallFactory;
    private SuiteFactoryInterface suiteRoomFactory;
    private EventBookingFactory eventBookingFactory;


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

    // View Models
    private AccommodationsViewModel accommodationsViewModel;
    private BookRoomViewModel bookRoomViewModel;
    private ConfirmationViewModel ConfirmationViewModel;
    private CheckoutViewModel checkoutViewModel;
    private EventDetailsViewModel eventDetailsViewModel;
    private EventForecastViewModel eventForecastViewModel;
    private EventSummaryViewModel eventSummaryViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoginViewModel loginViewModel;
    private MainPageViewModel mainPageViewModel;
    private PlaceOrderViewModel placeOrderViewModel;
    private ReceiptViewModel receiptViewModel;

    // Controllers
    private LoginController loginController;
    private MainPageController mainPageController;

    /**
     * Constructor with dependency injection for factories and data access
     */
    public AppBuilder() {
        // Initialize core UI components
        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        this.viewManagerModel = new ViewManagerModel();
        this.viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

        // Initialize dependencies
        initializeDependencies();
    }

    public void initializeDependencies() {
        // Initialize with default implementations
        this.personDataAccessObject = new DBPersonDataAccessObject();
        this.guestFactory = new GuestFactory();
        this.clientFactory = new ClientFactory();
        this.roomFactory = new SuiteRoomFactory();
        this.eventhallFactory = new EventHallFactory();
        this.suiteRoomFactory = new SuiteRoomFactory();
        this.eventBookingFactory = new EventBookingFactory();
    }

    /**
     * Initializes views and view models
     * @return this builder for method chaining
     */
    public AppBuilder initializeViews() {
        // Initialize view models
        loginViewModel = new LoginViewModel();
        mainPageViewModel = new MainPageViewModel();
        // Create use case interactors
        LoginInputBoundary loginInteractor = new LoginInteractor(
                personDataAccessObject,
                guestFactory
        );
        MainPageInputBoundary mainPageInteractor = new MainPageInteractor();

        // Create controllers
        loginController = new LoginController(loginInteractor);
        mainPageController = new MainPageController(mainPageInteractor);

        // Initialize views
        loginView = new LoginView(loginViewModel, loginController);
        mainPageView = new MainPageView(mainPageViewModel, mainPageController);

        // Add more view initializations as needed
        accommodationsViewModel = new AccommodationsViewModel();
        bookRoomViewModel = new BookRoomViewModel();
        confirmationViewModel = new ConfirmationViewModel();

        // Initialize additional views
        accommodationsView = new AccommodationsView(accommodationsViewModel);
        bookRoomView = new BookRoomView(bookRoomViewModel);
        bookRoomConfirmView = new BookRoomConfirmView(confirmationViewModel);
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