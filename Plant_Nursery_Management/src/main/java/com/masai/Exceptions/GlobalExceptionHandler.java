package com.masai.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
	public class GlobalExceptionHandler{

		@ExceptionHandler(SeedException.class)
		public ResponseEntity<MyCustomError> seedExceptionHandler(SeedException ee,WebRequest wrq){
			
			System.out.println("inside SeedException method...");
			MyCustomError seedError = new MyCustomError();
			seedError.setLdt(LocalDateTime.now());
			seedError.setMessage(ee.getMessage());
			seedError.setDetails(wrq.getDescription(false));
			
			return new ResponseEntity<>(seedError,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(PlantException.class)
		public ResponseEntity<MyCustomError> plantExceptionHandler(PlantException ee,WebRequest wrq){
			
			System.out.println("inside PlantException method...");
			MyCustomError plantError = new MyCustomError();
			plantError.setLdt(LocalDateTime.now());
			plantError.setMessage(ee.getMessage());
			plantError.setDetails(wrq.getDescription(false));
			
			return new ResponseEntity<>(plantError,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(PlanterException.class)
		public ResponseEntity<MyCustomError> planterExceptionHandler(PlanterException ee,WebRequest wrq){
			
			System.out.println("inside PlanterException method...");
			MyCustomError planterError = new MyCustomError();
			planterError.setLdt(LocalDateTime.now());
			planterError.setMessage(ee.getMessage());
			planterError.setDetails(wrq.getDescription(false));
			
			return new ResponseEntity<>(planterError,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(CartException.class)
		public ResponseEntity<MyCustomError> cartExceptionHandler(CartException ee,WebRequest wrq){
			
			System.out.println("inside CartException method...");
			MyCustomError cartError = new MyCustomError();
			cartError.setLdt(LocalDateTime.now());
			cartError.setMessage(ee.getMessage());
			cartError.setDetails(wrq.getDescription(false));
			
			return new ResponseEntity<>(cartError,HttpStatus.BAD_REQUEST);
		}
		
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MyCustomError> validatorHandler(MethodArgumentNotValidException ie) {
		
			System.out.println("inside ValidatorException method...");
			MyCustomError validatorError = new MyCustomError();
			
			validatorError.setLdt(LocalDateTime.now());
			validatorError.setMessage("Check the constraint size");
			validatorError.setDetails(ie.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(validatorError,HttpStatus.NOT_ACCEPTABLE);
		}
		
		@ExceptionHandler(Exception.class)
		public ResponseEntity<MyCustomError> otherExceptionHandler(Exception e,WebRequest wrq){
			
			System.out.println("inside  Exception method...");
			MyCustomError allOtherExceptions = new MyCustomError();
			allOtherExceptions.setLdt(LocalDateTime.now());
			allOtherExceptions.setMessage(e.getMessage());
			allOtherExceptions.setDetails(wrq.getDescription(false));
			
			return new ResponseEntity<>(allOtherExceptions,HttpStatus.NOT_FOUND);
		}
	

	
}
