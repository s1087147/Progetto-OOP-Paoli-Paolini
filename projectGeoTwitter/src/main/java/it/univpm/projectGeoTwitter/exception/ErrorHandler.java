package it.univpm.projectGeoTwitter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 
 * Gestore delle eccezioni generate da eventuali richieste errate da parte dei client.
 * @author Davide Paolini
 */

@ControllerAdvice
public class ErrorHandler {
	
	/**
	 * Metodo chiamato quando viene lanciata l'eccezione OperatorNotFoundException.
	 * Crea e restituisce un oggetto errorModel, con stato BAD_REQUEST.
	 * @param e L'eccezione OperatorNotFoundException lanciata.
	 * @return ResponseEntity con l'eccezione come body e l' HttpStatus BAD_REQUEST.
	 */	
	@ExceptionHandler(OperatorNotFoundException.class)
	public ResponseEntity<Object> operatorNotFoundHandler(OperatorNotFoundException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	/**
	 * Metodo chiamato quando viene lanciata l'eccezione IllegalValueException.
	 * Crea e restituisce un oggetto errorModel, con stato BAD_REQUEST.
	 * @param e L'eccezione IllegalValueException lanciata.
	 * @return ResponseEntity con l'eccezione come body e l' HttpStatus BAD_REQUEST.
	 */	
	@ExceptionHandler(IllegalValueException.class)
	public ResponseEntity<Object> illegalValueHandler(IllegalValueException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	/**
	 * Metodo chiamato quando viene lanciata l'eccezione GenericErrorException.
	 * Crea e restituisce un oggetto errorModel, con stato BAD_REQUEST.
	 * @param e L'eccezione GenericErrorException lanciata.
	 * @return ResponseEntity con l'eccezione come body e l' HttpStatus BAD_REQUEST.
	 */	
	@ExceptionHandler(GenericErrorException.class)
	public ResponseEntity<Object> genericErrorHandler(GenericErrorException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	/**
	 * Metodo chiamato quando viene lanciata l'eccezione FilterNotFoundException.
	 * Crea e restituisce un oggetto errorModel, con stato BAD_REQUEST.
	 * @param e L'eccezione FilterNotFoundException lanciata.
	 * @return ResponseEntity con l'eccezione come body e l' HttpStatus BAD_REQUEST.
	 */	
	@ExceptionHandler(FilterNotFoundException.class)
	public ResponseEntity<Object> filterNotFoundHandler(FilterNotFoundException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
	
	/**
	 * Metodo chiamato quando viene lanciata l'eccezione EmptyCollectionException.
	 * Crea e restituisce un oggetto errorModel, con stato BAD_REQUEST.
	 * @param e L'eccezione EmptyCollectionException lanciata.
	 * @return ResponseEntity con l'eccezione come body e l' HttpStatus BAD_REQUEST.
	 */	
	@ExceptionHandler(EmptyCollectionException.class)
	public ResponseEntity<Object> emptyCollectionHandler(EmptyCollectionException e){
		return new ResponseEntity<>(new ErrorMessage(e), HttpStatus.BAD_REQUEST);		
	}
}