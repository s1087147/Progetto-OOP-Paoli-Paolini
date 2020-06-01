package it.univpm.projectGeoTwitter.model;

public class StatsCoord {

	private double[] mean;
	private double[] variance;
	private double[] stdDev;
	
	public StatsCoord(double[] mean, double[] variance, double[] stdDev) {
		
		super();
		this.mean = mean;
		this.variance = variance;
		this.stdDev = stdDev;
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
}
