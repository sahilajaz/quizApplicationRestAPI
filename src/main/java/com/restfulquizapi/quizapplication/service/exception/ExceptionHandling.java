package com.restfulquizapi.quizapplication.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandling{
    
	public ResponseEntity<Object> questionNotFoundException() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
