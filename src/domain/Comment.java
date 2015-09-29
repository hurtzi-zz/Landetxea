package domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
	private int botua;
	private Client egilea;
	private String coment;
	private Date eguna;



	public Comment(Client c, int bot, String com){
		this.egilea=c;
		this.botua = bot;
		this.coment=com;
		Date dat = new Date();
		this.eguna = dat;
	}
	
	public int getBotua() {
		return botua;
	}
	public void setBotua(int botua) {
		this.botua = botua;
	}
	public Client getEgilea() {
		return egilea;
	}
	public void setEgilea(Owner egilea) {
		this.egilea = egilea;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	public Date getEguna() {
		return eguna;
	}
	public void setEguna(Date eguna) {
		this.eguna = eguna;
	}
	}
