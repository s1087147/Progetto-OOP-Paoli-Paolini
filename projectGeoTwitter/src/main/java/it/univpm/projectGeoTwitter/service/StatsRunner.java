package it.univpm.projectGeoTwitter.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Optional;

import it.univpm.projectGeoTwitter.exception.CapoluogoNotFoundException;
import it.univpm.projectGeoTwitter.model.CapoluoghiMarche;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.StatsCoord;
import it.univpm.projectGeoTwitter.model.StatsDistance;
import it.univpm.projectGeoTwitter.model.TwitterData;

public class StatsRunner extends StatsImpl{

	public static Object getStats(HashMap<String, TwitterData> tweetsMap, Optional<String> capoluogoName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		StatsImpl stats = new StatsImpl();
		
		if(capoluogoName.isPresent()) {
			try {
				CapoluoghiMarche capoluogoMarche = new CapoluoghiMarche();
			    Class<CapoluoghiMarche> capoluogoClass = CapoluoghiMarche.class;
			    String getterCapoluogo = "get" + capoluogoName.get();
				Method method = capoluogoClass.getDeclaredMethod(getterCapoluogo, null);
				Geo capoluogo = (Geo) method.invoke(capoluogoMarche, null);
				
				return new StatsDistance(stats.getMean(tweetsMap, capoluogo),
						stats.getVariance(tweetsMap, capoluogo),
						stats.getStdDev(tweetsMap, capoluogo),
						stats.getMax(tweetsMap, capoluogo),
						stats.getMin(tweetsMap, capoluogo));
			}
			catch(NoSuchMethodException e) {
				throw new CapoluogoNotFoundException("Il campo inserito non fa riferimento ad alcun capoluogo");
			}
		}
		else {
			
			return new StatsCoord(
					stats.getMean(tweetsMap),
					stats.getVariance(tweetsMap),
					stats.getStdDev(tweetsMap));
		}
	}
}
