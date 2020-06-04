package it.univpm.projectGeoTwitter.utils.runner;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Optional;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.StatsCoord;
import it.univpm.projectGeoTwitter.model.StatsDistance;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.service.CapoluogoGetter;
import it.univpm.projectGeoTwitter.service.StatsImpl;

public class StatsRunner extends StatsImpl{

	public static Object getStats(Collection<TwitterData> tweets, Optional<String> capoluogoName, Optional<Object> body)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Collection<TwitterData> filteredData;
		if(body.isPresent())
			filteredData = FilterRunner.getFilters(tweets, body.get());
		else
			filteredData = tweets;
		
		StatsImpl statsInstance = new StatsImpl();
		
		if(capoluogoName.isPresent()) {
			try {
				
				Geo capoluogo = CapoluogoGetter.getCapoluogo(capoluogoName.get());
				
				return new StatsDistance(statsInstance.getMean(filteredData, capoluogo),
						statsInstance.getVariance(filteredData, capoluogo),
						statsInstance.getStdDev(filteredData, capoluogo),
						statsInstance.getMax(filteredData, capoluogo),
						statsInstance.getMin(filteredData, capoluogo));
				
			} catch(NoSuchMethodException e) {
				throw new CapoluogoNotFoundException("Il parametro inserito non fa riferimento ad alcun capoluogo");
			}
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