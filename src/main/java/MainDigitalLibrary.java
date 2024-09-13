package main.java;

import main.java.mainframe.MainFrame;

import java.awt.Color;

public class MainDigitalLibrary {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.getContentPane().setBackground(new Color(240, 255, 173));
        frame.setVisible(true);
    }
}
