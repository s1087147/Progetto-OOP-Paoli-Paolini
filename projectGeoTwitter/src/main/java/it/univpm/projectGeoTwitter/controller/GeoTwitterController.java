package it.univpm.projectGeoTwitter.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.exception.EmptyCollectionException;
import it.univpm.projectGeoTwitter.exception.FilterNotFoundException;
import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.service.DataService;
import it.univpm.projectGeoTwitter.utils.runner.FilterRunner;
import it.univpm.projectGeoTwitter.utils.runner.StatsRunner;

/**
 * Classe che gestisce tutte le richieste HTTP eseguite dall'utente.
*  @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */

@RestController
public class GeoTwitterController {

	@Autowired
	DataService dataService;	
	
	/**
	 * Metodo che gestisce la richiesta GET /data
	 * @return ResponseEntity<>
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getData() {
		
		return new ResponseEntity<>(dataService.getData(), HttpStatus.OK);
	}
	
	/**
	 * Metodo che gestisce la richiesta GET /metadata
	 * @return ResponseEntity<>
	 */
	@RequestMapping(value="/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {
		
		return new ResponseEntity<>(dataService.getMetadata(), HttpStatus.OK);
	}
	 
	/**
	 * Metodo che gestisce la richiesta POST /stats
	 * Vengono restituite le statistiche sulle coordinate, oppure sulle distanze dalla provincia fornita come parametro.
	 * @param name : nome del capoluogo di provincia da usare nell'eventuale calcolo delle statistiche sulle distanze.
	 * @param body : Json da fornire opzionalmente come corpo della richiesta se si vuole effettuare un filtro sui tweet prima del calcolo delle statistiche.
	 * @throws IllegalValueException quando vengono forniti valori non validi per eseguire il filtraggio oppure quando il parametro inserito non fa riferimento ad alcun capoluogo.
	 * @throws GenericErrorException quando si verifica un errore interno durante l'esecuzione.
	 * @throws FilterNotFoundException quando il nome del filtro fornito non è valido.
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * @throws EmptyCollectionException quando si tenta di effettuare statistiche su una collezione di tweets vuota
	 * @throws InvocationTargetException quando non è stato trovato il metodo relativo al filtro richiesto
	 * @return ResponseEntity<> 
	 * 
	 */
	@RequestMapping(value="/stats", method = RequestMethod.POST)
	public ResponseEntity<Object> getStats(@RequestParam(name = "capoluogo") Optional<String> capoluogo,
			@RequestBody Optional<Object> body) throws IllegalValueException, GenericErrorException, InvocationTargetException,
			FilterNotFoundException, OperatorNotFoundException, EmptyCollectionException {
		
		return new ResponseEntity<>(StatsRunner.getStats(dataService.getData(), capoluogo, body), HttpStatus.OK);
	}
	
	/**
	 * Metodo che gestisce la richiesta POST /filter
	 * Vengono restituiti tutti i tweets che rientrano nei filtri specificati.
	 * @param name : nome del capoluogo di provincia da usare nell'eventuale calcolo delle statistiche sulle distanze.
	 * @param body : Json da fornire opzionalmente come corpo della richiesta se si vuole effettuare un filtro sui tweet prima del calcolo delle statistiche.
	 * @throws IllegalValueException quando vengono forniti valori non validi per eseguire il filtraggio.
	 * @throws GenericErrorException quando si verifica un errore interno durante l'esecuzione.
	 * @throws FilterNotFoundException quando il nome del filtro fornito non è valido.
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * @throws InvocationTargetException quando non è stato trovato il metodo relativo al filtro richiesto
	 * @return ResponseEntity<> 
	 * 
	 */
	@RequestMapping(value="/filter", method = RequestMethod.POST)
	public ResponseEntity<Object> getFilteredTweets(@RequestBody Object body)
			throws IllegalValueException, GenericErrorException, InvocationTargetException, FilterNotFoundException,
				OperatorNotFoundException{
		
		return new ResponseEntity<>(FilterRunner.getFilters(dataService.getData(), body), HttpStatus.OK);
	}	
	 /*
	  * {
	  * "filters":[
	  * 	{
	  * 	"filter": String,
	  * 	"operator": String,
	  * 	"filterValue": Object		//Capoluogo e distanza unici dati in italiano
	  * 	},
	  * 	{...}
	  * ]
	  * } 
	 */	
}