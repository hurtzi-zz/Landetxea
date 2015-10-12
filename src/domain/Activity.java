package domain;

import java.io.Serializable;

public class Activity implements Serializable{
	private String name;
	private String description;
	private int cantity;
	private Boolean dayOrNight;
	private Owner owner;
	
	public Activity(String n, String d, int c, Boolean dn, Owner o){
		
		if(o != null){
			name = n;
			description = d;
			cantity = c;
			dayOrNight = dn;
			owner = o;
		}else {
		}
		
	}
	

	
	public Activity(String izena) {
		// TODO Auto-generated constructor stub
	}



	public Owner getOwner() {
		return owner;
	}



	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getCantity(){
		return cantity;
	}
	
	public Boolean getDayOrNight(){
		return dayOrNight;
	}
}
