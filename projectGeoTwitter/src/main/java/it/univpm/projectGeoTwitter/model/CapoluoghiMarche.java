package it.univpm.projectGeoTwitter.model;

public class CapoluoghiMarche {

	private Geo Ancona;
	private Geo AscoliPiceno;
	private Geo Fermo;
	private Geo Macerata;
	private Geo PesaroEUrbino;
	
	public CapoluoghiMarche() {
		
		Ancona = new Geo(13.511, 43.5991);
		AscoliPiceno = new Geo(13.6312, 42.8481);
		Fermo = new Geo(13.7242, 43.1656);
		Macerata = new Geo(13.442, 43.2991);
		PesaroEUrbino = new Geo(12.8912, 43.9045);
	}
	
	
	public Geo getAncona() {
		return Ancona;
	}
	public Geo getAscoliPiceno() {
		return AscoliPiceno;
	}
	public Geo getFermo() {
		return Fermo;
	}
	public Geo getMacerata() {
		return Macerata;
	}
	public Geo getPesaroEUrbino() {
		return PesaroEUrbino;
	}
	
	
	/*
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
	*/
}
