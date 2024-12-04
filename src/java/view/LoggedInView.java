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
public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final LoggedInInputBoundary loggedInController;
    private final JButton roomService;
    private final JButton accommodations;
    private final JButton checkout;


    public LoggedInView(LoggedInViewModel loggedInViewModel, LoggedInInputBoundary loggedInController) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInController = loggedInController;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        final JPanel buttons = new JPanel();
        roomService = new JButton("Room Service");
        buttons.add(roomService);
        accommodations = new JButton("Accommodations");
        buttons.add(accommodations);
        checkout = new JButton("Check Out");
        buttons.add(checkout);


        roomService.addActionListener(
                evt -> {
                    if (evt.getSource().equals(roomService)) {
                        loggedInController.switchToRoomServiceView();
                    }
                }
        );

        accommodations.addActionListener(
                evt -> {
                    if (evt.getSource().equals(accommodations)) {
                        loggedInController.switchToAccommodationsView();
                    }
                }
        );

        checkout.addActionListener(
                evt -> {
                    if (evt.getSource().equals(checkout)) {
                        loggedInController.switchToCheckOutView();
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