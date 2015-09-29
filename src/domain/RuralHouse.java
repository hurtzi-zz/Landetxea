package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class RuralHouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int houseNumber;
	private String description;
	private Owner owner;
	private String city;
	public Vector<Offer> offers = new Vector<Offer>();
	public LinkedList<Comment> comments = new LinkedList<Comment>();
	private Vector<Activity> activities = new Vector<Activity>();

	public RuralHouse() {
		super();
	}

	public RuralHouse(int houseNumber, Owner owner, String description,
			String city) {
		this.houseNumber = houseNumber;
		this.description = description;
		this.owner = owner;
		this.city = city;
		offers = new Vector<Offer>();
		comments = new LinkedList<Comment>();
	}

	public Vector<Offer> getOffers() {
		return this.offers;
	}
	
	public void setOffers(Vector<Offer> offers) {
		this.offers = offers;
	}
	
	
	public LinkedList<Comment> getComments() {
		return this.comments;
	}

	

	public void setComments(LinkedList<Comment> comments) {
		this.comments = comments;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Vector<Offer> getOffer() {
		return offers;
	}

	public String toString() {
		return this.houseNumber + ": " + this.city;
	}

	public Offer createOffer(Date firstDay, Date lastDay, float price) {
		Offer off = new Offer(/* offerNumber, */this, firstDay, lastDay, price);
		offers.add(off);
		return off;
	}

//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + houseNumber;
//		return result;
//	}
//
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		RuralHouse other = (RuralHouse) obj;
//		if (houseNumber != other.houseNumber)
//			return false;
//		return true;
//	}

	public Vector<Offer> getOffers(Date firstDay, Date lastDay) {

		Vector<Offer> availableOffers = new Vector<Offer>();
		Iterator<Offer> e = offers.iterator();
		Offer offer;
		while (e.hasNext()) {
			offer = e.next();
			if ((offer.getFirstDay().compareTo(firstDay) >= 0)
					&& (offer.getLastDay().compareTo(lastDay) <= 0)
					&& (offer.getBooking() == null))
				availableOffers.add(offer);
		}
		return availableOffers;

	}

	public Offer findOffer(Date firstDay, Date lastDay) {

		Iterator<Offer> e = offers.iterator();
		Offer offer = null;
		while (e.hasNext()) {
			offer = e.next();
			if ((offer.getFirstDay().compareTo(firstDay) == 0)
					&& (offer.getLastDay().compareTo(lastDay) == 0)
					&& (offer.getBooking() == null))
				return offer;
		}
		return null;

	}

	public Offer overlapsWith(Date firstDay, Date lastDay) {

		Iterator<Offer> e = offers.iterator();
		Offer offer = null;
		while (e.hasNext()) {
			offer = e.next();
			if ((offer.getFirstDay().compareTo(lastDay) < 0)
					&& (offer.getLastDay().compareTo(firstDay) > 0))
				return offer;
		}
		return null;

	}

	public void imprimatu() {
		String s = this.houseNumber + "," + this.description + "," + this.city;
		System.out.println(s);
	}

	public String goString() {
		String s = this.houseNumber + "," + this.description + "," + this.city;
		return s;
	}

	public Offer addOffer(RuralHouse rh, Date d1, Date d2, Float prezioa) {
		Offer of = new Offer(rh, d1, d2, prezioa);
		offers.add(of);
		return of;

	}

	public void addOffer(Offer of) {
		this.offers.add(of);

	}

	public Comment addComent(Client cli, int botoa, String comme) {
		Comment com = new Comment(cli, botoa, comme);
		comments.add(com);
		return com;

	}

	public void addComent(Comment co) {
		this.comments.add(co);
	}
	
	public void deleteAllComents() {
		this.comments.removeAll(this.comments);
	}
	
	public Vector<Activity> getActivities(){
		return activities;
	}

	public void appendActivity(Activity a){
		activities.addElement(a);
	}
	
	public Boolean removeOferta(Offer o){
		return offers.remove(o);
	}
	
}
