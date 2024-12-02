package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.DBGuestDataAccessObject;
import entity.PersonFactory;
import entity.RoomFactory;
import view.ViewManager;

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
    private final DBGuestDataAccessObject userDataAccessObject= new DBGuestDataAccessObject();
    //entity
    private final PersonFactory personFactory = new GuestFactory();
    private final PersonFactory personFactory = new ClientFactory();
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

}

