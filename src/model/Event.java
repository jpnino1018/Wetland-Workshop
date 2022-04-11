package model;
 
public class Event{
	
	private String type;
	private String host;
	private String description;
	private double price;
	
	//Associations
	private Date date;

	//Constructor
	public Event(String type, String host, String description, double price, int day, int month, int year){
		this.type=type;
		this.host=host;
		this.description=description;
		this.price=price;
		this.date=new Date(day, month, year);
	}
	
	//Getters
	public String getType(){
		return type;
	}
	public String getHost(){
		return host;
	}
	public String getDescription(){
		return description;
	}
	public double getPrice(){
		return price;
	}
	
	public Date getDate(){
		return date;
	}
	
	//Setters
	public void setType(String type){
		this.type=type;
	}
	public void setHost(String host){
		this.host=host;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public void setPrice(double price){
		this.price=price;
	}
	
	public void setDate(Date date){
		this.date=date;
	}
	
	
	
	public String toString(){
		return "Event Type: " + type + "\n" + "Host: " + host + "\n" + "Description: " + description + "\n" + "Price: " + price + "\n" + "Date: " + date;
	}
}