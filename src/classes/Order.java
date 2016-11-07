package classes;

import java.util.ArrayList;
import java.util.UUID;

public class Order {

	private SqlConnection jdbc;
	private String bestellungid;
	private String user;
	private double preis;
	private int menge;
	private ArrayList<Position> positionen;

	/**
	 * 
	 * @param bestellungid
	 * @param user
	 * @param preis
	 * @param menge
	 * @param positionen
	 * @throws Exception
	 */
	public Order(String bestellungid, String user, double preis, int menge, ArrayList<Position> positionen)
			throws Exception {
		super();
		this.bestellungid = UUID.randomUUID().toString();
		this.user = user;
		this.preis = preis;
		this.menge = menge;
		this.positionen = positionen;
	}

	/**
	 * 
	 * @return
	 */
	public String getBestellungid() {
		return bestellungid;
	}

	/**
	 * 
	 * @param bestellungid
	 */
	public void setBestellungid(String bestellungid) {
		this.bestellungid = bestellungid;
	}

	/**
	 * 
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 
	 * @return
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * 
	 * @param preis
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	/**
	 * 
	 * @return
	 */
	public int getMenge() {
		return menge;
	}

	/**
	 * 
	 * @param menge
	 */
	public void setMenge(int menge) {
		this.menge = menge;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Position> getPositionen() {
		return positionen;
	}

	/**
	 * 
	 * @param positionen
	 */
	public void setPositionen(ArrayList<Position> positionen) {
		this.positionen = positionen;
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void createBestellungAndPositionsInDB() throws Exception {
		jdbc = new SqlConnection();
		jdbc.createBestellungAndPositions(bestellungid, user, preis, menge, positionen);
		jdbc.closeConnection();
	}

}
