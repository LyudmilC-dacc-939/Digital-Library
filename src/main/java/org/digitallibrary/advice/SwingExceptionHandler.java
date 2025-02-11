package org.digitallibrary.advice;

import org.digitallibrary.advice.exception.RecordNotFoundException;
import org.digitallibrary.advice.exception.TokenExpiredException;
import org.digitallibrary.helper.MessageWindow;
import org.digitallibrary.mainframe.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SwingExceptionHandler {

    @Autowired
    private MainFrame mainFrame;

    @ExceptionHandler(AuthenticationException.class)
    public void handleAuthException(AuthenticationException ex) {
        MessageWindow.popUpErrorMessage("Authentication failed: " + ex.getMessage());
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public void handleRecordNotFound(RecordNotFoundException ex) {
        MessageWindow.popUpErrorMessage("User not found: " + ex.getMessage());
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<Map<String, String>> handleTokenExpiredException(TokenExpiredException ex) {

        // Redirect to the login screen
        mainFrame.mainCoordinator.logout();

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}