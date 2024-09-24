package helper;

import javax.swing.JLabel;
import java.awt.Color;

public class Validation {
    private static Color complementaryColor = new Color(106, 143, 255);

    public static boolean isValidUsername(String username, JLabel jLabel) {
        if (username.length() >= 5 && username.length() <= 25) {
            return true;
        }

        jLabel.setForeground(complementaryColor);
        if (username.length() < 5) {
            jLabel.setText("Username must be at least 5 characters long!");
        }
        if (username.length() > 25) {
            jLabel.setText("Username must be at most 25 characters long!");
        }

        return false;
    }

    public static boolean isValidName(String firstName, String lastName, JLabel jLabel) {
        if (firstName.matches("[^A-Za-z]") || lastName.matches("[^A-Za-z]")) {
            jLabel.setForeground(complementaryColor);
            if (firstName.matches("[^A-Za-z]")) {
                jLabel.setText("Invalid first name!");
            }
            if (lastName.matches("[^A-Za-z]")) {
                jLabel.setText("Invalid last name!");
            }
            return false;
        }

        return true;
    }

    public static boolean isValidPassword(String password, String confirmPassword, JLabel jLabel) {
        boolean isCountValid = password.length() >= 8;
        boolean arePasswordsMatched = password.equals(confirmPassword);
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches("[^0-9A-Za-z]");

        if (isCountValid && arePasswordsMatched && hasUpperCase && hasLowerCase && hasNumber && hasSpecial) {
            return true;
        }

        jLabel.setForeground(complementaryColor);
        if (!isCountValid) {
            jLabel.setText("Password must be at least 8 characters!");
        } else if (!hasUpperCase) {
            jLabel.setText("Password must have at least 1 Uppercase letter!");
        } else if (!hasLowerCase) {
            jLabel.setText("Password must have at least 1 Lowercase letter!");
        } else if (!hasNumber) {
            jLabel.setText("Password must have at least 1 number!");
        } else if (!arePasswordsMatched) {
            jLabel.setText("Passwords don't match!");
        }
        return false;
    }

    public static boolean isValidEmail(String email, JLabel jLabel){
        if(!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
                "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[" +
                "\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9]" +
                "(?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|" +
                "[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[" +
                "\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
            return true;
        }

        jLabel.setForeground(complementaryColor);
        jLabel.setText("Invalid Email");
        return false;
    }
}
