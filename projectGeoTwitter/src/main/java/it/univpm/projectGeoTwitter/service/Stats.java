package it.univpm.projectGeoTwitter.service;

import java.util.Collection;

import it.univpm.projectGeoTwitter.exception.GenericErrorException;
import it.univpm.projectGeoTwitter.exception.OperatorNotFoundException;
import it.univpm.projectGeoTwitter.model.Geo;
import it.univpm.projectGeoTwitter.model.TwitterData;

/**
 *  Classe in cui vengono dichiarati i metodi utili alle operazioni di statistica su tweets. I metodi qui
 *  dichiarati vengono implementati all'interno della classe {@link it.univpm.projectGeoTwitter.service.StatsImpl StatsImpl}
 *  
 * @author Davide Paolini
 * @author Francesco Paoli Leonardi
 */
public interface Stats {

	/**
	 * Metodo che effettua la statistica relativa alla media di longitudine e latitudine delle località dei tweets.
	 * @param tweets Collection dei tweet da filtrare.
	 * 
	 * @return double[] contenente la media di tutte le longitudini e latitudini relative ai tweets.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getMean(Collection) getMean
	 */
	public abstract double[] getMean(Collection<TwitterData> tweets);
	
	/**
	 * Metodo che effettua la statistica relativa alla media delle distanze tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la media di tutte le distanze.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getMean(Collection, Geo) getMean
	 */
	public abstract double getMean(Collection<TwitterData> tweets, Geo capoluogo);
	
	
	/**
	 * Metodo che effettua la statistica relativa alla varianza di longitudine e latitudine delle località dei tweets.
	 * @param tweets Collection dei tweet da filtrare.
	 * 
	 * @return double[] contenente la varianza di tutte le longitudini e latitudini relative ai tweets.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getVariance(Collection) getVariance
	 */
	public abstract double[] getVariance(Collection<TwitterData> tweets);
	
	/**
	 * Metodo che effettua la statistica relativa alla varianza delle distanze tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la varianza di tutte le distanze.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getVariance(Collection, Geo) getVariance
	 */
	public abstract double getVariance(Collection<TwitterData> tweets, Geo capoluogo);
	
	/**
	 * Metodo che effettua la statistica relativa alla deviazione standard di longitudine e latitudine delle località dei tweets.
	 * @param tweets Collection dei tweet da filtrare.
	 * 
	 * @return double[] contenente la deviazione standard di tutte le longitudini e latitudini relative ai tweets.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getStdDev(Collection) getStdDev
	 */
	public abstract double[] getStdDev(Collection<TwitterData> tweets);
	
	/**
	 * Metodo che effettua la statistica relativa alla deviazione standard delle distanze tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la deviazione standard di tutte le distanze.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getStdDev(Collection, Geo) getStdDev
	 */
	public abstract double getStdDev(Collection<TwitterData> tweets, Geo capoluogo);
	
	/**
	 * Metodo che effettua la statistica relativa alla massima distanza tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la distanza massima.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getMax(Collection, Geo) getMax
	 */
	public abstract double getMax(Collection<TwitterData> tweets, Geo capoluogo);
	
	/**
	 * Metodo che effettua la statistica relativa alla minima distanza tra le località dei tweets e
	 * il capoluogo scelto.
	 * @param tweets Collection dei tweet da filtrare.
	 * @param capoluogo istanza di Geo contenente le coordinate del capoluogo scelto.
	 * 
	 * @return double rappresentante la distanza minima.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getMin(Collection, Geo) getMin
	 */
	public abstract double getMin(Collection<TwitterData> tweets, Geo capoluogo);
	
	/**
	 * Metodo che effettua la statistica relativa al numero medio di caratteri per tweet.
	 * @param tweets Collection dei tweet da filtrare.
	 * 
	 * @return double rappresentante il numero medio di caratteri per tweet.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#getTextAverageLength(Collection) getTextAverageLength
	 */
	public abstract double getTextAverageLength(Collection<TwitterData> tweets);
	
	/**
	 * Metodo che effettua la statistica relativa al numero di tweets inviati da dentro le Marche.
	 * @param tweets Collection dei tweet su cui eseguire la statistica.
	 * 
	 * @throws OperatorNotFoundException quando il nome dell'operatore fornito non è valido.
	 * @throws GenericErrorException quando si verifica un errore interno.
	 * 
	 * @return int rappresentante il numero di tweets inviati da dentro la regione Marche.
	 * 
	 * @see it.univpm.projectGeoTwitter.service.StatsImpl#countTweetsInsideMarche(Collection) countTweetsInsideMarche
	 */
	public abstract int countTweetsInsideMarche(Collection<TwitterData> tweets)
			throws OperatorNotFoundException, GenericErrorException;
}
