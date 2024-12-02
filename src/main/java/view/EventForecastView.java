package main.java.view;

import main.java.interface_adapter.eventdetails.EventDetailsViewModel;
import main.java.interface_adapter.eventforecast.EventForecastController;
import main.java.interface_adapter.eventforecast.EventForecastState;
import main.java.interface_adapter.eventforecast.EventForecastViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static main.java.interface_adapter.eventforecast.EventForecastViewModel.INDOORS_BUTTON_LABEL;
import static main.java.interface_adapter.eventforecast.EventForecastViewModel.OUTDOORS_BUTTON_LABEL;

public class EventForecastView extends JPanel implements PropertyChangeListener {

    private final String viewName = "event forecast";
    private final EventForecastViewModel eventForecastViewModel;
    private final EventForecastController eventForecastController;
    private Boolean isIndoor = null;

    // Components for displaying forecast
    private final JLabel weatherForecastLabel = new JLabel();
    private final JLabel noteLabel = new JLabel();

    private final JButton indoor = new JButton(INDOORS_BUTTON_LABEL);
    private final JButton outdoor = new JButton(OUTDOORS_BUTTON_LABEL);

    private final JButton back;
    private final JButton submit;

    public EventForecastView(EventForecastViewModel eventForecastViewModel, EventForecastController eventForecastController) {
        this.eventForecastViewModel = eventForecastViewModel;
        this.eventForecastController = eventForecastController;
        this.eventForecastViewModel.addPropertyChangeListener(this);

        // Panel Setup
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel(EventDetailsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        weatherForecastLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        noteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        indoor.setAlignmentX(Component.CENTER_ALIGNMENT);
        outdoor.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to the panel
        add(weatherForecastLabel);
        add(noteLabel);
        add(indoor);
        add(outdoor);

        final JPanel buttons = new JPanel();
        back = new JButton(EventForecastViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);
        submit = new JButton(EventForecastViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(submit);

        // Hide event hall buttons initially
        indoor.setVisible(false);
        outdoor.setVisible(false);

        // Add action listeners to buttons
        indoor.addActionListener(e -> {
            isIndoor = true; // Set to true when indoor is selected
        });

        indoor.addActionListener(e -> {
            isIndoor = false; // Set to false when outdoor is selected
        });

        submit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        eventForecastController.switchToSummaryView();
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        eventForecastController.switchToHomeView();
                    }
                }
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("event forecast")) {
            EventForecastState state = eventForecastViewModel.getState();
            displayForecast(state.isOutdoorSuitable()); // Pass suitability directly
        }
    }

    public void displayForecast(Boolean isUnsuitableForOutdoor) {
        // Display the weather forecast and notes
        weatherForecastLabel.setText("Forecast: " + "Forecast data here");
        noteLabel.setText(isUnsuitableForOutdoor ? "Note: Outdoor event is unsuitable." : "");

        // Show event hall buttons based on the suitability for outdoor events
        if (isUnsuitableForOutdoor) {
            indoor.setVisible(true);
            outdoor.setVisible(false); // Hide outdoor button if unsuitable
        } else {
            indoor.setVisible(true);
            outdoor.setVisible(true); // Show both buttons if suitable
        }
    }

    public String getViewName() {
        return viewName;
    }
}
