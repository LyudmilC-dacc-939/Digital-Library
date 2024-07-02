package mainframe.panel;

import helper.MessageWindow;
import helper.UIPersonalization;
import mainframe.MainFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultPanel extends BasePanel {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public DefaultPanel(final MainFrame frame) {
        super(frame);
        UIPersonalization uiPersonalization = new UIPersonalization();
        JLabel titleLabel = new JLabel("The Digital Book Archive");
        uiPersonalization.setJLabel(titleLabel);
        titleLabel.setBounds(180, 140, 800, 80);
        add(titleLabel);


        //usernameField = new JTextField("Username...");
        usernameField = new JTextField("Test.John.Doe24");
        uiPersonalization.setJTextField(usernameField, 24);
        usernameField.setBounds(240, 360, 300, 50);
        usernameField.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (usernameField.getText().equals("Username...")) {
                    usernameField.setText("");
                }

            }
        });
        add(usernameField);

        //passwordField = new JPasswordField("passworD123#");
        passwordField = new JPasswordField("TestTest2222#");
        uiPersonalization.setJPasswordField(passwordField, 28);
        passwordField.setBounds(240, 415, 300, 50);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!passwordField.getPassword().toString().isEmpty()) {
                    passwordField.setText("");
                }
            }
        });
        add(passwordField);

        JButton loginButton = new JButton("Log In");
        uiPersonalization.setJButton(loginButton, 25);
        loginButton.setBounds(240, 475, 300, 55);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction();
            }
        });
        add(loginButton);

        JButton registerButton = new JButton("I Don't Have An Account");
        uiPersonalization.setJButton(registerButton, 25);
        registerButton.setBounds(240, 600, 300, 55);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mainCoordinator.moveToRegistrationPanel();
            }
        });
        add(registerButton);
    }

    private void loginAction() {
        boolean isLogged = frame.mainDataProvider.loginUser(usernameField.getText(), passwordField.getText());
        if (isLogged) {
            //The bottom two rows will guarantee that if the user decides to go back to the DefaultPanel,
            //the username and password will be set as follows
            usernameField.setText("Username...");
            passwordField.setText("");
            frame.mainCoordinator.moveToHomePanel();
        } else {
            MessageWindow.popUpErrorMessage("Wrong username or password");
        }
    }


}
