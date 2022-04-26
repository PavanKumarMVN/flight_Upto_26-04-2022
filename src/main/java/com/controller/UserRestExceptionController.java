package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class UserRestExceptionController {
	@ExceptionHandler(DeleteException.class)
    public ResponseEntity<?> handleDeleteException(DeleteException e,WebRequest req)
    {		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(UpdateException.class)
    public ResponseEntity<?> handleUpdateException(UpdateException e,WebRequest req)
    {
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);		
    }	
}


