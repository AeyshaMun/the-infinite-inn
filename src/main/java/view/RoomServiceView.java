package view;

import interface_adapter.placeOrder.PlaceOrderController;
import interface_adapter.placeOrder.PlaceOrderState;
import interface_adapter.placeOrder.PlaceOrderViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for the PlaceOrder Use Case.
 */
public class RoomServiceView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "order";

    private final PlaceOrderViewModel placeOrderViewModel;
    private final JTextField itemOneQuantityInputField = new JTextField(2);
    private final JTextField itemTwoQuantityInputField = new JTextField(2);
    private final JTextField itemThreeQuantityInputField = new JTextField(2);
    private final JTextField roomNumberInputField = new JTextField(2);
    private final PlaceOrderController placeOrderController;

    private final JButton backButton;
    private final JButton placeOrderButton;

    public RoomServiceView(PlaceOrderController controller, PlaceOrderViewModel placeOrderViewModel) {

        this.placeOrderController = controller;
        this.placeOrderViewModel = placeOrderViewModel;
        placeOrderViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(PlaceOrderViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel item1Quantity = new LabelTextPanel(
                new JLabel(PlaceOrderViewModel.ITEM1_LABEL), itemOneQuantityInputField);
        final LabelTextPanel item2Quantity = new LabelTextPanel(
                new JLabel(PlaceOrderViewModel.ITEM2_LABEL), itemTwoQuantityInputField);
        final LabelTextPanel item3Quantity = new LabelTextPanel(
                new JLabel(PlaceOrderViewModel.ITEM3_LABEL), itemThreeQuantityInputField);
        final LabelTextPanel roomNumberInfo = new LabelTextPanel(
                new JLabel(PlaceOrderViewModel.ROOM_LABEL), roomNumberInputField);

        final JPanel buttons = new JPanel();
        placeOrderButton = new JButton(PlaceOrderViewModel.PLACE_BUTTON_LABEL);
        buttons.add(placeOrderButton);
        backButton = new JButton(PlaceOrderViewModel.BACK_BUTTON_LABEL);
        buttons.add(backButton);

        placeOrderButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(placeOrderButton)) {
                            final PlaceOrderState currentState = RoomServiceView.this.placeOrderViewModel.getState();

                            placeOrderController.execute(
                                    itemOneQuantityInputField.getText(),
                                    itemTwoQuantityInputField.getText(),
                                    itemThreeQuantityInputField.getText(),
                                    roomNumberInputField.getText());
                        }
                    }
                }
        );

        backButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        placeOrderController.switchToLoggedInView();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(item1Quantity);
        this.add(item2Quantity);
        this.add(item3Quantity);
        this.add(roomNumberInfo);
        this.add(buttons);
    }

    private void addItemOneListener() {
        itemOneQuantityInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final PlaceOrderState currentState = placeOrderViewModel.getState();
                currentState.setItem1(Integer.parseInt(itemOneQuantityInputField.getText()));
                placeOrderViewModel.setState(currentState);
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

    private void addItemTwoListener() {
        itemTwoQuantityInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final PlaceOrderState currentState = placeOrderViewModel.getState();
                currentState.setItem2(Integer.parseInt(itemTwoQuantityInputField.getText()));
                placeOrderViewModel.setState(currentState);
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

    private void addItemThreeListener() {
        itemThreeQuantityInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final PlaceOrderState currentState = placeOrderViewModel.getState();
                currentState.setItem3(Integer.parseInt(itemThreeQuantityInputField.getText()));
                placeOrderViewModel.setState(currentState);
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

    private void addRoomNumberListener() {
        roomNumberInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final PlaceOrderState currentState = placeOrderViewModel.getState();
                currentState.setRoomNumber(Integer.parseInt(roomNumberInputField.getText()));
                placeOrderViewModel.setState(currentState);
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
        final PlaceOrderState state = (PlaceOrderState) evt.getNewValue();
        if (state.getOrderError() != null) {
            JOptionPane.showMessageDialog(this, state.getOrderError());
        }
    }

    public String getViewName() {return viewName;}

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
