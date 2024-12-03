package view;

import interface_adapter.accommodations.AccommodationsController;
import interface_adapter.accommodations.AccommodationsPresenter;
import interface_adapter.accommodations.AccommodationsState;
import interface_adapter.accommodations.AccommodationsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AccommodationsView extends JFrame implements ActionListener, PropertyChangeListener {
    private final String viewName = "Accommodations";
    private AccommodationsViewModel viewModel;
    private JTextField nameTextField;
    private JTextArea accommodationsTextArea;
    private JButton validateButton;
    private JButton updateButton;
    private JButton cancelButton;
    private AccommodationsController controller;
    private String name;

    public AccommodationsView(AccommodationsViewModel viewModel, AccommodationsController controller) {
        this.viewModel = viewModel;
        this.controller = controller;
        viewModel.addPropertyChangeListener(this);
        initComponents();
        layoutComponents();
        attachListeners();
    }

    private void initComponents() {
        nameTextField = new JTextField(15);
        accommodationsTextArea = new JTextArea(5, 15);
        accommodationsTextArea.setVisible(false);
        validateButton = new JButton("Validate");
        updateButton = new JButton("Update");
        updateButton.setVisible(false);
        cancelButton = new JButton("Cancel");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.add(new JLabel("Name:"));
        namePanel.add(nameTextField);
        namePanel.add(validateButton);
        add(namePanel, BorderLayout.NORTH);

        add(new JScrollPane(accommodationsTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(updateButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void attachListeners() {
        validateButton.addActionListener(this);
        updateButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    private void triggerAccommodationsUpdate() {
        String accommodations = accommodationsTextArea.getText();
        if (!accommodations.trim().isEmpty()) {
            try {
                controller.execute(name, accommodations);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error updating accommodations.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter your accommodations.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayUpdateStatus(AccommodationsState state) {
        if (state.isAccommodationsSaved()) {
            JOptionPane.showMessageDialog(this, "Accommodations updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            resetView();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update accommodations", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetView() {
        nameTextField.setText("");
        accommodationsTextArea.setText("");
        accommodationsTextArea.setVisible(false);
        updateButton.setVisible(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("accommodationsUpdate".equals(evt.getPropertyName())) {
            displayUpdateStatus((AccommodationsState) evt.getNewValue());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == validateButton) {
            name = nameTextField.getText().trim();
            if (!name.isEmpty()) {
                accommodationsTextArea.setVisible(true);
                updateButton.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a valid name.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == updateButton) {
            triggerAccommodationsUpdate();
        } else if (e.getSource() == cancelButton) {
            resetView();
        }
    }

    public String getViewName() {
        return viewName;
    }
}