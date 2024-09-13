package main.java.helper;

import javax.swing.*;

public class MessageWindow {
    //тези два метода са статични за да могат да бъдат извиквани навсякъде в проекта, също така тук използваме
    //Overload methods -- което са два или повече метода, с идентични имена и сходни фукнции, но с различни променливи

    public static void popUpErrorMessage(){
        JOptionPane.showMessageDialog(null, "Something is wrong", "Error in Code", JOptionPane.ERROR_MESSAGE);
    }
    public static void popUpErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Error in Code", JOptionPane.ERROR_MESSAGE);
    }

}
