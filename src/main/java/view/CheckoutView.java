package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import interface_adapter.checkout.*;

public class CheckoutView extends JPanel implements ActionListener, PropertyChangeListener {

    private CheckoutViewModel viewModel;

    // UI Components
    private JButton checkoutButton;
    private JButton backButton;
    private JLabel messageLabel;

    // Constructor for CheckoutView
    public CheckoutView(CheckoutViewModel viewModel) {
        this.viewModel = viewModel;

        // Initialize UI components
        checkoutButton = new JButton("Checkout");
        backButton = new JButton("Back to Main Page");
        messageLabel = new JLabel("");

        // Set layout for the panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add the components to the panel
        add(checkoutButton);
        add(Box.createRigidArea(new Dimension(0, 10))); // Spacer between buttons
        add(backButton);
        add(Box.createRigidArea(new Dimension(0, 10))); // Spacer between buttons
        add(messageLabel);

        // Set up listeners for buttons
        checkoutButton.addActionListener(this);
        backButton.addActionListener(this);

        // Listen for property changes (state updates from ViewModel)
        viewModel.addPropertyChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions
        if (e.getSource() == checkoutButton) {
            // Execute the checkout process when the checkout button is clicked
            viewModel.executeCheckout();
        } else if (e.getSource() == backButton) {
            // Return to the main page when the back button is clicked
            navigateToMainPage();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle state changes and update UI accordingly
        if ("state".equals(evt.getPropertyName())) {
            CheckoutState state = (CheckoutState) evt.getNewValue();
            updateMessageLabel(state);
        }
    }

    // Method to update the message label based on the state
    private void updateMessageLabel(CheckoutState state) {
        if (state.isSuccess()) {
            messageLabel.setText("Checkout Successfully!");
            messageLabel.setForeground(Color.GREEN);
        } else {
            messageLabel.setText("Error, try again.");
            messageLabel.setForeground(Color.RED);
        }
    }

    // This method will navigate to the main page (for example, clearing the panel or switching view)
    private void navigateToMainPage() {
        // For now, we just print out a message, in a real application you would swap views
        System.out.println("Returning to the main page...");
        // Optionally reset the state if necessary
    }

    // Optionally, you can provide a method to reset the view if needed
    public void resetView() {
        messageLabel.setText("");
    }
}

