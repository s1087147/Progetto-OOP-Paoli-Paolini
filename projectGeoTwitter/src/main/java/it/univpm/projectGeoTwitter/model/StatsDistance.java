package it.univpm.projectGeoTwitter.model;

public class StatsDistance {

	private double mean;
	private double variance;
	private double stdDev;
	private double max;
	private double min;
	
	public StatsDistance(double mean, double variance, double stdDev, double max, double min) {
		super();
		this.mean = mean;
		this.variance = variance;
		this.stdDev = stdDev;
		this.max = max;
		this.min = min;
	}
	
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getVariance() {
		return variance;
	}
	public void setVariance(double variance) {
		this.variance = variance;
	}
	public double getStdDev() {
		return stdDev;
	}
	public void setStdDev(double stdDev) {
		this.stdDev = stdDev;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
}
