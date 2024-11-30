package main.java.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.java.interface_adapter.BookRoom.BookRoomViewModel;
import main.java.interface_adapter.BookRoom.BookRoomController;


public class BookRoomView extends JPanel implements ActionListener {
    private final String viewName = "Book Room";

    private final BookRoomViewModel bookroomViewModel;
    private final JTextField nameInputField = new JTextField(15);
    private final BookRoomController bookroomController;
    private final JButton submitRequest;

    public BookRoomView(BookRoomController controller, BookRoomViewModel bookroomViewModel) {

        this.bookroomController = controller;
        this.bookroomViewModel = bookroomViewModel;

        final JLabel title = new JLabel(BookRoomViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel(BookRoomViewModel.NAME_LABEL), nameInputField);
        // selecting a room
//        final LabelTextPanel roomInfo = new LabelTextPanel(
//                new JLabel(BookRoomViewModel.ROOM_LABEL), passwordInputField);

        final JPanel buttons = new JPanel();
        submitRequest = new JButton(BookRoomViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(submitRequest);


//        submitRequest.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(submitRequest)) {
//                            final BookRoomViewModel currentState = bookroomViewModel.getState();
//
//                            bookroomController.execute(
//                                    currentState.getUsername(),
//                                    currentState.getPassword(),
//                                    currentState.getRepeatPassword()
//                            );
//                        }
//                    }
//                }
//        );
//
//        toLogin.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        bookroomController.switchToLoginView();
//                    }
//                }
//        );
//
//        cancel.addActionListener(this);
//
//        addUsernameListener();
//        addPasswordListener();
//        addRepeatPasswordListener();
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        this.add(title);
//        this.add(nameInfo);
//        this.add(roomInfo);
//        this.add(repeatPasswordInfo);
//        this.add(buttons);
//    }
//
//    private void addUsernameListener() {
//        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {
//
//            private void documentListenerHelper() {
//                final SignupState currentState = signupViewModel.getState();
//                currentState.setUsername(usernameInputField.getText());
//                signupViewModel.setState(currentState);
//            }
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//        });
//    }
//
//    private void addPasswordListener() {
//        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {
//
//            private void documentListenerHelper() {
//                final SignupState currentState = signupViewModel.getState();
//                currentState.setPassword(new String(passwordInputField.getPassword()));
//                signupViewModel.setState(currentState);
//            }
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//        });
//    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    public String getViewName() {
        return viewName;
    }
}








