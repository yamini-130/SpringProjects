package com.practice.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
//    add exception handling code
@ExceptionHandler
public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe) {
    StudentErrorResponse error = new StudentErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exe.getMessage());
    error.setTimestamp(System.currentTimeMillis());
    // return response entity
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}

    /// add another exception handler to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
