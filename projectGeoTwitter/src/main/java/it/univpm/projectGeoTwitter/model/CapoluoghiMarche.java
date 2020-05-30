package it.univpm.projectGeoTwitter.model;

public class CapoluoghiMarche {

	private static final String[] capoluoghi = {"Ancona", "Ascoli Piceno", "Fermo", "Macerata", "Pesaro e Urbino"};
	private static final double[] capoluoghiLongit = {13.511, 13.6312, 13.7242, 13.442, 12.8912};
	private static final double[] capoluoghiLatit = {43.5991, 42.8481, 43.1656, 43.2991, 43.9045};
	
	public static String[] getCapoluoghi() {
		return capoluoghi;
	}
	public static double[] getCapoluoghiLongit() {
		return capoluoghiLongit;
	}
	public static double[] getCapoluoghiLatit() {
		return capoluoghiLatit;
	}
	
}
