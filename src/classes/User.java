package classes;


import java.sql.Connection;
import java.sql.Statement;

public class User {
	
	private int userid;
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
	
	
	public User(int userid, String mail, String vorname, String nachname, String passwort, String rolle,
			int gesperrt, String strasse, String hausnummer, String postleitzahl, String ort) throws Exception {
		super();
		this.userid = userid;
		this.mail = mail;
		this.vorname = vorname;
		this.nachname = nachname;
		this.passwort = passwort;
		this.rolle = rolle;
		this.gesperrt = gesperrt;
		this. strasse = strasse;
		this. hausnummer = hausnummer;
		try{
			this.postleitzahl= Integer.parseInt(postleitzahl);
		}
		catch(Exception ex){
		 throw new Exception("Keine gültige Postleitzahl!");
		}
		this.ort = ort;
		}

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String getRolle() {
		return rolle;
	}
	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public int getGesperrt() {
		return gesperrt;
	}

	public void setGesperrt(int gesperrt) {
		this.gesperrt = gesperrt;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getPostleitzahl() {
		return postleitzahl;
	}

	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	
	public void createUserInDB()
	{
		SqlConnection sqlConnection = new SqlConnection();
		Connection conn;
		try {
			conn = sqlConnection.getJDBCConnection();
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate("INSERT INTO User " + "VALUES (0, '"+mail+"', '"+vorname+"', '"+nachname+"', '"+passwort+"', 'kunde', '"+gesperrt+"', '"+strasse+"', '"+hausnummer+"', "+postleitzahl+", '"+ort+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		// insert the data
		
		
	}

	
	

}
