package model;

public class Controller{
	
	private static final int MAX_WETLANDS=80;
	
	//Relationships
	private Wetland [] wetlands;
	
	//Constructor
	public Controller(){
		wetlands=new Wetland [MAX_WETLANDS];
	}
	
	//Getters
	public Wetland [] getWetlands(){
		return wetlands;
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
	public String addWetland(String name, String picture, int area, int maintenance, double percentage, String access, String zone, String protection) {
		String out = "";
		
		int emptyPos= getEmptyPosition();

		if(emptyPos == -1){

			out = "There's not enough space. All wetlands have been added.";

		}else{ 

			wetlands[emptyPos] =  new Wetland (name, picture, area, maintenance, percentage, access, zone, protection);
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
	public void addSpeciesToWetland(String wetlandName, String name, String scientificName, int option, String migratory){
		
		SpeciesType type = null;
		
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
	public void addEventToWetland(String type, String host, String description, double price, int day, int month, int year){
		
		String wetlandName = "";
	
		Event event = new Event(type, host, description, price, day, month, year);

		if(findWetland(wetlandName)!=-1){
			wetlands[findWetland(wetlandName)].addEvent(event);
		}
	}
	
	
	/** This method prints the basic information for all wetlands
	*@return out : list of information regarding all wetlands
	*/
	public String getAllWetlands(){
		String out = "";
		for(int i = 0 ; i <MAX_WETLANDS; i++){
			if(wetlands[i] != null){
				out+=wetlands[i].toString()+wetlands[i].getAllSpecies()+wetlands[i].getNumberSpecies();
			}
		}
		return out;
	}
	
	
	/**This method searches for the wetland with the least population of flora
	*@return out : name of the wetland with least flora
	*/
	public String leastFlora(){
		
		String out = "";
		int least = 1000000;
		int position = -1;
		
		for(int i=0; i<MAX_WETLANDS; i++){
			if(wetlands[i]!=null){
				if(wetlands[i].getFlora()<least){
					least=wetlands[i].getFlora();
					position=i;
				}
			}
		}
		if (position!=-1){
			out=wetlands[position].getName();
		}else{
			out="No species found\n";
		}
		return out;
	}
	
	
	/**This method searches for the wetland with the most population of animals
	*@return out : name of the wetland with the most animals
	*/
	public String mostAnimals(){
		
		String out = "";
		int most = 0;
		int position = -1;
		
		for(int i=0; i<MAX_WETLANDS; i++){
			if(wetlands[i]!=null){
				if(wetlands[i].getAnimals()>most){
					most=wetlands[i].getAnimals();
					position=i;
				}
			}
		}
		if (position!=-1){
			out=wetlands[position].getName();
		}else{
			out="No species found\n";
		}
		return out;
	}
	
	
	/** This method allows to put all wetlands containing certain species together
	*@param name : name of the species being searched
	*@return out : all wetlands containing the species
	*/
	public String findWetlandWithSpecies(String name){
		String out="";
		for(int i=0; i<MAX_WETLANDS; i++){
			if(wetlands[i]!=null){
				out+=wetlands[i].findSpecies(name)+". ";
			}
		}
		return out;
	}
	
	
	/**This method gets the number of maintenances in each wetland
	*@return out : Name of wetland with its number of maintenances per year
	*/
	public String getAllMaintenances(){
		String out="";
		for(int i=0; i<MAX_WETLANDS; i++){
			if(wetlands[i]!=null){
				out+="Wetland: "+wetlands[i].getName()+"\nNumber of maintenances: "+wetlands[i].getMaintenance()+" per year\n";
			}
		}
		return out;
	}
	
}