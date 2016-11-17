package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;

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
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/partyshop?useSSL=false", "root", "1234");

		return connection;
	}

	public void closeConnection() throws Exception {

		if (!conn.isClosed()) {
			conn.close();
		}

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
	public void userErzeugen(String userid, String mail, String vorname, String nachname, String passwort, String rolle,
			int gesperrt, String strasse, String hausnummer, int postleitzahl, String ort) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("INSERT INTO User " + "VALUES ('" + userid + "', '" + mail + "', '" + vorname + "', '"
				+ nachname + "', '" + passwort + "', '" + rolle + "', '" + gesperrt + "', '" + strasse + "', '"
				+ hausnummer + "', " + postleitzahl + ", '" + ort + "')");
		stmt.close();

	}

	/**
	 * 
	 * @param userid
	 * @param mail
	 * @param vorname
	 * @param nachname
	 * @param passwort
	 * @param strasse
	 * @param hausnummer
	 * @param postleitzahl
	 * @param ort
	 * @throws Exception
	 */
	public void userAktualisieren(String userid, String mail, String vorname, String nachname, String passwort,
			String strasse, String hausnummer, int postleitzahl, String ort) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Update User Set mail = '" + mail + "', vorname = '" + vorname + "', nachname = '" + nachname
				+ "', '" + passwort + "''" + strasse + "', '" + hausnummer + "', '" + postleitzahl + "', '" + ort
				+ "' where userid = '" + userid + "'");
		stmt.close();

	}

	/**
	 * 
	 * @param userid
	 * @throws Exception
	 */
	public void userSperren(String mail) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Update User Set gesperrt = 1 where mail = '" + mail + "' and rolle = 'kunde'");
		stmt.close();

	}

	/**
	 * 
	 * @param userid
	 * @throws Exception
	 */
	public void userEntsperren(String mail) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Update User Set gesperrt = 0 where mail = '" + mail + "' and rolle = 'kunde'");
		stmt.close();

	}

	/**
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public User userMitIdLiefern(String userid) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from user where userid = '" + userid + "'");

		User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), Integer.parseInt(rs.getString(7)), rs.getString(8), rs.getString(9),
				Integer.parseInt(rs.getString(10)), rs.getString(11));
		stmt.close();
		return user;

	}

	/**
	 * 
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	public User userMitMailLiefern(String mail) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from user where mail = '" + mail + "'");
		while (rs.next()) {
			User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), Integer.parseInt(rs.getString(7)), rs.getString(8), rs.getString(9),
					Integer.parseInt(rs.getString(10)), rs.getString(11));
			stmt.close();
			return user;
		}
		return null;

	}
	
	
	/**
	 * 
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	public User mitarbeiterMitMailLiefern(String mail) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from user where mail = '" + mail + "' and rolle = 'mitarbeiter'");
		while (rs.next()) {
			User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), Integer.parseInt(rs.getString(7)), rs.getString(8), rs.getString(9),
					Integer.parseInt(rs.getString(10)), rs.getString(11));
			stmt.close();
			return user;
		}
		return null;

	}

	/**
	 * 
	 * @param artikelid
	 * @throws Exception
	 */
	public void mitarbeiterLoeschen(String mail) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Delete from user where mail = '" + mail + "' and rolle = 'mitarbeiter'");
		stmt.close();

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
	public void artikelErzeugen(String artikelid, String bezeichnung, String beschreibung, double preis,
			String kategorie, File bild) throws Exception {

		Statement stmt = conn.createStatement();

		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());

		FileInputStream fis = null;
		PreparedStatement ps = null;

		String INSERT_ARTICLE = "insert into artikel(artikelid, bezeichnung, beschreibung, preis, kategorie, bild, zeitstempel) values (?,?,?,?,?,?,?)";

		try {
			conn.setAutoCommit(false);
			fis = new FileInputStream(bild);
			ps = conn.prepareStatement(INSERT_ARTICLE);
			ps.setString(1, artikelid);
			ps.setString(2, bezeichnung);
			ps.setString(3, beschreibung);
			ps.setDouble(4, preis);
			ps.setString(5, kategorie);
			ps.setBinaryStream(6, fis, (int) bild.length());
			ps.setTimestamp(7, timestamp);
			ps.executeUpdate();
			conn.commit();
		} finally {
			ps.close();
			fis.close();
			stmt.close();
		}

	}

	/**
	 * 
	 * @param artikelid
	 * @param bezeichnung
	 * @param beschreibung
	 * @param preis
	 * @param kategorie
	 * @param bild
	 * @throws Exception
	 */
	public void artikelAktualisieren(String artikelid, String bezeichnung, String beschreibung, double preis,
			String kategorie, File bild) throws Exception {

		Statement stmt = conn.createStatement();

		FileInputStream fis = null;
		PreparedStatement ps = null;

		String UPDATE_ARTICLE = "update artikel set bezeichnung = ?, beschreibung = ?, preis = ?, kategorie = ?, bild = ? where artikelid = ?";

		try {
			conn.setAutoCommit(false);
			fis = new FileInputStream(bild);
			ps = conn.prepareStatement(UPDATE_ARTICLE);
			ps.setString(1, bezeichnung);
			ps.setString(2, beschreibung);
			ps.setDouble(3, preis);
			ps.setString(4, kategorie);
			ps.setBinaryStream(5, fis, (int) bild.length());
			ps.setString(6, artikelid);
			ps.executeUpdate();
			conn.commit();
		} finally {
			ps.close();
			fis.close();
			stmt.close();
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
	public void artikelAktualisierenOhneBild(String artikelid, String bezeichnung, String beschreibung, double preis,
			String kategorie) throws Exception {

		Statement stmt = conn.createStatement();

		FileInputStream fis = null;
		PreparedStatement ps = null;

		String UPDATE_ARTICLE = "update artikel set bezeichnung = ?, beschreibung = ?, preis = ?, kategorie = ? where artikelid = ?";

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE_ARTICLE);
			ps.setString(1, bezeichnung);
			ps.setString(2, beschreibung);
			ps.setDouble(3, preis);
			ps.setString(4, kategorie);
			ps.setString(6, artikelid);
			ps.executeUpdate();
			conn.commit();
		} finally {
			ps.close();
			fis.close();
			stmt.close();
		}

	}

	/**
	 * 
	 * @param artikelid
	 * @throws Exception
	 */
	public void artikelLoeschen(String artikelid) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Delete from artikel where artikelid = '" + artikelid + "'");
		stmt.close();

	}

	/**
	 * 
	 * @param bezeichnung
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Artikel> artikelSuchen(String bezeichnungSub) throws Exception {

		ArrayList<Artikel> artikel = new ArrayList<Artikel>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt
				.executeQuery("Select * from artikel where upper(bezeichnung) like upper('%" + bezeichnungSub + "%')");

		while (rs.next()) {

			String tmp_dir = System.getProperty("catalina.base") + "/wtpwebapps/Partyshop/resources/images";
			File file = new File(tmp_dir + "/" + rs.getString(1) + ".jpg");
			if(!file.exists())
			{
				FileOutputStream output = new FileOutputStream(file);

				InputStream input = rs.getBinaryStream("bild");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);

			}
			
			}

			Artikel artikelElement = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5), file);

			artikel.add(artikelElement);
		}

		stmt.close();

		return artikel;

	}

	/**
	 * 
	 * @param kategorieid
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Artikel> artikelInKategorieLiefern(String kategorieid) throws Exception {

		ArrayList<Artikel> artikel = new ArrayList<Artikel>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel where kategorie = '" + kategorieid + "'");

		while (rs.next()) {
			 
			String tmp_dir = System.getProperty("catalina.base") + "/wtpwebapps/Partyshop/resources/images";
			File file = new File(tmp_dir + "/" + rs.getString(1) + ".jpg");

			if(!file.exists())
			{
				FileOutputStream output = new FileOutputStream(file);

				InputStream input = rs.getBinaryStream("bild");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);

			}
			
			}

			 
			Artikel artikelElement = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5), file);

			artikel.add(artikelElement);
		}

		stmt.close();
		return artikel;
	}

	public ArrayList<Artikel> alleArtikelLiefern() throws Exception {

		ArrayList<Artikel> artikel = new ArrayList<Artikel>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel");

		while (rs.next()) {

			String tmp_dir = System.getProperty("catalina.base") + "/wtpwebapps/Partyshop/resources/images";
			File file = new File(tmp_dir + "/" + rs.getString(1) + ".jpg");

			if(!file.exists())
			{
				FileOutputStream output = new FileOutputStream(file);

				InputStream input = rs.getBinaryStream("bild");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);

			}
			
			}


			Artikel artikelElement = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5), file);

			artikel.add(artikelElement);
		}

		stmt.close();
		return artikel;

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Artikel> neuesteZehnArtikelLiefern() throws Exception {

		ArrayList<Artikel> artikel = new ArrayList<Artikel>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel order by zeitstempel desc limit 10");

		while (rs.next()) {

			String tmp_dir = System.getProperty("catalina.base") + "/wtpwebapps/Partyshop/resources/images";
			File file = new File(tmp_dir + "/" + rs.getString(1) + ".jpg");

			if(!file.exists())
			{
				FileOutputStream output = new FileOutputStream(file);

				InputStream input = rs.getBinaryStream("bild");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);

			}
			
			}

			Artikel artikelElement = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5), file);

			artikel.add(artikelElement);
		}

		stmt.close();
		return artikel;

	}

	public ArrayList<Artikel> meistegkaufteZehnArtikelLiefern() throws Exception {

		ArrayList<Artikel> artikel = new ArrayList<Artikel>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(
				"Select a.artikelid, a.bezeichnung, a.beschreibung, a.preis, a.kategorie, a.bild, a.zeitstempel, (Select sum(*) where a.artikelbezeichnung = p.artikelbezeichnung) as anzVer from artikel a, position p  order by anzVer desc limit 10");

		while (rs.next()) {

			String tmp_dir = System.getProperty("catalina.base") + "/wtpwebapps/Partyshop/resources/images";
			File file = new File(tmp_dir + "/" + rs.getString(1) + ".jpg");

			if(!file.exists())
			{
				FileOutputStream output = new FileOutputStream(file);

				InputStream input = rs.getBinaryStream("bild");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);

			}
			
			}


			Artikel artikelElement = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5), file);

			artikel.add(artikelElement);
		}

		stmt.close();
		return artikel;

	}

	/**
	 * 
	 * @param artikelid
	 * @return
	 * @throws Exception
	 */
	public Artikel artikelMitIdLiefern(String artikelid) throws Exception {
		Artikel artikel = new Artikel("?");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel where artikelid = '" + artikelid + "'");

		String tmp_dir = System.getProperty("catalina.base") + "/wtpwebapps/Partyshop/resources/images";

		while (rs.next()) {
			
			File file = new File(tmp_dir + "/" + rs.getString(1) + ".jpg");

			if(!file.exists())
			{
				FileOutputStream output = new FileOutputStream(file);

				InputStream input = rs.getBinaryStream("bild");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);

			}
			
			}

			artikel = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5), file);

		}
		stmt.close();
		return artikel;

	}

	public Artikel artikelMitBezeichnungLiefern(String bezeichnung) throws Exception {
		Artikel artikel = new Artikel("?");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel where bezeichnung = '" + bezeichnung + "'");
		
		while (rs.next()) {
			String tmp_dir = System.getProperty("catalina.base") + "/wtpwebapps/Partyshop/resources/images";
			File file = new File(tmp_dir + "/" + rs.getString(1) + ".jpg");

			if(!file.exists())
			{
				FileOutputStream output = new FileOutputStream(file);

				InputStream input = rs.getBinaryStream("bild");
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);

			}
			
			}


			artikel = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5), file);

		}
		stmt.close();
		return artikel;

	}

	/**
	 * 
	 * @param kategorieid
	 * @param bezeichnung
	 * @throws Exception
	 */
	public void kategorieErzeugen(String kategorieid, String bezeichnung, int sichtbar) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate(
				"INSERT INTO kategorie " + "VALUES ('" + kategorieid + "', '" + bezeichnung + "', " + sichtbar + ")");
		stmt.close();

	}

	/**
	 * 
	 * @param kategorieid
	 * @param bezeichnung
	 * @throws Exception
	 */
	public void kategorieAktualisieren(String kategorieid, String bezeichnung, int sichtbar) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Update kategorie set bezeichnung = '" + bezeichnung + "', sichtbar = " + sichtbar
				+ "where kategorieid = '" + kategorieid + "'");
		stmt.close();

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Kategorie> kategorienLiefern() throws Exception {

		ArrayList<Kategorie> kategorien = new ArrayList<Kategorie>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from kategorie where sichtbar = 1");

		while (rs.next()) {

			Kategorie kategorie = new Kategorie(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)));

			kategorien.add(kategorie);
		}
		stmt.close();
		return kategorien;

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Kategorie kategorienLiefernMitBezeichnung(String bezeichnung) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt
				.executeQuery("Select * from kategorie where bezeichnung = '" + bezeichnung + "' and sichtbar = 1");

		while (rs.next()) {

			Kategorie kategorie = new Kategorie(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)));

			return kategorie;

		}
		stmt.close();
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Kategorie kategorienUnsichtbarLiefernMitBezeichnung(String bezeichnung) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt
				.executeQuery("Select * from kategorie where bezeichnung = '" + bezeichnung + "' and sichtbar = 0");

		while (rs.next()) {

			Kategorie kategorie = new Kategorie(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)));

			return kategorie;

		}
		stmt.close();
		return null;

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Kategorie kategorienLiefernMitId(String kategorieid) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt
				.executeQuery("Select * from kategorie where kategorieid = '" + kategorieid + "' and sichtbar = 1");

		while (rs.next()) {

			Kategorie kategorie = new Kategorie(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)));

			return kategorie;

		}
		stmt.close();
		return null;

	}

	/**
	 * 
	 * @param kategorieid
	 * @throws Exception
	 */
	public void kategorieUnsichtbar(String kategorieid) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Update kategorie Set sichtbar = 0 where kategorieid = '" + kategorieid + "'");
		stmt.close();

	}

	/**
	 * 
	 * @param kategorieid
	 * @throws Exception
	 */
	public void kategorieSichtbar(String kategorieid) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Update kategorie Set sichtbar = 1 where kategorieid = '" + kategorieid + "'");
		stmt.close();

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
	public void bestellungUndPositionenErzeugen(String bestellungid, String user, Double preis,
			ArrayList<Position> positionen, String datum) throws Exception {

		Statement stmtBes = conn.createStatement();

		stmtBes.executeUpdate("INSERT INTO bestellung " + "VALUES ('" + bestellungid + "', '" + user + "', '" + preis
				+ "', '" + datum + "')");
		stmtBes.close();

		for (Position pos : positionen) {

			Statement stmtPos = conn.createStatement();

			stmtPos.executeUpdate(
					"INSERT INTO position " + "VALUES ('" + pos.getPositionid() + "', '" + pos.getArtikelbezeichnung()
							+ "', '" + pos.getMenge() + "', '" + bestellungid + "', '" + pos.getPreis() + "')");
			stmtPos.close();

		}
	}

	/**
	 * 
	 * @param user
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public ArrayList<Bestellung> bestellungenVonUserLiefern(String userid) throws NumberFormatException, Exception {

		ArrayList<Bestellung> bestellungen = new ArrayList<Bestellung>();

		Statement stmtBes = conn.createStatement();

		ResultSet rsBes = stmtBes.executeQuery("Select * from bestellung where user = '" + userid + "'");

		while (rsBes.next()) {
			ArrayList<Position> positionen = new ArrayList<Position>();

			Statement stmtPos = conn.createStatement();

			ResultSet rsPos = stmtPos.executeQuery("Select * from position where user = '" + userid + "'");

			while (rsPos.next()) {
				Position pos = new Position(rsPos.getString(1), rsPos.getString(2),
						Integer.parseInt(rsPos.getString(3)), Double.parseDouble(rsPos.getString(4)));
				positionen.add(pos);
			}
			Bestellung b = new Bestellung(rsBes.getString(2), Double.parseDouble(rsBes.getString(3)), positionen, rsBes.getString(4));
			bestellungen.add(b);
			stmtPos.close();
		}
		stmtBes.close();

		return bestellungen;
	}

}
