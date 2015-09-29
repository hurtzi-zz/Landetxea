package businessLogic;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.util.Vector;

import dataAccess.DataAccessCommon;
import dataAccess.DataAccessInterface;
import domain.Activity;
import domain.Admin;
import domain.Booking;
import domain.Client;
import domain.Offer;
import domain.Owner;
import domain.RuralHouse;
import exceptions.BadDates;
import exceptions.DB4oManagerCreationException;
import exceptions.OfferCanNotBeBooked;
import exceptions.OverlappingOfferExists;

public class FacadeImplementation extends UnicastRemoteObject implements ApplicationFacadeInterface, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	Vector<Owner> owners;
	Vector<Client> clients;
	Vector<RuralHouse> ruralHouses;
	DataAccessInterface dB4oManager;

	public FacadeImplementation() throws RemoteException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, DB4oManagerCreationException {

	}

	/**
	 * This method creates an offer with a house number, first day, last day and
	 * price
	 * 
	 * @param House
	 *            number, start day, last day and price
	 * @return the created offer, or null, or an exception
	 */
	public Offer createOffer(RuralHouse ruralHouse, Date firstDay,
			Date lastDay, float price) throws OverlappingOfferExists, BadDates,
			RemoteException, Exception {
		if (firstDay.compareTo(lastDay) >= 0)
			throw new BadDates();
		ruralHouses = null;
		owners = null;
		boolean b = dB4oManager.existsOverlappingOffer(ruralHouse, firstDay,
				lastDay); // The ruralHouse object in the client may not be
							// updated
		if (!b)
			return dB4oManager
					.createOffer(ruralHouse, firstDay, lastDay, price);
		return null;
	}

	/**
	 * This method creates a book with a corresponding parameters
	 * 
	 * @param First
	 *            day, last day, house number and telephone
	 * @return a book
	 */
	public Booking createBooking(RuralHouse ruralHouse, Date firstDate,
			Date lastDate, String bookTelephoneNumber)
			throws OfferCanNotBeBooked {
		ruralHouses = null;
		owners = null;
		return dB4oManager.createBooking(ruralHouse, firstDate, lastDate,
				bookTelephoneNumber);
	}

	/**
	 * This method existing owners
	 * 
	 */
	public Vector<Owner> getOwners() throws RemoteException, Exception {

		if (owners != null) {
			System.out
					.println("Owners obtained directly from business logic layer");
			return owners;
		} else
			return owners = dB4oManager.getOwners();
	}
	
	public Vector<Client> getClients() throws RemoteException, Exception {

		if (clients != null) {
			System.out
					.println("Clients obtained directly from business logic layer");
			return clients;
		} else
			return clients = dB4oManager.getClients();
	}

	public Vector<RuralHouse> getAllRuralHouses() throws RemoteException,
			Exception {

		if (ruralHouses != null) {
			System.out
					.println("RuralHouses obtained directly from business logic layer");
			return ruralHouses;
		} else
			return ruralHouses = dB4oManager.getAllRuralHouses();

	}

	public void close() throws RemoteException {
		try{
			dB4oManager.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void setDataAccess(DataAccessInterface dai) throws RemoteException {
		dB4oManager = dai;
		// TODO Auto-generated method stub

	}

	public Client verifyLogin(String login, String pass) throws RemoteException {
		return DataAccessCommon.getInstance().verifyLogin(login, pass);
	}

	public boolean verifyLoginName(String login) throws RemoteException {
		return DataAccessCommon.getInstance().verifyLoginName(login);
	}

	public boolean createClient(String Izena, String Abizena, String login,
			String pasahitza, boolean isOwner) throws RemoteException {
		return DataAccessCommon.getInstance().createClient(Izena, Abizena,
				login, pasahitza, true);
	}

	public boolean createOwner(Integer telefonoa, String bank, String Izena,
			String Abizena, String login, String pasahitza)
			throws RemoteException {
		return DataAccessCommon.getInstance().createOwner(telefonoa, bank,
				Izena, Abizena, login, pasahitza);

	}

	public boolean saveOffer(RuralHouse rh, Date d1, Date d2, Float prezioa) {
		return DataAccessCommon.getInstance().saveOffer(rh, d1, d2, prezioa);
	}

	public Owner getOwner(Client c) throws RemoteException {
		return DataAccessCommon.getInstance().getOwner(c);
	}

	// public void updateOwner(Owner del, Owner add) throws RemoteException{
	// DataAccessCommon.getInstance().updateOwner(del,add);
	// }
	public Vector<Offer> getOffers(Date firstDay, Date lastDay)
			throws RemoteException {
		return DataAccessCommon.getInstance().getOffers(firstDay, lastDay);
	}

	public Boolean saveRuralHouse(Integer ze, String hi, String de, Owner o)
			throws RemoteException {
		return DataAccessCommon.getInstance().saveRuralHouse(ze, hi, de, o);
	}

	public Boolean editRuralHouse(String hi, String de, Owner o, RuralHouse rh)
			throws RemoteException {
		return DataAccessCommon.getInstance().editRuralHouse(hi, de, o, rh);
	}

	public Boolean deleteRuralHouse(Owner o, RuralHouse rh)
			throws RemoteException {
		return DataAccessCommon.getInstance().deleteRuralHouse(o, rh);
	}
	
    public Owner clienToOwner(Client c) throws RemoteException, Exception {
		return DataAccessCommon.getInstance().clienToOwner(c);
	}

	public Owner clientToOwner(Client t) throws RemoteException, Exception {

		return DataAccessCommon.getInstance().clienToOwner(t);
	}

	public Vector<RuralHouse> ownerBektoreaBueltatu(String login)
			throws RemoteException, Exception {
		return DataAccessCommon.getInstance().bektoreaLortu(login);
	}

	public RuralHouse rhBuleta(String city) {
		return DataAccessCommon.getInstance().rhBuleta(city);
	}

	public boolean VerifyOffer(RuralHouse ruralHouse, Date firstDay,
			Date lastDay) {
		return DataAccessCommon.getInstance().VerifyOffer(ruralHouse, firstDay,
				lastDay);
	}

	public Vector<Offer> findOffer(Date firstDay, Date lastDay) {
		return DataAccessCommon.getInstance().findOffer(firstDay, lastDay);
	}

	public Owner ownerBuelta(String login) throws RemoteException, Exception {
		return DataAccessCommon.getInstance().ownerBuelta(login);
	}

	public Vector<RuralHouse> SarchByCity(String city) throws RemoteException,
			Exception {
		return DataAccessCommon.getInstance().SarchByCity(city);
	}

	public Boolean updateClient(Client c) throws RemoteException {
		return DataAccessCommon.getInstance().updateClient(c);
	}

	public Vector<RuralHouse> SarchByOwner(String LoginName)
			throws RemoteException, Exception {
		return DataAccessCommon.getInstance().SarchByOwner(LoginName);
	}
	
	//urtzi 3.itera
	public RuralHouse addComment(Client c, int botua, String kom, RuralHouse rh) throws RemoteException, Exception {
		return DataAccessCommon.getInstance().addComment(c,botua, kom,rh);	
	}
	
    public Boolean updateHouse(RuralHouse rh) throws RemoteException, Exception{
		return DataAccessCommon.getInstance().updateHouse(rh);	
	}

    public Boolean deleteAllCom(RuralHouse rh) throws RemoteException, Exception{
  		return DataAccessCommon.getInstance().deleteAllCom(rh);	
  	}
    
    public Boolean deleteCom(RuralHouse rh,int i) throws RemoteException, Exception{
  		return DataAccessCommon.getInstance().deleteCom(rh,i);	
  	}

    public int getFreeNumber() throws RemoteException, Exception{
    	return DataAccessCommon.getInstance().getFreeNumber();
    }
    
    public Boolean createActivity(String izena, String deskribapena, int kop, Boolean egunez, Owner owner) throws RemoteException, Exception{
    	return DataAccessCommon.getInstance().createActivity(izena, deskribapena, kop, egunez, owner);
    }
	
    public Vector<Activity> getOwnerActivities(Owner o) throws RemoteException, Exception{
    	return DataAccessCommon.getInstance().getOwnerActivities(o);
    }
    
    public Vector<Activity> getHouseActivities(RuralHouse rh) throws RemoteException, Exception{
    	return DataAccessCommon.getInstance().getHouseActivities(rh);
    }
    
    public Boolean addActivity(Activity a, RuralHouse rh) throws RemoteException, Exception{
    	return DataAccessCommon.getInstance().addActivity(a, rh);
    }
    
    public Vector<Offer> OfertakBueltatu(String Login) throws RemoteException, Exception{
		return DataAccessCommon.getInstance().OfertakBueltatu(Login);
	}
    
    public Offer offerBuelta(RuralHouse rh, Date d1, Date d2, Float price)throws RemoteException {
		return DataAccessCommon.getInstance().offerBuelta(rh, d1, d2, price);
	}
    
    public Boolean deleteOferta(RuralHouse rh, Offer o)throws RemoteException {
		return DataAccessCommon.getInstance().deleteOferta(rh,o);
	}
    
    public Vector<Offer> getOffersRH(RuralHouse rh, Date firstDay, Date lastDay) throws RemoteException, Exception{
		return DataAccessCommon.getInstance().getOffersRH(rh, firstDay, lastDay);
	}
    public  Boolean verifyAdmin(String log, String pass)throws RemoteException{
    	return DataAccessCommon.getInstance().verifyAdmin(log, pass);
    }
	
	public  Admin getAdmin(String log, String pass)throws RemoteException{
    	return DataAccessCommon.getInstance().getAdmin(log, pass);
    }
	public Boolean deleteOwner(Owner o)throws RemoteException{
		return DataAccessCommon.getInstance().deleteOwner(o);
	}
	 public Boolean deleteClient(Client o)throws RemoteException{
		 return DataAccessCommon.getInstance().deleteClient(o);
	 }
	 
	public Vector<Client> getClient() throws RemoteException {
		return DataAccessCommon.getInstance().getClient();
	}
	 
	 public Vector<Owner> getOwnerss() throws RemoteException {
			return DataAccessCommon.getInstance().getOwnerss();
		}
}
