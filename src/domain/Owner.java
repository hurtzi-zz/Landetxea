package domain;

import gui.StartWindow;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;




@SuppressWarnings("serial")
public class Owner extends Client implements Serializable  {
//	private String name="";
//	private String abizena = "";
//	private String login="";
//	private String password="";
//	private Boolean isOwner=true;
	private Integer tlfn = null;
	private String bankAccount = "";
	private Vector<RuralHouse> ruralHouses=new Vector<RuralHouse>();
	private Vector<Activity> activities = new Vector<Activity>();


	
	//jabea
	public Owner(Integer tlfn, String bankAccount,Vector<RuralHouse> ruralHousesBektorea,String name, String abizena, String login, String password,Boolean isOwner, Vector<RuralHouse> ruralFav){
		super(name,abizena,login,password,true, ruralFav);
		this.bankAccount=bankAccount;
		this.tlfn=tlfn;
	}
	
	
	public Integer getTlfn() {
		return tlfn;
	}

	public void setTlfn(Integer tlfn) {
		this.tlfn = tlfn;
	}


	public void setRuralHouses(Vector<RuralHouse> ruralHouses) {
		this.ruralHouses = ruralHouses;
	}
	

	/**
	 * This method returns the owner bank account number
	 * 
	 * @return The bank account number
	 */
	public String getBankAccount() {
		return this.bankAccount;
	}

	/**
	 * This method sets the owner account number 
	 * 
	 * @param bankAccount
	 *            bank account number
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	

	/**
	 * This method obtains an owner's(userId) rural houses 
	 * 
	 * @param userId
	 *            user key
	 * @return a vector of Rural Houses
	 */
	
	public Vector<RuralHouse> getRuralHouses() {
		return ruralHouses;
	}
	
	public RuralHouse addRuralHouse(int houseNumber, String description, String city) {
     RuralHouse rh=new RuralHouse( houseNumber,  this,  description,  city);
	 ruralHouses.add(rh);
	 return rh;
	 
	}
	
	public void addRuralHouse(RuralHouse rh){
		System.out.println("gehitzeko etxea: "+rh);
		System.out.println(this.getName() + " da");
		this.ruralHouses.add(rh);
	}

	public RuralHouse getRHByNumber(int num){
		Iterator it = ruralHouses.iterator();
		RuralHouse test = null;
		while (it.hasNext()) {
			test = (RuralHouse) it.next();
			if (test.getHouseNumber()==num){
				return test;
			}
		}
		return null;
	}
	
	public Boolean deleteRH(RuralHouse rh){
		return ruralHouses.remove(rh);
	}
	
	public Vector<Activity> getActivities(){
		return activities;
	}
	
	public void appendActivity(Activity a){
		activities.addElement(a);
	}
	
//	public Vector<Activity> getOwnerActivities(){
//		return activities;
//	}
	
}