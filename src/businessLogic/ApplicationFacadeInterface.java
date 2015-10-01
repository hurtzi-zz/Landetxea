package businessLogic;



import java.io.Serializable;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;

import dataAccess.DataAccessCommon;
import dataAccess.DataAccessInterface;
import domain.Activity;
import domain.Admin;
import domain.Booking;
import domain.Client;
import domain.Offer;
import domain.Owner;
import domain.RuralHouse;
import exceptions.OfferCanNotBeBooked;

public interface ApplicationFacadeInterface extends Remote, Serializable {

	/**
	 * This method creates an offer with a house number, first day, last day and
	 * price
	 * 
	 * @param House
	 *            number, start day, last day and price
	 * @return None
	 */

	Offer createOffer(RuralHouse ruralHouse, Date firstDay, Date lastDay,
			float price) throws RemoteException, Exception;

	/**
	 * This method creates a book with a corresponding parameters
	 * 
	 * @param First
	 *            day, last day, house number and telephone
	 * @return a book
	 */
	Booking createBooking(RuralHouse ruralHouse, Date firstDay, Date lastDay,
			String telephoneNumber) throws RemoteException, OfferCanNotBeBooked;

	/**
	 * This method retrieves the existing owners
	 * 
	 * @return a Set of owners
	 */
	public Vector<Owner> getOwners() throws RemoteException, Exception;

	public Vector<Client> getClients() throws RemoteException, Exception;

	/**
	 * This method retrieves the existing rural houses
	 * 
	 * @return a Set of rural houses
	 */
	public Vector<RuralHouse> getAllRuralHouses() throws RemoteException,
			Exception;

	public void close() throws RemoteException;

	public void setDataAccess(DataAccessInterface dai) throws RemoteException;

	//
	public Client verifyLogin(String a, String b) throws RemoteException;

	//
	public boolean verifyLoginName(String a) throws RemoteException;

	public boolean createOwner(Integer telefonoa, String bank, String Izena,
			String Abizena, String login, String pasahitza)
			throws RemoteException;

	public boolean createClient(String Izena, String Abizena, String login,
			String pasahitza, boolean isOwner) throws RemoteException;

	/**
	 * Bezero bat emanda jabe klasea itzuliko du, datu guztiak izateko
	 * 
	 * @param c
	 * @return The (Owner)client + it's owner info
	 */
	public Owner getOwner(Client c) throws RemoteException;

	// public Vector<RuralHouse> getOwnerRuralHouses(Owner o);

	// public void updateOwner(Owner del, Owner add) throws RemoteException;
	// public Vector<RuralHouse> bektoreaLortu(String login);

	public Boolean saveRuralHouse(Integer ze, String hi, String de, Owner o)
			throws RemoteException;

	public Boolean editRuralHouse(String hi, String de, Owner o, RuralHouse rh)
			throws RemoteException;

	public Boolean deleteRuralHouse(Owner o, RuralHouse rh)
			throws RemoteException;

	public Owner clienToOwner(Client c) throws RemoteException, Exception;

	public Owner clientToOwner(Client t) throws RemoteException, Exception;

	public Vector<RuralHouse> ownerBektoreaBueltatu(String login)
			throws RemoteException, Exception;

	public Owner ownerBuelta(String login) throws RemoteException, Exception;

	public RuralHouse rhBuleta(String city) throws RemoteException;

	public boolean VerifyOffer(RuralHouse ruralHouse, Date firstDay,
			Date lastDay) throws RemoteException;

	public boolean saveOffer(RuralHouse rh, Date d1, Date d2, Float prezioa)
			throws RemoteException;

	public Vector<Offer> getOffers(Date firstDay, Date lastDay)
			throws RemoteException;

	public Vector<Offer> findOffer(Date firstDay, Date lastDay)
			throws RemoteException;

	public Vector<RuralHouse> SarchByCity(String city) throws RemoteException,
			Exception;

	public Boolean updateClient(Client c) throws RemoteException;

	public Vector<RuralHouse> SarchByOwner(String LoginName)
			throws RemoteException, Exception;

	// urtzi 3.itera
	public RuralHouse addComment(Client c, int botua, String kom, RuralHouse rh)
			throws RemoteException, Exception;

	public Boolean updateHouse(RuralHouse rh) throws RemoteException, Exception;

	public Boolean deleteCom(RuralHouse rh, int i) throws RemoteException,
			Exception;

	public Boolean deleteAllCom(RuralHouse rh) throws RemoteException,
			Exception;

	public int getFreeNumber() throws RemoteException, Exception;

	public Boolean createActivity(String izena, String deskribapena, int kop,
			Boolean egunez, Owner owner) throws RemoteException, Exception;

	public Vector<Activity> getOwnerActivities(Owner o) throws RemoteException,
			Exception;

	public Boolean addActivity(Activity a, RuralHouse rh)
			throws RemoteException, Exception;

	public Vector<Activity> getHouseActivities(RuralHouse rh)
			throws RemoteException, Exception;

	public Vector<Offer> OfertakBueltatu(String Login) throws RemoteException,
			Exception;

	public Offer offerBuelta(RuralHouse rh, Date d1, Date d2, Float price)
			throws RemoteException, Exception;

	public Boolean deleteOferta(RuralHouse rh, Offer o) throws RemoteException,
			Exception;

	public Vector<Offer> getOffersRH(RuralHouse rh, Date firstDay, Date lastDay)
			throws RemoteException, Exception;

	public Boolean verifyAdmin(String log, String pass) throws RemoteException;

	public Admin getAdmin(String log, String pass) throws RemoteException;

	public Boolean deleteOwner(Owner o) throws RemoteException;

	public Boolean deleteClient(Client o) throws RemoteException;
	
	
	public Vector<Client>  getClient() throws RemoteException;
	
	public Vector<Owner>  getOwnerss() throws RemoteException;

}