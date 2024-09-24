package org.digitallibrary.helper;

import javax.swing.JOptionPane;

public class MessageWindow {

    public static void popUpErrorMessage(){
        JOptionPane.showMessageDialog(null, "Something is wrong", "Error in Code", JOptionPane.ERROR_MESSAGE);
    }
    public static void popUpErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Error in Code", JOptionPane.ERROR_MESSAGE);
    }

}
