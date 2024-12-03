package main.java.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.java.interface_adapter.BookRoom.BookRoomState;
import main.java.interface_adapter.BookRoom.BookRoomViewModel;
import main.java.interface_adapter.BookRoom.BookRoomController;

public class BookRoomView extends JPanel implements ActionListener {
    private final String viewName = "Book Room";

    private final BookRoomViewModel bookroomViewModel;
    private final JTextField nameInputField = new JTextField(15);
    private final BookRoomController bookroomController;

    private final JButton bookRoom;
    private JRadioButton singleRoomButton;
    private JRadioButton doubleRoomButton;
    private JRadioButton familyRoomButton;
    private JRadioButton accessibleRoomButton;
    private ButtonGroup roomGroup;

    public BookRoomView(BookRoomController controller, BookRoomViewModel bookroomViewModel) {
        this.bookroomController = controller;
        this.bookroomViewModel = bookroomViewModel;

        final JLabel title = new JLabel(BookRoomViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(BookRoomViewModel.NAME_LABEL), nameInputField);

        singleRoomButton = new JRadioButton(BookRoomViewModel.SINGLE_ROOM_LABEL);
        doubleRoomButton = new JRadioButton(BookRoomViewModel.DOUBLE_ROOM_LABEL);
        familyRoomButton = new JRadioButton(BookRoomViewModel.FAMILY_ROOM_LABEL);
        accessibleRoomButton = new JRadioButton(BookRoomViewModel.ACCESSIBLE_ROOM_LABEL);

        roomGroup = new ButtonGroup();
        roomGroup.add(singleRoomButton);
        roomGroup.add(doubleRoomButton);
        roomGroup.add(familyRoomButton);
        roomGroup.add(accessibleRoomButton);

        JPanel singleRoomPanel = createRoomOption(  BookRoomViewModel.SINGLE_ROOM, singleRoomButton);
        JPanel doubleRoomPanel = createRoomOption(  BookRoomViewModel.DOUBLE_ROOM, doubleRoomButton);
        JPanel suiteRoomPanel = createRoomOption( BookRoomViewModel.FAMILY_ROOM, familyRoomButton);
        JPanel deluxeRoomPanel = createRoomOption(BookRoomViewModel.ACCESSIBLE_ROOM, accessibleRoomButton);

        JPanel roomSelectionPanel = new JPanel();
        roomSelectionPanel.setLayout(new GridLayout(2, 2, 10, 10));
        roomSelectionPanel.add(singleRoomPanel);
        roomSelectionPanel.add(doubleRoomPanel);
        roomSelectionPanel.add(suiteRoomPanel);
        roomSelectionPanel.add(deluxeRoomPanel);

        final JPanel buttons = new JPanel();
        bookRoom = new JButton(BookRoomViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(bookRoom);

        bookRoom.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(bookRoom)) {
                            final BookRoomState currentState = bookroomViewModel.getState();

                            bookroomController.execute(
                                    currentState.getName(),
                                    currentState.getRoomType()
                            );
                        }
                    }
                }
                );


        addNameListener();
        addRoomSelectionListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(nameInfo);
        this.add(buttons);
        this.add(roomSelectionPanel);
    }

    private void addNameListener() {
        nameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final BookRoomState currentState = bookroomViewModel.getState();
                currentState.setName(nameInputField.getText());
                bookroomViewModel.setState(currentState);
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

    private JPanel createRoomOption(String description, JRadioButton radioButton) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        radioButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(descriptionLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(radioButton);

        return panel;
    }

    // Listener for room selection
    private void addRoomSelectionListener() {
        ActionListener roomListener = e -> {
            final BookRoomState currentState = bookroomViewModel.getState();
            if (singleRoomButton.isSelected()) {
                currentState.setRoomType("single");
            } else if (doubleRoomButton.isSelected()) {
                currentState.setRoomType("double");
            } else if (familyRoomButton.isSelected()) {
                currentState.setRoomType("family");
            } else if (accessibleRoomButton.isSelected()) {
                currentState.setRoomType("accessible");
            }
            bookroomViewModel.setState(currentState);
        };

        singleRoomButton.addActionListener(roomListener);
        doubleRoomButton.addActionListener(roomListener);
        familyRoomButton.addActionListener(roomListener);
        accessibleRoomButton.addActionListener(roomListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bookroomController.switchToConfirmationView();
    }

    public String getViewName() {
        return viewName;
    }
}









