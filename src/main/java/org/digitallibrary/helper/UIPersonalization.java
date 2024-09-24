package org.digitallibrary.helper;

import lombok.Getter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

@Getter
public class UIPersonalization {
    private JLabel jLabel;
    private JTextField jTextField;
    private JButton jButton;
    private JTextArea jTextArea;
    private JPasswordField jPasswordField;

    @Getter
    private final Color projectColor = new Color(240, 255, 173);
    @Getter
    private final Color projectColor2 = new Color(106, 143, 255);


    public void setJLabel(JLabel jLabel) {
        jLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        jLabel.setForeground(Color.DARK_GRAY);
        jLabel.setBackground(projectColor);
        this.jLabel = jLabel;
    }

    public void setJLabel(JLabel jLabel, int textSize) {
        jLabel.setFont(new Font("IBM Plex Serif", Font.BOLD, textSize));
        jLabel.setForeground(Color.DARK_GRAY);
        jLabel.setBackground(projectColor);
        this.jLabel = jLabel;
    }

    public void setJLabel(JLabel jLabel, Color textColor, int textSize) {
        jLabel.setFont(new Font("Serif", Font.PLAIN, textSize));
        jLabel.setForeground(textColor);
        jLabel.setBackground(projectColor);
        this.jLabel = jLabel;
    }

    public void setJTextField(JTextField jTextField, int size) {
        jTextField.setFont(new Font("Serif", Font.PLAIN, size));
        jTextField.setForeground(projectColor);
        jTextField.setBackground(Color.DARK_GRAY);
        jTextField.setOpaque(true);
        this.jTextField = jTextField;
    }

    public void setJButton(JButton jButton, int size) {
        jButton.setFont(new Font("Serif", Font.PLAIN, size));
        jButton.setForeground(projectColor);
        jButton.setBackground(Color.DARK_GRAY);
        jButton.setOpaque(true);
        this.jButton = jButton;
    }

    public void setJTextArea(JTextArea jTextArea, int size) {
        jTextArea.setFont(new Font("IBM Plex Serif", Font.BOLD, size));
        jTextArea.setForeground(Color.DARK_GRAY);
        jTextArea.setBackground(projectColor);
        this.jTextArea = jTextArea;
    }

    public void setJPasswordField(JPasswordField jPasswordField, int size) {
        jPasswordField.setFont(new Font("Serif", Font.PLAIN, size));
        jPasswordField.setForeground(projectColor);
        jPasswordField.setBackground(Color.DARK_GRAY);
        jPasswordField.setOpaque(true);
        this.jPasswordField = jPasswordField;
    }

}
