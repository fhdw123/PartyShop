package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class Bestellung {

	private SqlConnection jdbc;
	private String bestellungid;
	private String user;
	private double preis;
	private String datum;
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
	public Bestellung(String user, double preis, ArrayList<Position> positionen)
			throws Exception {
		super();
		this.bestellungid = UUID.randomUUID().toString();
		this.user = user;
		this.preis = preis;
		this.positionen = positionen;
	}
	
	/**
	 * 
	 * @param user
	 * @param preis
	 * @param positionen
	 * @param datum
	 * @throws Exception
	 */
	public Bestellung(String user, double preis, ArrayList<Position> positionen, String datum)
			throws Exception {
		super();
		this.bestellungid = UUID.randomUUID().toString();
		this.user = user;
		this.preis = preis;
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
	public void bestellungUndPositionenErzeugen() throws Exception {
		jdbc = new SqlConnection();
		
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Calendar c = df.getCalendar();
        c.setTimeInMillis(System.currentTimeMillis());
        datum = c.get(Calendar.DAY_OF_MONTH) + "." + (c.get(Calendar.MONTH) + 1) + "." + c.get(Calendar.YEAR);
		
		jdbc.bestellungUndPositionenErzeugen(bestellungid, user, preis, positionen, datum);
		jdbc.closeConnection();
	}
	
	
	

}
