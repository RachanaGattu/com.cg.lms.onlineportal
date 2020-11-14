package com.cg.lms.onlineportal.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(QuestionNotFoundException.class)
	public ResponseEntity<?> UserNotFoundHandling(QuestionNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("UserNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SurveyorNotFoundException.class)
	public ResponseEntity<?> AddressNotFoundHandling(SurveyorNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("AddressNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> CustomValidationErrorHandling(MethodArgumentNotValidException exception){
		ErrorDetails errormessage=new ErrorDetails("Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.BAD_REQUEST);
	}
	
	

}
