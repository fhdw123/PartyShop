package classes;

import java.util.ArrayList;
import java.util.UUID;

public class User {

	private SqlConnection jdbc;
	private String userid;
	private String mail;
	private String vorname;
	private String nachname;
	private String passwort;
	private String rolle;
	private int gesperrt;
	private String strasse;
	private String hausnummer;
	private int postleitzahl;
	private String ort;

	/**
	 * 
	 * @param mail
	 * @param vorname
	 * @param nachname
	 * @param passwort
	 * @param rolle
	 * @param gesperrt
	 * @param strasse
	 * @param hausnummer
	 * @param postleitzahl
	 * @param ort
	 * @throws Exception
	 */
	public User(String mail, String vorname, String nachname, String passwort, String rolle, int gesperrt,
			String strasse, String hausnummer, int postleitzahl, String ort) throws Exception {
		super();
		this.userid = UUID.randomUUID().toString();
		this.mail = mail;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwort = passwort;
		this.rolle = rolle;
		this.gesperrt = gesperrt;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
	}
	
	
/**
 * 
 * @param userid
 * @param mail
 * @param vorname
 * @param nachname
 * @param passwort
 * @param rolle
 * @param gesperrt
 * @param strasse
 * @param hausnummer
 * @param postleitzahl
 * @param ort
 * @throws Exception
 */
	public User(String userid, String mail, String vorname, String nachname, String passwort, String rolle, int gesperrt,
			String strasse, String hausnummer, int postleitzahl, String ort) throws Exception {
		super();
		this.userid = userid;
		this.mail = mail;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwort = passwort;
		this.rolle = rolle;
		this.gesperrt = gesperrt;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
	}
	
	
	/**
	 * 
	 * @param userid
	 * @throws Exception
	 */
	public User(String userid) throws Exception {
		super();
		this.userid = userid;
	}
	
	
	public User(String mail, String passwort) throws Exception  {
		super();
		this.mail = mail;
		this.passwort = passwort;
	}
	
	

	/**
	 * 
	 * @return
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 
	 * @param userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 
	 * @return
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * 
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * 
	 * @return
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * 
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * 
	 * @return
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * 
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * 
	 * @return
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * 
	 * @param passwort
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/**
	 * 
	 * @return
	 */
	public String getRolle() {
		return rolle;
	}

	/**
	 * 
	 * @param rolle
	 */
	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	/**
	 * 
	 * @return
	 */
	public int getGesperrt() {
		return gesperrt;
	}

	/**
	 * 
	 * @param gesperrt
	 */
	public void setGesperrt(int gesperrt) {
		this.gesperrt = gesperrt;
	}

	/**
	 * 
	 * @return
	 */
	public String getStrasse() {
		return strasse;
	}

	/**
	 * 
	 * @param strasse
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	/**
	 * 
	 * @return
	 */
	public String getHausnummer() {
		return hausnummer;
	}

	/**
	 * 
	 * @param hausnummer
	 */
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	/**
	 * 
	 * @return
	 */
	public int getPostleitzahl() {
		return postleitzahl;
	}

	/**
	 * 
	 * @param postleitzahl
	 */
	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	/**
	 * 
	 * @return
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * 
	 * @param ort
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	
	/**
	 * 
	 * @throws Exception
	 */
	public void userAnlegen() throws Exception {
		jdbc = new SqlConnection();
		jdbc.userErzeugen(userid, mail, vorname, nachname, passwort, rolle, gesperrt, strasse, hausnummer, postleitzahl,
				ort);
		jdbc.closeConnection();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void userAktualisieren() throws Exception {
		jdbc = new SqlConnection();
		jdbc.userAktualisieren(userid, mail, vorname, nachname, passwort, strasse, hausnummer, postleitzahl, ort);
		jdbc.closeConnection();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void lockUser() throws Exception
	{
		jdbc = new SqlConnection();
		this.gesperrt = 1;
		jdbc.userSperren(userid);
		jdbc.closeConnection();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void unlockUser() throws Exception
	{
		jdbc = new SqlConnection();
		this.gesperrt = 0;
		jdbc.userEntsperren(userid);
		jdbc.closeConnection();
	}
	
	
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Bestellung> bestellungenVonUserLiefern() throws Exception
	{
		jdbc = new SqlConnection();
		ArrayList<Bestellung> bestellungen = jdbc.bestellungenVonUserLiefern(userid);
		jdbc.closeConnection();
		return bestellungen;
	}
	

}
