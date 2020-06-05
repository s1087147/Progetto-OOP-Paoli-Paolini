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
	
	@ExceptionHandler(NegativeRadiusException.class)
	public ResponseEntity<Object> negativeRadiusHandler(NegativeRadiusException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(IllegalValueException.class)
	public ResponseEntity<Object> illegalValueHandler(IllegalValueException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(BoundingBoxVertexException.class)
	public ResponseEntity<Object> boundingBoxVertexHandler(BoundingBoxVertexException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(CoordinatesException.class)
	public ResponseEntity<Object> coordinatesHandler(CoordinatesException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(GenericErrorException.class)
	public ResponseEntity<Object> genericErrorHandler(GenericErrorException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(FilterNotFoundException.class)
	public ResponseEntity<Object> filterNotFoundHandler(FilterNotFoundException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(EmptyCollectionException.class)
	public ResponseEntity<Object> emptyCollectionHandler(EmptyCollectionException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
}
