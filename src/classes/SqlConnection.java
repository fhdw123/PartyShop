package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

public class SqlConnection {

	private Connection conn;

	/**
	 * 
	 * @throws Exception
	 */
	public SqlConnection() throws Exception {
		super();
		this.conn = this.getJDBCConnection();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getJDBCConnection() throws Exception {
		Connection connection = null;

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/partyshop", "root", "1234");

		return connection;
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
	public void createUser(String userid, String mail, String vorname, String nachname, String passwort, String rolle,
			int gesperrt, String strasse, String hausnummer, int postleitzahl, String ort) throws Exception {

		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("INSERT INTO User " + "VALUES ('" + userid + "', '" + mail + "', '" + vorname + "', '"
					+ nachname + "', '" + passwort + "', '" + rolle + "', '" + gesperrt + "', '" + strasse + "', '"
					+ hausnummer + "', " + postleitzahl + ", '" + ort + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param artikelid
	 * @param bezeichnung
	 * @param beschreibung
	 * @param preis
	 * @param kategorie
	 * @throws Exception
	 */
	public void createArtikel(String artikelid, String bezeichnung, String beschreibung, double preis, String kategorie)
			throws Exception {

		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("INSERT INTO artikel " + "VALUES ('" + artikelid + "', '" + bezeichnung + "', '"
					+ beschreibung + "', '" + preis + "', '" + kategorie + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param bestellungid
	 * @param user
	 * @param preis
	 * @param menge
	 * @param positionen
	 * @throws Exception
	 */
	public void createBestellungAndPositions(String bestellungid, String user, Double preis, int menge,
			ArrayList<Position> positionen) throws Exception {

		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("INSERT INTO bestellung " + "VALUES ('" + bestellungid + "', '" + user + "', '" + preis
					+ "', '" + menge + "')");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Position pos : positionen) {
			try {
				Statement stmt = conn.createStatement();

				stmt.executeUpdate("INSERT INTO position " + "VALUES ('" + pos.getPositionid() + "', '"
						+ pos.getArtikelbezeichnung() + "', '" + pos.getMenge() + "', '" + bestellungid + "', '"
						+ pos.getPreis() + "')");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public ArrayList<Bestellung> getUserBestellungen(User user) throws NumberFormatException, Exception {
		
		ArrayList<Bestellung> bestellungen = new ArrayList<Bestellung>();

		Statement stmtBes = conn.createStatement();

		ResultSet rsBes = stmtBes.executeQuery("Select * from bestellung where user = '" + user.getUserid() + "'");

		while (rsBes.next()) {
			ArrayList<Position> positionen = new ArrayList<Position>();

			Statement stmtPos = conn.createStatement();

			ResultSet rsPos = stmtPos.executeQuery("Select * from bestellung where user = '" + user.getUserid() + "'");

			while (rsPos.next()) {
				Position pos = new Position(rsPos.getString(1), rsPos.getString(2),
						Integer.parseInt(rsPos.getString(3)), Double.parseDouble(rsPos.getString(4)));
				positionen.add(pos);
			}
			Bestellung b = new Bestellung(rsBes.getString(1), rsBes.getString(2),
					Double.parseDouble(rsBes.getString(3)), Integer.parseInt(rsBes.getString(4)), positionen);
		}
		return bestellungen;
	}

}
