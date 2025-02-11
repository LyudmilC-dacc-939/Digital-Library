package org.digitallibrary.mainframe.panel;

import org.digitallibrary.helper.MessageWindow;
import org.digitallibrary.helper.UIPersonalization;
import lombok.RequiredArgsConstructor;
import org.digitallibrary.mainframe.MainFrame;
import org.digitallibrary.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DefaultPanel extends BasePanel {
    private JTextField usernameField;
    private JPasswordField passwordField;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    public DefaultPanel(final MainFrame frame) {
        super(frame);
        UIPersonalization uiPersonalization = new UIPersonalization();
        JLabel titleLabel = new JLabel("The Digital Book Archive");
        uiPersonalization.setJLabel(titleLabel);
        titleLabel.setBounds(180, 140, 800, 80);
        add(titleLabel);

        usernameField = new JTextField("Username...");
        uiPersonalization.setJTextField(usernameField, 24);
        usernameField.setBounds(240, 360, 300, 50);
        usernameField.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (usernameField.getText().equals("Username...")) {
                    usernameField.setText("");
                }
            }
        });
        add(usernameField);

        passwordField = new JPasswordField("passwordD123#");
        uiPersonalization.setJPasswordField(passwordField, 28);
        passwordField.setBounds(240, 415, 300, 50);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (passwordField.getPassword().length > 0) {
                    passwordField.setText("");
                }
            }
        });
        add(passwordField);

        JButton loginButton = new JButton("Log In");
        uiPersonalization.setJButton(loginButton, 25);
        loginButton.setBounds(240, 475, 300, 55);
        loginButton.addActionListener(e -> loginAction());
        add(loginButton);

        JButton registerButton = new JButton("I Don't Have An Account");
        uiPersonalization.setJButton(registerButton, 25);
        registerButton.setBounds(240, 600, 300, 55);
        registerButton.addActionListener(e -> frame.mainCoordinator.moveToRegistrationPanel());
        add(registerButton);
    }

    private void loginAction() {
        String username = usernameField.getText().trim();
        char[] password = passwordField.getPassword();
        String passwordStr = new String(password);

        if (username.isEmpty() || passwordStr.isEmpty()) {
            MessageWindow.popUpErrorMessage("Username and password cannot be empty.");
            return;
        }

        try {
            String jwtToken = jwtService.authenticate(username, passwordStr);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            jwtToken,
                            userDetails.getAuthorities()
                    )
            );

            frame.mainCoordinator.moveToHomePanel();
        } catch (AuthenticationException e) {
            MessageWindow.popUpErrorMessage("Invalid username or password.");
        } finally {
            Arrays.fill(password, '\0');
            resetLoginFields();
        }
    }

    private void resetLoginFields() {
        usernameField.setText("Username...");
        passwordField.setText("");
    }
}
