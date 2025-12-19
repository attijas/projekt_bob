package com.test.bob.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExist(UserAlreadyExistException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(exception.getMessage(), 409));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(exception.getMessage(), 404));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleOther(Exception exception){
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(new ErrorResponse("Wewnętrzny błąd serwera", 500));
    }

}
