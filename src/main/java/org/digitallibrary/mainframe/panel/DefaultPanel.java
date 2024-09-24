package org.digitallibrary.mainframe.panel;

import org.digitallibrary.api.GeneralSearchRequest;
import org.digitallibrary.helper.MessageWindow;
import org.digitallibrary.helper.UIPersonalization;
import lombok.RequiredArgsConstructor;
import org.digitallibrary.mainframe.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DefaultPanel extends BasePanel {
    private JTextField usernameField;
    private JPasswordField passwordField;

    @Autowired
    GeneralSearchRequest generalSearchRequest;

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

        //passwordField = new JPasswordField("passwordD123#");
        passwordField = new JPasswordField("TestTest2222#");
        uiPersonalization.setJPasswordField(passwordField, 28);
        passwordField.setBounds(240, 415, 300, 50);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!Arrays.toString(passwordField.getPassword()).isEmpty()) {
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
        String username = usernameField.getText().trim();
        char[] password = passwordField.getPassword();

        if (username.isEmpty() || password.length == 0) {
            MessageWindow.popUpErrorMessage("Username and password cannot be empty.");
            return;
        }
        String passwordStr = new String(password);

        boolean isLogged = frame.mainDataProvider.loginUser(username, passwordStr);

        java.util.Arrays.fill(password, '\0');

        if (isLogged) {
            String userEmail = frame.mainDataProvider.getUserEmail(username);

            generalSearchRequest.setUserEmail(userEmail);

            resetLoginFields();
            frame.mainCoordinator.moveToHomePanel();
        } else {
            MessageWindow.popUpErrorMessage("Wrong username or password.");
        }
    }

    private void resetLoginFields() {
        usernameField.setText("Username...");
        passwordField.setText("");
    }
}
