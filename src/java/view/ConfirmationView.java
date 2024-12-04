package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.interface_adapter.Confirmation.ConfirmationState;
import java.interface_adapter.Confirmation.ConfirmationViewModel;

/**
 * The View for when the user has booked a room.
 */
public class ConfirmationView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Confirmation";
    private final ConfirmationViewModel confirmationViewModel;
    private final ConfirmationState confirmationState;

    private final JButton exit;

    public ConfirmationView(ConfirmationViewModel confirmationViewModel, ConfirmationState confirmationState) {
        this.confirmationViewModel = confirmationViewModel;
        this.confirmationState = confirmationState;

        final JLabel title = new JLabel(confirmationViewModel.MESSAGE);

        JTextPane confirmation = new JTextPane();
        confirmation.setText(confirmationState.toString());

        final JPanel buttons = new JPanel();
        exit = new JButton(ConfirmationViewModel.BUTTON_LABEL);

        exit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(confirmationState)) {
                            final ConfirmationState currentState = confirmationViewModel.getState();
                        }
                    }
                }
        );
    }

    public String getViewName() {
        return viewName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
