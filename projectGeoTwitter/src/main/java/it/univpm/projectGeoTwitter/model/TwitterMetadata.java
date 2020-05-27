package it.univpm.projectGeoTwitter.model;

public class TwitterMetadata {
	String name;
	String description;
	String type;
	
	public TwitterMetadata(String name, String description, String type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}
	
	//GETTERS
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
