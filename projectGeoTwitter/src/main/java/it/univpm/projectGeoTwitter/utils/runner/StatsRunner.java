package it.univpm.projectGeoTwitter.utils.runner;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Optional;

import it.univpm.projectGeoTwitter.exception.EmptyCollectionException;
import it.univpm.projectGeoTwitter.exception.FilterNotFoundException;
import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.StatsCoord;
import it.univpm.projectGeoTwitter.model.StatsDistance;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.CapoluogoGetter;
import it.univpm.projectGeoTwitter.service.StatsImpl;

/**
 * Classe che gestisce la chiamata alle statistiche.
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class StatsRunner extends StatsImpl{

	/**
	 * Metodo che gestisce la chiamata alle statistiche e ad eventuali filtri richiesti dal client.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogoName nome del capoluogo di provincia rispetto al quale calcolare la distanza da usare nelle statistiche. Se non presente si calcolano le statistiche relative alle coordinate.
	 * @param body "body" della richiesta HTTP effettuata dal client per effettuare eventuali filtri.
	 * 
	 * @throws IllegalValueException quando vengono forniti valori non validi per eseguire il filtro oppure quando il parametro inserito non fa riferimento ad alcun capoluogo.
	 * @throws GenericErrorException quando si verifica un errore interno durante l'esecuzione.
	 * @throws InvocationTargetException quando non è stato trovato il metodo relativo al filtro richiesto.
	 * @throws FilterNotFoundException quando il nome del filtro fornito non è valido.
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito per il filtro non è valido.
	 * @throws EmptyCollectionException quando si tenta di effettuare statistiche su una collezione di tweets vuota.
	 * 
	 * @return Object contenente le statistiche richieste.
	 */
	public static Object getStats(Collection<TwitterData> tweets, Optional<String> capoluogoName, Optional<Object> body)
			throws IllegalValueException, GenericErrorException, InvocationTargetException, FilterNotFoundException,
				OperatorNotFoundException, EmptyCollectionException {
		
		Collection<TwitterData> filteredData;
		if(body.isPresent()) {
			filteredData = FilterRunner.getFilters(tweets, body.get());
			if(filteredData.isEmpty())
				throw new EmptyCollectionException("Filtri troppo restrittivi. Non sono rimasti tweets su cui eseguire statistiche.");
		}
		else
			filteredData = tweets;
		
		StatsRunner statsInstance = new StatsRunner();
		
		if(capoluogoName.isPresent()) {
			
			Geo capoluogo = CapoluogoGetter.getCapoluogo(capoluogoName.get());
				
			return new StatsDistance(statsInstance.getMean(filteredData, capoluogo),
					statsInstance.getVariance(filteredData, capoluogo),
					statsInstance.getStdDev(filteredData, capoluogo),
					statsInstance.getMax(filteredData, capoluogo),
					statsInstance.getMin(filteredData, capoluogo));
		}
		else {
			
			return new StatsCoord(
					statsInstance.getMean(filteredData),
					statsInstance.getVariance(filteredData),
					statsInstance.getStdDev(filteredData),
					statsInstance.getTextAverageLength(filteredData),
					statsInstance.countTweetsInsideMarche(filteredData));
		}
	}
}