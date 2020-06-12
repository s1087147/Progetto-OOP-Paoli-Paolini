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

/**
 * Classe che implementa i metodi astratti dichiarati nell'interfaccia {@link it.univpm.projectGeoTwitter.service.Stats Stats}
 * 
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public class StatsImpl implements Stats {
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoMeanCoord#getMean(Collection) getMean
	 */
	@Override
	public double[] getMean(Collection<TwitterData> tweets) {

		return GeoMeanCoord.getMean(tweets);
	}
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoMeanDistance#getMean(Collection, Geo) getMean
	 */
	@Override
	public double getMean(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoMeanDistance.getMean(tweets, capoluogo);
	}

	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoVarianceCoord#getVariance(Collection) getVariance
	 */
	@Override
	public double[] getVariance(Collection<TwitterData> tweets) {

		return GeoVarianceCoord.getVariance(tweets);
	}
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoVarianceDistance#getVariance(Collection, Geo) getVariance
	 */
	@Override
	public double getVariance(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoVarianceDistance.getVariance(tweets, capoluogo);
	}
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoStdDevCoord#getStdDev(Collection) getStdDev
	 */
	@Override
	public double[] getStdDev(Collection<TwitterData> tweets) {

		return GeoStdDevCoord.getStdDev(tweets);
	}
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoStdDevDistance#getStdDev(Collection, Geo) getStdDev
	 */
	@Override
	public double getStdDev(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoStdDevDistance.getStdDev(tweets, capoluogo);
	}
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoMaxDistance#getMax(Collection, Geo) getMax
	 */
	@Override
	public double getMax(Collection<TwitterData> tweets, Geo capoluogo) {
		
		return GeoMaxDistance.getMax(tweets, capoluogo);
	}
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoMinDistance#getMin(Collection, Geo) getMin
	 */
	@Override
	public double getMin(Collection<TwitterData> tweets, Geo capoluogo) {
		
		return GeoMinDistance.getMin(tweets, capoluogo);
	}
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.TextAverageLength#averageLength(Collection) averageLength
	 */
	@Override
	public double getTextAverageLength(Collection<TwitterData> tweets) {
		
		return TextAverageLength.averageLength(tweets);
	}
	
	/**
	 * {@inheritDoc}
	 * @see it.univpm.projectGeoTwitter.utils.stats.CountTweetsInsideMarche#insideMarche(Collection) insideMarche
	 */
	@Override
	public int countTweetsInsideMarche(Collection<TwitterData> tweets)
			throws OperatorNotFoundException, GenericErrorException {
		
		return CountTweetsInsideMarche.insideMarche(tweets);
	}
}