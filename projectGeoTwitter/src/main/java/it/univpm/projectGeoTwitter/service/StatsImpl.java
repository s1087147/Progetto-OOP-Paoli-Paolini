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
	 * Metodo che effettua la statistica relativa alla media di longitudine e latitudine delle località dei tweets.
	 * @param tweets Collection dei tweet da filtrare.
	 * 
	 * @return double[] contenente la media di tutte le longitudini e latitudini relative ai tweets.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoMeanCoord#getMean(Collection) getMean
	 */
	@Override
	public double[] getMean(Collection<TwitterData> tweets) {

		return GeoMeanCoord.getMean(tweets);
	}
	
	/**
	 * Metodo che effettua la statistica relativa alla media delle distanze tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la media di tutte le distanze.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoMeanDistance#getMean(Collection) getMean
	 */
	@Override
	public double getMean(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoMeanDistance.getMean(tweets, capoluogo);
	}

	/**
	 * Metodo che effettua la statistica relativa alla varianza di longitudine e latitudine delle località dei tweets.
	 * @param tweets Collection dei tweet da filtrare.
	 * 
	 * @return double[] contenente la varianza di tutte le longitudini e latitudini relative ai tweets.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoVarianceCoord#getVariance(Collection) getVariance
	 */
	@Override
	public double[] getVariance(Collection<TwitterData> tweets) {

		return GeoVarianceCoord.getVariance(tweets);
	}
	
	/**
	 * Metodo che effettua la statistica relativa alla varianza delle distanze tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la varianza di tutte le distanze.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoVarianceDistance#getVariance(Collection) getVariance
	 */
	@Override
	public double getVariance(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoVarianceDistance.getVariance(tweets, capoluogo);
	}
	
	/**
	 * Metodo che effettua la statistica relativa alla deviazione standard di longitudine e latitudine delle località dei tweets.
	 * @param tweets Collection dei tweet da filtrare.
	 * 
	 * @return double[] contenente la deviazione standard di tutte le longitudini e latitudini relative ai tweets.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoStdDevCoord#getStdDev(Collection) getStdDev
	 */
	@Override
	public double[] getStdDev(Collection<TwitterData> tweets) {

		return GeoStdDevCoord.getStdDev(tweets);
	}
	
	/**
	 * Metodo che effettua la statistica relativa alla deviazione standard delle distanze tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la deviazione standard di tutte le distanze.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoStdDevDistance#getStdDev(Collection) getStdDev
	 */
	@Override
	public double getStdDev(Collection<TwitterData> tweets, Geo capoluogo) {

		return GeoStdDevDistance.getStdDev(tweets, capoluogo);
	}
	
	/**
	 * Metodo che effettua la statistica relativa alla massima distanza tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la distanza massima.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoMaxDistance#getMax(Collection) getMax
	 */
	@Override
	public double getMax(Collection<TwitterData> tweets, Geo capoluogo) {
		
		return GeoMaxDistance.getMax(tweets, capoluogo);
	}
	
	/**
	 * Metodo che effettua la statistica relativa alla minima distanza tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la distanza minima.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.GeoMinDistance#getMin(Collection) getMin
	 */
	@Override
	public double getMin(Collection<TwitterData> tweets, Geo capoluogo) {
		
		return GeoMinDistance.getMin(tweets, capoluogo);
	}
	
	/**
	 * Metodo che effettua la statistica relativa al numero medio di caratteri per tweet.
	 * @param tweets Collection dei tweet da filtrare.
	 * 
	 * @return double rappresentante il numero medio di caratteri per tweet.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.TextAverageLength#averageLength(Collection) averageLength
	 */
	@Override
	public double getTextAverageLength(Collection<TwitterData> tweets) {
		
		return TextAverageLength.averageLength(tweets);
	}
	
	/**
	 * Metodo che effettua la statistica relativa al numero di tweets inviati da dentro le Marche.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * 
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * @throws GenericErrorException quando si verifica un errore interno.
	 * 
	 * @return int rappresentante il numero di tweets inviati da dentro la regione Marche.
	 * 
	 * @see it.univpm.projectGeoTwitter.utils.stats.CountTweetsInsideMarche#insideMarche(Collection) insideMarche
	 */
	@Override
	public int countTweetsInsideMarche(Collection<TwitterData> tweets)
			throws OperatorNotFoundException, GenericErrorException {
		
		return CountTweetsInsideMarche.insideMarche(tweets);
	}
}
