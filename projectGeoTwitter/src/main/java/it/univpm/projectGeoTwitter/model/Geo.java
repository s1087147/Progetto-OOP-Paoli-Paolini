package it.univpm.projectGeoTwitter.model;

public class Geo {

	private String nome;
	private double longit;
	private double latit;
	
	public Geo(String nome, double longit, double latit) {
		
		super();
		this.nome = nome;
		this.longit = longit;
		this.latit = latit;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getLongit() {
		return longit;
	}
	public void setLongit(double longit) {
		this.longit = longit;
	}
	public double getLatit() {
		return latit;
	}
	public void setLatit(double latit) {
		this.latit = latit;
	}
}
