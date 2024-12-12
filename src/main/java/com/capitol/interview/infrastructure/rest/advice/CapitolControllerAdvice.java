package com.capitol.interview.infrastructure.rest.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capitol.interview.infrastructure.adapter.exception.PriceException;

@ControllerAdvice
public class CapitolControllerAdvice {
	//TODO
    @ExceptionHandler(PriceException.class)
    public ResponseEntity<String> handleEmptyInputOrOutput(PriceException emptyInputException){
        return new ResponseEntity<String>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
    }
}
