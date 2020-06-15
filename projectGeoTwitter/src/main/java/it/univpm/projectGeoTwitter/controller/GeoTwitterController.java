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

import it.univpm.projectGeoTwitter.exception.EmptyCollectionException;
import it.univpm.projectGeoTwitter.exception.FilterNotFoundException;
import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.service.DataService;
import it.univpm.projectGeoTwitter.utils.runner.FilterRunner;
import it.univpm.projectGeoTwitter.utils.runner.StatsRunner;

/** 
 * Classe che gestisce tutte le richieste HTTP eseguite dall'utente.
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */

@RestController
public class GeoTwitterController {

	@Autowired
	DataService dataService;	
	
	/** 
	 * Metodo che gestisce la richiesta GET /data.
	 * La risposta è elaborata da {@link DataService DataService}. 
	 * @return {@literal ResponseEntity<>}
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getData() {
		
		return new ResponseEntity<>(dataService.getData(), HttpStatus.OK);
	}
	
	/**
	 * Metodo che gestisce la richiesta GET /metadata.
	 * La risposta è elaborata da {@link DataService DataService}.
	 * @return {@literal ResponseEntity<>}
	 */
	@RequestMapping(value="/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {
		
		return new ResponseEntity<>(dataService.getMetadata(), HttpStatus.OK);
	}
	 
	/** Metodo che gestisce la richiesta POST /stats
	 * Vengono restituite le statistiche sulle coordinate, oppure sulle distanze dalla provincia fornita come parametro.
	 * La risposta è elaborata da {@link StatsRunner StatsRunner}.
	 * @param capoluogo nome del capoluogo di provincia da usare nell'eventuale calcolo delle statistiche sulle distanze.
	 * @param body Json da fornire opzionalmente come corpo della richiesta se si vuole effettuare un filtro sui tweet prima del calcolo delle statistiche.
	 * 
	 * @throws IllegalValueException quando vengono forniti valori non validi per eseguire il filtro oppure quando il parametro inserito non fa riferimento ad alcun capoluogo.
	 * @throws GenericErrorException quando si verifica un errore interno durante l'esecuzione.
	 * @throws InvocationTargetException quando non è stato trovato il metodo relativo al filtro richiesto.
	 * @throws FilterNotFoundException quando il nome del filtro fornito non è valido.
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * @throws EmptyCollectionException quando si tenta di effettuare statistiche su una collezione di tweets vuota. 
	 * 
	 * @return {@literal ResponseEntity<>}
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
	 * La risposta è elaborata da {@link FilterRunner FilterRunner}.
	 * @param body Json da fornire opzionalmente come corpo della richiesta se si vuole effettuare un filtro sui tweet prima del calcolo delle statistiche.
	 * 
	 * @throws IllegalValueException quando vengono forniti valori non validi per eseguire il filtro.
	 * @throws GenericErrorException quando si verifica un errore interno durante l'esecuzione. 
	 * @throws InvocationTargetException quando non è stato trovato il metodo relativo al filtro richiesto.
	 * @throws FilterNotFoundException quando il nome del filtro fornito non è valido.
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * 
	 * @return {@literal ResponseEntity<>}
	 */
	@RequestMapping(value="/filter", method = RequestMethod.POST)
	public ResponseEntity<Object> getFilteredTweets(@RequestBody Object body)
			throws IllegalValueException, GenericErrorException, InvocationTargetException, FilterNotFoundException,
				OperatorNotFoundException{
		
		return new ResponseEntity<>(FilterRunner.getFilters(dataService.getData(), body), HttpStatus.OK);
	}
}