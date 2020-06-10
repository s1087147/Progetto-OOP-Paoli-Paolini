package it.univpm.projectGeoTwitter.model;

/**
 * Modello per i metadati.
 * @author Davide Paolini
 */
public class TwitterMetadata {
	/**
	 * Nome del dato.
	 */
	String name;
	
	/**
	 * Descrizione del dato.
	 */
	String description;
	
	/**
	 * Tipo con cui viene rappresentato il dato.
	 */
	String type;
	
	public TwitterMetadata(String name, String description, String type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}
}