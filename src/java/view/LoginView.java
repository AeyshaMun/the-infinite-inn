package view;

import java.interface_adapter.login.LoginController;
import java.interface_adapter.login.LoginState;
import java.interface_adapter.login.LoginViewModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user is logging into the program.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    private final JTextField nameInputField = new JTextField(15);
    private final JLabel errorField = new JLabel();

    private final JTextField roomNumberInputField = new JTextField(15);

    private final JButton logIn;
    private final JButton back;
    private final LoginController loginController;

    public LoginView(LoginViewModel loginViewModel, LoginController controller) {

        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Login to booking");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Last Name"), nameInputField);
        final LabelTextPanel roomInfo = new LabelTextPanel(
                new JLabel("Room Number"), roomNumberInputField);

        final JPanel buttons = new JPanel();
        logIn = new JButton("log in");
        buttons.add(logIn);
        back = new JButton("back");
        buttons.add(back);

        logIn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            loginController.execute(
                                    nameInputField.getText(),
                                    Integer.parseInt(roomNumberInputField.getText())
                            );
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
                            loginController.switchToMainView();
                        }
                    }
                }
        );

        nameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setName(nameInputField.getText());
                loginViewModel.setState(currentState);
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        roomNumberInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setRoomNumber(Integer.parseInt(roomNumberInputField.getText()));
                loginViewModel.setState(currentState);
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

        this.add(title);
        this.add(nameInputField);
        this.add(errorField);
        this.add(roomNumberInputField);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final LoginState state = (LoginState) evt.getNewValue();
        errorField.setText(state.getLoginError());
    }

    public String getViewName() {
        return viewName;
    }
}
