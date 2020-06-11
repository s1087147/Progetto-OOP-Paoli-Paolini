package it.univpm.projectGeoTwitter.service;

import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;
import it.univpm.projectGeoTwitter.utils.stats.CountTweetsInsideMarche;
import it.univpm.projectGeoTwitter.utils.stats.GeoMaxDistance;
import it.univpm.projectGeoTwitter.utils.stats.GeoMeanCoord;
import it.univpm.projectGeoTwitter.utils.stats.GeoMeanDistance;
import it.univpm.projectGeoTwitter.utils.stats.GeoMinDistance;
import it.univpm.projectGeoTwitter.utils.stats.GeoStdDevCoord;
import it.univpm.projectGeoTwitter.utils.stats.GeoStdDevDistance;
import it.univpm.projectGeoTwitter.utils.stats.GeoVarianceCoord;
import it.univpm.projectGeoTwitter.utils.stats.GeoVarianceDistance;
import it.univpm.projectGeoTwitter.utils.stats.TextAverageLength;

public class StatsImpl implements Stats {
	
	@Override
	public double[] getMean(Collection<TwitterData> tweets) {

		return GeoMeanCoord.getMean(tweets);
	}
	
	@Override
	public double getMean(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoMeanDistance.getMean(tweets, capoluogo);
	}

	@Override
	public double[] getVariance(Collection<TwitterData> tweets) {

		return GeoVarianceCoord.getVariance(tweets);
	}
	
	@Override
	public double getVariance(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoVarianceDistance.getVariance(tweets, capoluogo);
	}
	
	@Override
	public double[] getStdDev(Collection<TwitterData> tweets) {

		return GeoStdDevCoord.getStdDev(tweets);
	}
	
	@Override
	public double getStdDev(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoStdDevDistance.getStdDev(tweets, capoluogo);
	}
	
	@Override
	public double getMax(Collection<TwitterData> tweets, Geo capoluogo) {
		
		return GeoMaxDistance.getMax(tweets, capoluogo);
	}
	
	@Override
	public double getMin(Collection<TwitterData> tweets, Geo capoluogo) {
		
		return GeoMinDistance.getMin(tweets, capoluogo);
	}
	
	@Override
	public double getTextAverageLength(Collection<TwitterData> tweets) {
		
		return TextAverageLength.averageLength(tweets);
	}
	
	@Override
	public int countTweetsInsideMarche(Collection<TwitterData> tweets)
			throws OperatorNotFoundException, GenericErrorException {
		
		return CountTweetsInsideMarche.insideMarche(tweets);
	}
}
