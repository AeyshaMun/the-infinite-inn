package view;

import interface_adapter.eventdetails.EventDetailsController;
import interface_adapter.eventdetails.EventDetailsState;
import interface_adapter.eventdetails.EventDetailsViewModel;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for the Event Details Use Case.
 */
public class EventDetailsView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "event details";

    private final EventDetailsViewModel eventDetailsViewModel;
    private final JTextField nameInputField = new JTextField(15);
    private final JTextField eventDateInputField = new JTextField(15);
    private final JTextField partySizeInputField = new JTextField(15);
    private EventDetailsController eventDetailsController;

    private final JButton back;
    private final JButton next;

    public EventDetailsView(EventDetailsViewModel eventDetailsViewModel) {
        this.eventDetailsViewModel = eventDetailsViewModel;
        eventDetailsViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(EventDetailsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(EventDetailsViewModel.NAME_LABEL), nameInputField);
        final LabelTextPanel eventDateInfo = new LabelTextPanel(
                new JLabel(EventDetailsViewModel.EVENT_DATE_LABEL), eventDateInputField);
        final LabelTextPanel partySizeInfo = new LabelTextPanel(
                new JLabel(EventDetailsViewModel.PARTY_SIZE_LABEL), partySizeInputField);

        final JPanel buttons = new JPanel();
        back = new JButton(EventDetailsViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);
        next = new JButton(EventDetailsViewModel.NEXT_BUTTON_LABEL);
        buttons.add(next);

        next.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        eventDetailsController.switchToEventForecastView();
                    }
            }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        eventDetailsController.switchToHomeView();
                    }
                }
        );

        addNameListener();
        addEventDateListener();
        addPartySizeListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(nameInfo);
        this.add(eventDateInfo);
        this.add(partySizeInfo);
        this.add(buttons);
    }

    private void addNameListener() {
        nameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final EventDetailsState currentState = eventDetailsViewModel.getState();
                currentState.setName(nameInputField.getText());
                eventDetailsViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addEventDateListener() {
        eventDateInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final EventDetailsState currentState = eventDetailsViewModel.getState();
                currentState.setEventDate(new String(eventDateInputField.getPassword()));
                eventDetailsViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addPartySizeListener() {
        partySizeInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final EventDetailsState currentState = eventDetailsViewModel.getState();
                currentState.setPartySize(new String(partySizeInputField.getPassword())); // i'll fix this one sec!!
                eventDetailsViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final EventDetailsState state = (EventDetailsState) evt.getNewValue();
        if (state.getNameError() != null) {
            JOptionPane.showMessageDialog(this, state.getNameError());
        }
        if (state.getEventDateError() != null) {
            JOptionPane.showMessageDialog(this, state.getEventDateError());
        }
        if (state.getPartySizeError() != null) {
            JOptionPane.showMessageDialog(this, state.getPartySizeError());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setEventDetailsController(EventDetailsController controller) {
        this.eventDetailsController = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}