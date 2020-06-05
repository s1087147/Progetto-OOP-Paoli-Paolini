package it.univpm.projectGeoTwitter.utils.runner;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Optional;

import it.univpm.projectGeoTwitter.exception.BoundingBoxVertexException;
import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.exception.CoordinatesException;
import it.univpm.projectGeoTwitter.exception.EmptyCollectionException;
import it.univpm.projectGeoTwitter.exception.FilterNotFoundException;
import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.IllegalValueException;
import it.univpm.projectGeoTwitter.exception.NegativeRadiusException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.StatsCoord;
import it.univpm.projectGeoTwitter.model.StatsDistance;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.CapoluogoGetter;
import it.univpm.projectGeoTwitter.service.StatsImpl;

public class StatsRunner extends StatsImpl{

	public static Object getStats(Collection<TwitterData> tweets, Optional<String> capoluogoName, Optional<Object> body)
			throws BoundingBoxVertexException, NegativeRadiusException, IllegalValueException, CoordinatesException, GenericErrorException,
				InvocationTargetException, CapoluogoNotFoundException, FilterNotFoundException, OperatorNotFoundException {
		
		Collection<TwitterData> filteredData;
		if(body.isPresent()) {
			filteredData = FilterRunner.getFilters(tweets, body.get());
			if(filteredData.isEmpty())
				throw new EmptyCollectionException("Filtri troppo restrittivi. Non sono rimasti tweets su cui eseguire statistiche.");
		}
		else
			filteredData = tweets;
		
		StatsImpl statsInstance = new StatsImpl();
		
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