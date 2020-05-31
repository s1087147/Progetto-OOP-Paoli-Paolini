package it.univpm.projectGeoTwitter.model;

public class CapoluoghiMarche {

	private Geo Ancona;
	private Geo AscoliPiceno;
	private Geo Fermo;
	private Geo Macerata;
	private Geo PesaroEUrbino;
	
	public CapoluoghiMarche() {						//Da chiamare istanziando un oggetto nella classe in cui si calcolano le stats
		Ancona.setNome("Ancona");					//Nomi probabilmente non necessari in realtà
		Ancona.setLongit(13.511);
		Ancona.setLatit(43.5991);
		AscoliPiceno.setNome("Ascoli Piceno");
		AscoliPiceno.setLongit(13.6312);
		AscoliPiceno.setLatit(42.8481);
		Fermo.setNome("Fermo");					
		Fermo.setLongit(13.7242);
		Fermo.setLatit(43.1656);
		Macerata.setNome("Macerata");					
		Macerata.setLongit(13.442);
		Macerata.setLatit(43.2991);
		PesaroEUrbino.setNome("Pesaro e Urbino");					
		PesaroEUrbino.setLongit(12.8912);
		PesaroEUrbino.setLatit(43.9045);
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
