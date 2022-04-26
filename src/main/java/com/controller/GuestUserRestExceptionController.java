package com.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GuestUserRestExceptionController {
	@ExceptionHandler(DeleteException.class)
    public ResponseEntity<?> handleDeleteException(DeleteException e,WebRequest req)
    {
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(UpdateException.class)
    public ResponseEntity<?> handleUpdateException(UpdateException e1,WebRequest req1)
    {
		return new ResponseEntity<>(e1.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(AddGuestUserException.class)
    public ResponseEntity<?> handleAddException(AddGuestUserException e2,WebRequest req2)
    {
		return new ResponseEntity<>(e2.toString(),HttpStatus.NOT_FOUND);		
    }
}

