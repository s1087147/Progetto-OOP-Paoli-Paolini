package it.univpm.projectGeoTwitter.model;

/**
 * Modello per la rappresentazione delle statistiche riguardanti coordinate, testo e locazione dei tweets.
 * @author Francesco Paoli Leonardi
 */
public class StatsCoord {

	/**
	 * Media di longitudine e latitudine relative ai tweets.
	 */
	private double[] mean;
	
	/**
	 * Varianza di longitudine e latitudine relative ai tweets.
	 */
	private double[] variance;
	
	/**
	 * Deviazione standard di longitudine e latitudine relative ai tweets.
	 */
	private double[] stdDev;
	
	/**
	 * Numero medio di caratteri per tweet.
	 */
	private double textAverageLength;
	
	/**
	 * Numero di tweets la cui località di invio è situata all'interno della regione Marche.
	 */
	private int tweetsInsideMarche;
	
	public StatsCoord(double[] mean, double[] variance, double[] stdDev, double textAverageLength, int tweetsInsideMarche) {
		
		super();
		this.mean = mean;
		this.variance = variance;
		this.stdDev = stdDev;
		this.textAverageLength = textAverageLength;
		this.tweetsInsideMarche = tweetsInsideMarche;
	}
	
	public double[] getMean() {
		return mean;
	}
	public void setMean(double[] mean) {
		this.mean = mean;
	}
	public double[] getVariance() {
		return variance;
	}
	public void setVariance(double[] variance) {
		this.variance = variance;
	}
	public double[] getStdDev() {
		return stdDev;
	}
	public void setStdDev(double[] stdDev) {
		this.stdDev = stdDev;
	}
	public double getTextAverageLength() {
		return textAverageLength;
	}
	public void setTextAverageLength(double textAverageLength) {
		this.textAverageLength = textAverageLength;
	}
	public int getTweetsInsideMarche() {
		return tweetsInsideMarche;
	}
	public void setTweetsInsideMarche(int tweetsInsideMarche) {
		this.tweetsInsideMarche = tweetsInsideMarche;
	}
}
