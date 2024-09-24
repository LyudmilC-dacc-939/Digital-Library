package org.digitallibrary;

import org.digitallibrary.mainframe.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.Color;

@SpringBootApplication
public class MainDigitalLibrary {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.getContentPane().setBackground(new Color(240, 255, 173));
        frame.setVisible(true);
    }
}
