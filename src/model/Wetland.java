package model;

public class Wetland{
	private String name;
	private String picture;
	private int area;
	private int maintenance;
	private double percentage;
	private String access;
	private String zone;
	private String protection;

	private static final int MAX_SPECIES=10;
	private static final int MAX_EVENTS=10;
	
	//Associations
	private Species [] species;
	private Event [] events;
	
	//Constructor
	public Wetland(String name, String picture, int area, int maintenance, double percentage, String access, String zone, String protection){
		this.name=name;
		this.picture=picture;
		this.area=area;
		this.maintenance=maintenance;
		this.percentage=percentage;
		this.access=access;
		this.zone=zone;
		this.protection=protection;
		species=new Species[MAX_SPECIES];
		events=new Event[MAX_EVENTS];
	}
	
	/** This method checks if the event array has any space left
	*If there is return true, if there isn't return false
	*@return emptyPosition
	*/
	public boolean hasSpaceEvent(){
		
		boolean emptyPosition = false;
		
		for(int i=0; i < MAX_EVENTS && !emptyPosition;i++){
			if(events[i]== null){
				emptyPosition= true;
			}
		}
		
		return emptyPosition;
	}
	
	/** This method checks if the species array has any space left
	*If there is return true, if there isn't return false
	*@return emptyPosition
	*/
	public boolean hasSpaceSpecies(){
		
		boolean emptyPosition = false;
		
		for(int i=0; i < MAX_SPECIES && !emptyPosition;i++){
			if(species[i]== null){
				emptyPosition= true;
			}
		}
		
		return emptyPosition;
	}
	
	/** This method gets the position of the first empty space in the EVENT array
	*If there's not enough space, return -1
	*@return position
	*/
	public int getEmptyPositionEvent(){
		boolean emptyPosition = false;
		
		int position= -1;

		for(int i=0; i < MAX_EVENTS && !emptyPosition; i++){
			if(events[i]==null){
				emptyPosition = true;
				position = i;
			}
		}
		
		return position;
	}
	
	/** This method gets the position of the first empty space in the SPECIES array
	*If there's not enough space, return -1
	*@return position
	*/
	public int getEmptyPositionSpecies(){
		boolean emptyPosition = false;
		
		int position= -1;

		for(int i=0; i < MAX_SPECIES && !emptyPosition; i++){
			if(species[i]==null){
				emptyPosition = true;
				position = i;
			}
		}
		
		return position;
	}
	
	/** This method adds an event object to the first empty position of the event array
	@param pEvent : object event
	*/
	public void addEvent(Event pEvent){
		
		int position = getEmptyPositionEvent();
        events[position]=pEvent;
    }
	
	/** This method adds a species object to the first empty position of the species array
	*@param pSpecies : object species
	*/
	public void addSpecies(Species pSpecies){
		
		int position = getEmptyPositionSpecies();
        species[position]=pSpecies;
    }
	
	/** This method prints the basic information for all species
	*@return : allSpecies : list of information regarding all species of certain wetland
	*/
	public String getAllSpecies(){
		String allSpecies="";
		for(int i=0 ; i <MAX_SPECIES; i++){
			if(species[i] != null){
				allSpecies+=(species[i].toString()+"\n");
			}
		}
		return allSpecies;
	}
	
	/** This method counts the number of flora species in a wetland
	*@return counter : number of flora in a wetland
	*/
	public int getFlora(){
		
		int counter=0;
		
		for(int i=0; i<MAX_SPECIES; i++){
			if(species[i]!=null){
				if(species[i].getType().equals(SpeciesType.LAND_FLORA) || species[i].getType().equals(SpeciesType.WATER_FLORA)){
					counter++;
				}
			}
		}
		return counter;
	}
	
	/** This method counts the number of animal species in a wetland
	*@return counter : number of animals in a wetland
	*/
	public int getAnimals(){
		
		int counter=0;
		
		for(int i=0; i<MAX_SPECIES; i++){
			if(species[i]!=null){
				if(species[i].getType().equals(SpeciesType.MAMMAL)){
					counter++;
				}else if(species[i].getType().equals(SpeciesType.BIRD)){
					counter++;
				}else if(species[i].getType().equals(SpeciesType.AQUATIC)){
					counter++;
				}
			}
		}
		return counter;
	}
	
	/**This method counts the number of species by type in a wetland
	*/
	public String getNumberSpecies(){
		
		int landFlora=0;
		int waterFlora=0;
		int mammal=0;
		int bird=0;
		int aquatic=0;
		
		for(int i=0; i<MAX_SPECIES; i++){
			if(species[i]!=null){
				if(species[i].getType().equals(SpeciesType.LAND_FLORA)){
					landFlora++;
				}else if(species[i].getType().equals(SpeciesType.WATER_FLORA)){
					waterFlora++;
				}else if(species[i].getType().equals(SpeciesType.MAMMAL)){
					mammal++;
				}else if(species[i].getType().equals(SpeciesType.BIRD)){
					bird++;
				}else if(species[i].getType().equals(SpeciesType.AQUATIC)){
					aquatic++;
				}
			}
		}
		return "***Number of species by type***\n"+
	"Land Flora: "+landFlora+"\n"+ 
	"Water Flora: "+waterFlora+"\n"+ 
	"Mammal: "+mammal+"\n"+ 
	"Bird: "+bird+"\n"+ 
	"Aquatic: "+aquatic+"\n";
	}
	
	
	/** This method looks for certain species and returns the wetland that has it
	*/
	public String findSpecies(String name){
		String wetlandName="";
		boolean flag=false;
		for(int i=0; i<MAX_SPECIES; i++){
			if(species[i]!=null && name.equals(species[i].getName())){
				wetlandName=getName();
			}
		}
		return wetlandName;
	}
	
	
	
	//Getters
	public String getName(){
		return name;
	}
	public String getPicture(){
		return picture;
	}
	public int getArea(){
		return area;
	}
	public int getMaintenance(){
		return maintenance;
	}
	public double getPercentage(){
		return percentage;
	}
	public String getAccess(){
		return access;
	}
	public String getZone(){
		return zone;
	}
	public String getProtection(){
		return protection;
	}
	
	//Setters
	public void setName(String name){
		this.name=name;
	}
	public void setPicture(String picture){
		this.picture=picture;
	}
	public void setArea(int area){
		this.area=area;
	}
	public void setMaintenance(int maintenance){
		this.maintenance=maintenance;
	}
	public void setPercentage(double percentage){
		this.percentage=percentage;
	}
	public void setAccess(String access){
		this.access=access;
	}
	public void setZone(String zone){
		this.zone=zone;
	}
	public void setProtection(String protection){
		this.protection=protection;
	}
	
	public String toString(){
		return "\n***Wetland***\n" +
		"Wetland name: " + name + "\n"   + 
		"Path for picture: " + picture + "\n" +
		"Area: " + area + "km2\n" +
		"Number of maintenances: " + maintenance + " per year\n" +
		"Fulfillment percentage: " + percentage + "%\n" +
		"Type of access: " + access + "\n" +
		"Zone: " + zone + "\n" +
		"Protection: " + protection + "\n";
	}
	
	
}