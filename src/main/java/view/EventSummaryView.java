package main.java.view;

import main.java.interface_adapter.eventsummary.EventSummaryController;
import main.java.interface_adapter.eventsummary.EventSummaryState;
import main.java.interface_adapter.eventsummary.EventSummaryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static main.java.interface_adapter.eventsummary.EventSummaryViewModel.BACK_BUTTON_LABEL;

public class EventSummaryView extends JPanel implements PropertyChangeListener {

    private final String viewName = "event summary";
    private final EventSummaryViewModel eventSummaryViewModel;
    private final EventSummaryController eventSummaryController;

    // Text area for displaying summary
    private final JTextArea summaryTextArea = new JTextArea();
    private final JButton back = new JButton(BACK_BUTTON_LABEL);

    public EventSummaryView(EventSummaryViewModel eventSummaryViewModel, EventSummaryController eventSummaryController) {
        this.eventSummaryViewModel = eventSummaryViewModel;
        this.eventSummaryController = eventSummaryController;

        // Panel Setup
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Set up the text area (no border, no editable)
        summaryTextArea.setEditable(false);
        summaryTextArea.setLineWrap(true);
        summaryTextArea.setWrapStyleWord(true);
        summaryTextArea.setOpaque(false); // Transparent background
        summaryTextArea.setFont(new Font("Arial", Font.PLAIN, 15));

        // Back button setup
        back.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to the panel
        add(summaryTextArea);
        add(Box.createVerticalStrut(10)); // Spacer
        add(back);

        // Back button action listener
        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        eventSummaryController.switchToHomeView();
                    }
                }
        );    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            // Get the updated state from the ViewModel
            EventSummaryState state = eventSummaryViewModel.getState();
            // Update the text area with the new summary text
            summaryTextArea.setText(state.getSummaryText());
        }
    }

    public String getViewName() {
        return viewName;
    }
}