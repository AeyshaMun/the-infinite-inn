package view;

import interface_adapter.logged_in.LoggedInViewModel;
import use_case.logged_in.LoggedInInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user is logged into the program.
 */
public class MainPageView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "main page";
    private final LoggedInViewModel loggedInViewModel;
    private final LoggedInInputBoundary mainPageController;
    private final JButton bookRoom;
    private final JButton bookEvent;
    private final JButton myBooking;


    public MainPageView(LoggedInViewModel loggedInViewModel, LoggedInInputBoundary mainPageController) {
        this.loggedInViewModel = loggedInViewModel;
        this.mainPageController = mainPageController;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        final JPanel buttons = new JPanel();
        bookRoom = new JButton("Book a room");
        buttons.add(bookRoom);
        bookEvent = new JButton("Book an event hall");
        buttons.add(bookEvent);
        myBooking = new JButton("My booking");
        buttons.add(myBooking);


        bookRoom.addActionListener(
                evt -> {
                    if (evt.getSource().equals(bookRoom)) {
                        mainPageController.switchToRoomServiceView();
                    }
                }
        );

        bookEvent.addActionListener(
                evt -> {
                    if (evt.getSource().equals(bookEvent)) {
                        mainPageController.switchToAccommodationsView();
                    }
                }
        );

        myBooking.addActionListener(
                evt -> {
                    if (evt.getSource().equals(myBooking)) {
                        mainPageController.switchToAccommodationsView();
                    }
                }
        );

        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public String getViewName() {
        return viewName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}