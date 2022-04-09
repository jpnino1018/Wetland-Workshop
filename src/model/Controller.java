package model;

public class Controller{
	
	private String name;
	private String id;
	private static final int MAX_WETLANDS=80;
	
	//Relationships
	private Wetland [] wetlands;
	
	//Constructor
	public Controller(String id){
		this.name=name;
		this.id=id;
		wetlands=new Wetland [MAX_WETLANDS];
	}
	
	//Getters
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public Wetland [] getWetlands(){
		return wetlands;
	}
	
	
	//Setters
	public void setName(String name){
		this.name=name;
	}
	public void setId(String id){
		this.id=id;
	}
	
	
	/** This metod checks if the array has any space to insert an object
	*If there is true, else false
	*@return emptyPos
	*/
	public boolean hasSpace(){

		boolean emptyPos= false;
		for (int i=0; i<MAX_WETLANDS && !emptyPos; i++){

			if(wetlands[i] == null){
				emptyPos= true;
			}

		}
		return emptyPos;
	}
	
	
	/** This method gets the position of the first empty space.
	*If there's not an empty space, the system will return -1.
	*@return emptyPos
	*/
	public int getEmptyPosition(){
		
		boolean flag=false;
		int emptyPos=0;
		for (int i=0; i<MAX_WETLANDS && !flag; i++){

			if(wetlands[i] ==null){
				emptyPos=i;
				flag= true;
			}
		}
		
		if (flag=false){
			emptyPos = -1;
		}
		
		return emptyPos;
		
	}
	

	/** This method adds the basic information of a new wetland checking if there is any space
	*/
	public String addWetland(String name, String picture, int area, double percentage, String access, String zone, String protection) {
		String out = "";
		
		int emptyPos= getEmptyPosition();

		if(emptyPos == -1){

			out = "There's not enough space. All wetlands have been added.";

		}else{ 

			wetlands[emptyPos] =  new Wetland (name, picture, area, percentage, access, zone, protection);
			out = "Wetland has been added.";

		}

		return out;
		
	}
	
	
	/** This method searches for a wetland by using a name
	*@param name : Name of the wetland that needs to be found
	*@return index : position of the wetland in the array
	*/
	public int findWetland(String name){
		
		boolean flag=false;
		
		int index=-1;
		
		for(int i=0; i<MAX_WETLANDS && !flag; i++){
			
			if(wetlands[i]!=null && wetlands[i].getName().equals(name)){
			flag = true;
			index= i;
			}	
		}
		
		return index;
	}
	
	
	/** This method adds a species to certain wetland by locating its name
	*@param name : Name of the species
	*@param scientificName : Scientific name of the species
	*@param option : option chosen by the user to determine the type of species
	*@param migratory : if the species is migratory or not
	*/
	public void addSpeciesToWetland(String name, String scientificName, int option, String migratory){
		
		SpeciesType type = null;
		String wetlandName = "";
		
		switch(option){
			case 1:
				type = SpeciesType.LAND_FLORA;
				break;
			case 2:
				type = SpeciesType.WATER_FLORA;
				break;
			case 3:
				type = SpeciesType.MAMMAL;
				break;
			case 4:
				type = SpeciesType.BIRD;
				break;
			case 5:
				type = SpeciesType.AQUATIC;
				break;

		}
		
		Species species = new Species(name, scientificName, type, migratory);

		if(findWetland(wetlandName)!=-1){
			wetlands[findWetland(wetlandName)].addSpecies(species);
		}
	}
	
	
	/** This method adds an event to certain wetland by locating its name
	*@param type : Type of event
	*@param host : Name of the person hosting the event
	*@param description : Short description of the event
	*@param price : Total price of the event
	*@param Date : Date of the event
	*/
	public void addEventToWetland(String type, String host, String description, double price, Date date){
		
		String wetlandName = "";
	
		Event event = new Event(type, host, description, price, date);

		if(findWetland(wetlandName)!=-1){
			wetlands[findWetland(wetlandName)].addEvent(event);
		}
	}
	
	
	/** This method prints the basic information for all wetlands
	*/
	public void getAllWetlands(){
		for(int i =0 ; i <MAX_WETLANDS; i++){
			if(wetlands[i] != null){
				System.out.println(wetlands[i].toString());
			}
		}
		
	}
}