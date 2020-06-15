package com.APIProject.apiProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class ExceptionsHandler {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.newBuilder()
                .withTimestamp(new Date())
                .withMessage(ex.getMessage())
                .withDetails(request.getDescription(false)).build();

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.newBuilder().
                withTimestamp(new Date())
                .withMessage(ex.getMessage())
                .withDetails(request.getDescription(false)).build();

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}