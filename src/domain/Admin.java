package domain;
import java.io.Serializable;
import java.util.Vector;

public class Admin implements Serializable {
	private String login="admin";
	private String password="1234";
	private Vector<Owner> owners = new Vector();
	private Vector<Client> clients = new Vector();
	
	
	
	public Admin(String login, String password, Vector<Owner> owners, Vector<Client> clients) {
		// TODO Auto-generated constructor stub
		this.login=login;
		this.password=password;
		//this.isAdmin= isAdmin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Vector<Owner> getOwners() {
		return owners;
	}
	public void setOwners(Vector<Owner> owners) {
		this.owners = owners;
	}
	public Vector<Client> getClients() {
		return clients;
	}
	public void setClients(Vector<Client> clients) {
		this.clients = clients;
	}
	public Boolean deleteOwner (Owner o){
		return this.owners.remove(o);
	}
	public Boolean deleteClient (Client c){
		return this.clients.remove(c);
	}

}
