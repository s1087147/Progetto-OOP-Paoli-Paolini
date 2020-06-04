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

	public static Object getStats(Collection<TwitterData> tweets, Optional<String> capoluogoName)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		StatsImpl statsInstance = new StatsImpl();
		
		if(capoluogoName.isPresent()) {
			try {
				
				Geo capoluogo = CapoluogoGetter.getCapoluogo(capoluogoName.get());
				
				return new StatsDistance(statsInstance.getMean(tweets, capoluogo),
						statsInstance.getVariance(tweets, capoluogo),
						statsInstance.getStdDev(tweets, capoluogo),
						statsInstance.getMax(tweets, capoluogo),
						statsInstance.getMin(tweets, capoluogo));
				
			} catch(NoSuchMethodException e) {
				throw new CapoluogoNotFoundException("Il parametro inserito non fa riferimento ad alcun capoluogo");
			}
		}
		else {
			
			return new StatsCoord(
					statsInstance.getMean(tweets),
					statsInstance.getVariance(tweets),
					statsInstance.getStdDev(tweets),
					statsInstance.getTextAverageLength(tweets),
					statsInstance.countTweetsInsideMarche(tweets));
		}
	}
}