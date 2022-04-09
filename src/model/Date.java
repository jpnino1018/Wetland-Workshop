package model;

public class Date{
	
	private int day;
	private int month;
	private int year;
	
	//Constructor
	public Date(int day, int month, int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	//Metodos Get
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}
	
	//Metodos Set
	public void setDay(int day){
		this.day=day;
	}
	public void setMonth(int month){
		this.month=month;
	}
	public void setYear(int year){
		this.year=year;
	}
	
	//ToString
	public String toString(){
		
		return day + "/" + month + "/" + year;
	}
}