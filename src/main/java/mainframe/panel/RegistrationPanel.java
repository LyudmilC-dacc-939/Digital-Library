package mainframe.panel;

import helper.UIPersonalization;
import helper.Validation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mainframe.MainFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
@RequiredArgsConstructor
public class RegistrationPanel extends BasePanel {
    private JLabel usernameJLabel;
    private JTextField usernameTextField;
    private JLabel firstNameJLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameJLabel;
    private JTextField lastNameTextField;
    private JLabel passwordJLabel;
    private JPasswordField passwordTextField;
    private JLabel repeatPasswordJLabel;
    private JPasswordField repeatPasswordTextField;
    private JLabel emailAddressJLabel;
    private JTextField emailAddressTextField;
    private JButton registerButton;
    private JButton backButton;
    private JLabel validationErrorMessageLabel;
    private JLabel validationErrorMessageLabel2;
    private JLabel validationErrorMessageLabel3;
    private final UIPersonalization uiPersonalization = new UIPersonalization();

    public RegistrationPanel(MainFrame frame) {
        super(frame);

        usernameJLabel = new JLabel("Username: ");
        uiPersonalization.setJLabel(usernameJLabel, 20);
        usernameJLabel.setBounds(180, 70, 160, 50);
        add(usernameJLabel);

        usernameTextField = new JTextField("");
        uiPersonalization.setJTextField(usernameTextField, 24);
        usernameTextField.setBounds(300, 70, 300, 50);
        add(usernameTextField);

        firstNameJLabel = new JLabel("First Name: ");
        uiPersonalization.setJLabel(firstNameJLabel, 20);
        firstNameJLabel.setBounds(175, 130, 120, 50);
        add(firstNameJLabel);

        firstNameTextField = new JTextField("");
        uiPersonalization.setJTextField(firstNameTextField, 24);
        firstNameTextField.setBounds(300, 130, 300, 50);
        add(firstNameTextField);

        lastNameJLabel = new JLabel("Last Name: ");
        uiPersonalization.setJLabel(lastNameJLabel, 20);
        lastNameJLabel.setBounds(180, 190, 120, 50);
        add(lastNameJLabel);

        lastNameTextField = new JTextField("");
        uiPersonalization.setJTextField(lastNameTextField, 24);
        lastNameTextField.setBounds(300, 190, 300, 50);
        add(lastNameTextField);


        passwordJLabel = new JLabel("Password: ");
        uiPersonalization.setJLabel(passwordJLabel, 20);
        passwordJLabel.setBounds(185, 250, 115, 50);
        add(passwordJLabel);

        repeatPasswordJLabel = new JLabel("Repeat Password: ");
        uiPersonalization.setJLabel(repeatPasswordJLabel, 20);
        repeatPasswordJLabel.setBounds(115, 310, 200, 50);
        add(repeatPasswordJLabel);

        emailAddressJLabel = new JLabel("E-Mail Address: ");
        uiPersonalization.setJLabel(emailAddressJLabel, 20);
        emailAddressJLabel.setBounds(140, 370, 180, 50);
        add(emailAddressJLabel);

        passwordTextField = new JPasswordField("");
        uiPersonalization.setJPasswordField(passwordTextField, 24);
        passwordTextField.setBounds(300, 250, 300, 50);
        add(passwordTextField);

        repeatPasswordTextField = new JPasswordField("");
        uiPersonalization.setJPasswordField(repeatPasswordTextField, 24);
        repeatPasswordTextField.setBounds(300, 310, 300, 50);
        add(repeatPasswordTextField);

        emailAddressTextField = new JTextField("");
        uiPersonalization.setJTextField(emailAddressTextField, 24);
        emailAddressTextField.setBounds(300, 370, 300, 50);
        add(emailAddressTextField);

        validationErrorMessageLabel = new JLabel(" ");
        uiPersonalization.setJLabel(validationErrorMessageLabel, uiPersonalization.getProjectColor(), 20);
        validationErrorMessageLabel.setBounds(210, 470, 380, 50);
        add(validationErrorMessageLabel);

        validationErrorMessageLabel2 = new JLabel(" ");
        uiPersonalization.setJLabel(validationErrorMessageLabel2, uiPersonalization.getProjectColor(), 20);
        validationErrorMessageLabel2.setBounds(210, 500, 380, 50);
        add(validationErrorMessageLabel2);

        validationErrorMessageLabel3 = new JLabel(" ");
        uiPersonalization.setJLabel(validationErrorMessageLabel3, uiPersonalization.getProjectColor(), 20);
        validationErrorMessageLabel3.setBounds(210, 530, 380, 50);
        add(validationErrorMessageLabel3);

        registerButton = new JButton("Register");
        uiPersonalization.setJButton(registerButton, 25);
        registerButton.setBounds(450, 645, 300, 55);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAction();
            }
        });
        add(registerButton);

        backButton = new JButton("<");
        uiPersonalization.setJButton(backButton, 25);
        backButton.setBounds(40, 645, 100, 55);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mainCoordinator.moveToDefaultPanel();
            }
        });
        add(backButton);
    }

    private void registerAction() {
        Validation.isValidUsername(usernameTextField.getText(), validationErrorMessageLabel);
        boolean usernameValid = Validation.isValidUsername(usernameTextField.getText(), validationErrorMessageLabel);

        boolean nameValid = Validation.isValidName(firstNameTextField.getText(), lastNameTextField.getText(), validationErrorMessageLabel);
        if (usernameValid) {
            Validation.isValidName(firstNameTextField.getText(), lastNameTextField.getText(), validationErrorMessageLabel);
        }

        char[] password = passwordTextField.getPassword();
        char[] repeatPassword = repeatPasswordTextField.getPassword();
        Validation.isValidPassword(new String(password), new String(repeatPassword), validationErrorMessageLabel2);
        boolean passwordValid = Validation.isValidPassword(new String(password), new String(repeatPassword), validationErrorMessageLabel2);
        boolean emailValid = Validation.isValidEmail(emailAddressTextField.getText(), validationErrorMessageLabel3);

        // Move to home panel if all validations pass
        if (usernameValid && nameValid && passwordValid && emailValid) {
            frame.mainCoordinator.moveToHomePanel();
        }
    }


}
