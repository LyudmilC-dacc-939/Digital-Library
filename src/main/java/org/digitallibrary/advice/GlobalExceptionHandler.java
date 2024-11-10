package org.digitallibrary.advice;

import org.digitallibrary.advice.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

/*    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException recordNotFoundException) {
        return new ResponseEntity<>(recordNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }*/
    //The above method is the old handleRecordNotFoundException
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRecordNotFoundException(RecordNotFoundException recordNotFoundException) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", recordNotFoundException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
