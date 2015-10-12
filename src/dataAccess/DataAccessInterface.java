package dataAccess;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import configuration.ConfigXML;
import dataAccess.DataAccessCommon.DB4oManagerAux;
import domain.Activity;
import domain.Booking;
import domain.Client;
import domain.Comment;
import domain.Offer;
import domain.Owner;
import domain.RuralHouse;
import exceptions.OfferCanNotBeBooked;
import exceptions.OverlappingOfferExists;

public interface DataAccessInterface extends Serializable{
	public Offer createOffer(RuralHouse ruralHouse, Date firstDay, Date lastDay, float price) throws RemoteException, Exception;

	public Booking createBooking(RuralHouse ruralHouse, Date firstDate, Date lastDate, String bookTelephoneNumber) throws OfferCanNotBeBooked;
	
	public Vector<Owner> getOwners() throws RemoteException, Exception;
	public Vector<Client> getClients()throws RemoteException, Exception;;
	public Vector<RuralHouse> getAllRuralHouses() throws RemoteException, Exception;
	
	public boolean existsOverlappingOffer(RuralHouse rh,Date firstDay, Date lastDa) throws RemoteException, Exception, OverlappingOfferExists;

	public void close() throws RemoteException, Exception;
	
	
	public void initializeDB() throws RemoteException, Exception;

	public boolean createClient(String name, String surname, String login, String password, boolean isOwner) throws RemoteException, Exception;

	public boolean createOwner(Integer tlfn, String bankAccount, String name, String abizena, String login, String password) throws RemoteException, Exception;

	public Boolean saveRuralHouse(Integer ze, String hi, String de, Owner o) throws RemoteException, Exception;

	public Boolean editRuralHouse(String hi, String de, Owner o, RuralHouse rh) throws RemoteException, Exception;

	public Boolean deleteRuralHouse(Owner o, RuralHouse rh) throws RemoteException, Exception;

	public boolean saveOffer(RuralHouse rh, Date d1, Date d2, Float prezioa) throws RemoteException, Exception;

	public void inprimatuEtxeakOwner(Owner ow) throws RemoteException, Exception;

	public Boolean verifyLoginName(String log) throws RemoteException, Exception;

	public boolean VerifyOffer(RuralHouse ruralHouse, Date firstDay, Date lastDay) throws RemoteException, Exception;
	
	public Vector<Offer> getOffers(Date firstDay, Date lastDay) throws RemoteException, Exception;

	public Vector<Offer> findOffer(Date firstDay, Date lastDay) throws RemoteException, Exception;

	public Vector<RuralHouse> SarchByCity(String city) throws RemoteException, Exception;

	public Boolean updateClient(Client c) throws RemoteException, Exception;

	public void ImpgetAllRuralHouses(Vector<RuralHouse> bek) throws RemoteException, Exception;

	public String toString();

	public Owner getOwner(Client c) throws RemoteException, Exception;

	public Owner clienToOwner(Client t) throws RemoteException, Exception;

	public Vector<RuralHouse> bektoreaLortu(String login) throws RemoteException, Exception;

	public Owner ownerBuelta(String login) throws RemoteException, Exception;

	public RuralHouse rhBuleta(String city) throws RemoteException, Exception;

	public Vector<RuralHouse> SarchssByOwner(Owner o) throws RemoteException, Exception;

	public Vector<RuralHouse> SarchByOwner(String LoginName) throws RemoteException, Exception;

	public Boolean RuralHouseRefactorComment(RuralHouse rh) throws RemoteException, Exception;

	public RuralHouse addComment(Client c, int botua, String kom, RuralHouse rh) throws RemoteException, Exception;
	
	public Boolean updateHouse(RuralHouse rh) throws RemoteException, Exception;
	
	public Boolean updateHouse2(RuralHouse rh) throws RemoteException, Exception;

	
	public Boolean deleteAllCom(RuralHouse rh) throws RemoteException, Exception;

	public Boolean deleteCom(RuralHouse rh, int i) throws RemoteException, Exception;
	
	public int getFreeNumber() throws RemoteException, Exception;

	public Boolean createActivity(String izena, String deskribapena, int kop, Boolean egunez, Owner owner) throws RemoteException, Exception;
	
	public Vector<Activity> getOwnerActivities(Owner o) throws RemoteException, Exception;
	
	public Vector<Activity> getHouseActivities(RuralHouse rh) throws RemoteException, Exception;
	
	public Boolean addActivity(Activity a, RuralHouse rh) throws RemoteException, Exception;
	
	public Vector<Offer> OfertakBueltatu(String Login) throws RemoteException, Exception;
	
	public Offer offerBuelta(RuralHouse rh, Date d1, Date d2, Float price) throws RemoteException, Exception;
	
	public Boolean deleteOferta(RuralHouse rh, Offer o) throws RemoteException, Exception;
	
	public Vector<Offer> getOffersRH(RuralHouse rh, Date firstDay, Date lastDay) throws RemoteException, Exception;
}
