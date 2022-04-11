package model;

public class Species{
	
	private String name;
	private String scientificName;
	private SpeciesType type;
	private String migratory;
	
	//Constructor
	public Species(String name, String scientificName, SpeciesType type, String migratory){
		this.name=name;
		this.scientificName=scientificName;
		this.type=type;
		this.migratory=migratory;
	}
	
	//Getters
	public String getName(){
		return name;
	}
	public String getScientificName(){
		return scientificName;
	}
	public SpeciesType getType(){
		return type;
	}
	public String getMigratory(){
		return migratory;
	}
	
	//Setters
	public void setName(String name){
		this.name=name;
	}
	public void setScientificName(String scientificName){
		this.scientificName=scientificName;
	}
	public void setMigratory(String migratory){
		this.migratory=migratory;
	}
	
	public String toString(){
		return "***Species in this wetland***\nSpecies Name: " + name + "\n" + "Scientific Name: " + scientificName + "\n" + "Type: " + type + "\n" + "Migratory: " + migratory + "\n";
	}
}