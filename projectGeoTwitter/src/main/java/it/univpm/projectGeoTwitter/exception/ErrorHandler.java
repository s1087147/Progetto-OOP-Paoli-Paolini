package it.univpm.projectGeoTwitter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice 		//??
public class ErrorHandler {
	
	@ExceptionHandler(CapoluogoNotFoundException.class)
	public ResponseEntity<Object> capoluogoNotFoundHandler(CapoluogoNotFoundException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(OperatorNotFoundException.class)
	public ResponseEntity<Object> operatorNotFoundHandler(OperatorNotFoundException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(NegativeRadiusException.class)		//NON FUNZIONANTE
	public ResponseEntity<Object> negativeRadiusHandler(NegativeRadiusException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(IllegalValueException.class)
	public ResponseEntity<Object> illegalValueHandler(IllegalValueException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
}
