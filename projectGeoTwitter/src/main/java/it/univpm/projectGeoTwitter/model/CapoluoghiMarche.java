package it.univpm.projectGeoTwitter.model;

/**
 * Modello da cui richiedere le coordinate dei 5 capoluoghi marchigiani.
 * @author Francesco Paoli Leonardi
 */
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
	
	
	public Geo getancona() {
		return Ancona;
	}
	public Geo getascolipiceno() {
		return AscoliPiceno;
	}
	public Geo getfermo() {
		return Fermo;
	}
	public Geo getmacerata() {
		return Macerata;
	}
	public Geo getpesaroeurbino() {
		return PesaroEUrbino;
	}
}
