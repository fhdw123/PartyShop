package classes;

public class Bestellung {

	
	
	private int bestellungid;
	private User user;
	private String preis;
	private String menge;
	private Position[] positionen;
	
	
	public Bestellung(int bestellungid, User user, String preis, String menge, Position[] positionen) {
		super();
		this.bestellungid = bestellungid;
		this.user = user;
		this.preis = preis;
		this.menge = menge;
		this.positionen = positionen;
	}


	public int getBestellungid() {
		return bestellungid;
	}


	public void setBestellungid(int bestellungid) {
		this.bestellungid = bestellungid;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getPreis() {
		return preis;
	}


	public void setPreis(String preis) {
		this.preis = preis;
	}


	public String getMenge() {
		return menge;
	}


	public void setMenge(String menge) {
		this.menge = menge;
	}


	public Position[] getPositionen() {
		return positionen;
	}


	public void setPositionen(Position[] positionen) {
		this.positionen = positionen;
	}
	
	
	
	
}
