package org.digitallibrary.advice.exception;

import java.util.InputMismatchException;

public class RecordNotFoundException extends InputMismatchException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
