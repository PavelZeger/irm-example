package com.screen.springboot.rest.example.student.controller;

import com.screen.springboot.rest.example.student.annotation.CustomExceptionHandler;
import com.screen.springboot.rest.example.student.controller.dto.Response;
import com.screen.springboot.rest.example.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author Pavel Zeger
 * @implNote irm-example
 * @since 11/04/2021
 */
@ControllerAdvice(annotations = CustomExceptionHandler.class)
public class DefaultAdvice {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Response> handleException(StudentNotFoundException studentNotFoundException) {
        String message = String.format("%s %s", LocalDateTime.now(), studentNotFoundException.getMessage());
        Response response = new Response(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
