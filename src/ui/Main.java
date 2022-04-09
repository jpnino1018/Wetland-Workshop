package ui;

import model.Controller;

import java.util.Scanner;

public class Main{

	private Scanner sc;
	private Controller control;
	
	public Main(){
		control = new Controller("Na");
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args){
			
		Main ppal= new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
	}
	
	
	/** This method shows the menu for the app and gives the user a chance to choose from multiple options.
	*@return option
	*/
	public int showMenu(){
		int option=0;
		System.out.println(
		"Welcome\n"+
		"To create a new Wetland press 1\n"+
		"To add a species to certain wetland press 2\n"+
		"To add an event to certain wetland press 3\n"+
		"To show all Wetlands press 4\n"+
		"To exit press 0/n"
		);
		option=sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	
	/** This method executes a different proccess depending on the user's choice.
	*@param option
	*/
	public void executeOperation(int option){
		switch(option) {
		case 0:
			System.out.println("Closing app. Goodbye!");
			break;
		case 1:
			createWetland();
			break;	
		case 2:
			createSpecies();
			break;
		case 3:
			createEvent();
			break;
		case 4:
			showWetland();
			break;
		default:
			System.out.println("Error, Please type a valid option");
		
		}		
	}
	
	
	/** This method asks for the basic information in order to create a wetland
	*/
	public void createWetland(){
		if(control.hasSpace()==true){
			System.out.println("Creating a WETLAND");
			String name;
			System.out.println("Set a name");
			name=sc.next();
			
			String picture;
			System.out.println("Set path for picture");
			picture=sc.next();
			
			int area;
			System.out.println("Set area in km2");
			area=sc.nextInt();
			
			double percentage;
			System.out.println("Set the percentage of acomplishment");
			percentage=sc.nextDouble();
			
			String access;
			System.out.println("Is the wetland Public or Private?");
			access=sc.next();
			
			String zone;
			System.out.println("Is the wetland located in a Rural or an Urban zone?");
			zone=sc.next();
			
			String protection;
			System.out.println("Is the wetland Protected or Vulnerable?");
			protection=sc.next();
			
			control.addWetland(name, picture, area, percentage, access, zone, protection);
		} else {
			
			System.out.println("No space left to add more wetlands");
		}
	}
	
	
	/** This method asks for the basic information in order to create a species in certain wetland
	*/
	public void createSpecies(){
		System.out.println("To create a new species, enter the name of the wetland it will be added to");
		String wetlandName=sc.next();
		
		String name, scientificName, migratory;
		int option;
		
		int index=control.findWetland(wetlandName);
		if (index==-1){
			System.out.println("There is no wetland by that name");
		}else{
			System.out.println("Enter the name of the species");
			name=sc.next();
			
			System.out.println("Enter the scientific name for the species");
			scientificName=sc.next();
			
			System.out.println("Type the correct number for the species type\n"+
			"1) Land Flora\n"+
			"2) Water Flora\n"+
			"3) Mammal\n"+
			"4) Bird\n"+
			"5) Aquatic\n");
			
			option=sc.nextInt();
			
			System.out.println("Is the species migratory?");
			migratory=sc.next();
			
			control.addSpeciesToWetland(name, scientificName, option, migratory);
		}
	}

	
	
	/** This method asks for the basic information in order to create an event in certain wetland
	*/
	public void createEvent(){
		System.out.println("To create a new event, enter the name of the wetland it will be added to");
		String wetlandName=sc.next();
		
		String type, host, description;
		double price;
		
		
		int index=control.findWetland(wetlandName);
		if (index==-1){
			System.out.println("There is no wetland by that name");
		}else{
			System.out.println("Enter occasion or type of event");
			type=sc.next();
			
			System.out.println("Enter name of the host");
			host=sc.next();
			
			System.out.println("Enter a short description");
			description=sc.next();
			
			System.out.println("Enter total price of the event");
			price=sc.nextInt();
			
			System.out.println("Day of the event");
			int day=sc.nextInt();
			System.out.println("Month");
			int month=sc.nextInt();
			System.out.println("Year");
			int year=sc.nextInt();
			
			Date date = new Date(day, month, year);
			
			control.addEventToWetland(type, host, description, price, date);
		}
	}
	
	/** This method shows information for all wetlands
	*/
	public void showWetland(){
		control.getWetlands();
	}
}