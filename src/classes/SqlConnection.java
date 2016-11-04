package classes;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public void createUser(String userid, String mail, String vorname, String nachname, String passwort, String rolle,
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
	public void updateUser(String userid, String mail, String vorname, String nachname, String passwort, String strasse,
			String hausnummer, int postleitzahl, String ort) throws Exception {

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
	public void lockUser(String userid) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Update User Set gesperrt = 1 where userid = '" + userid + "'");
		stmt.close();

	}

	/**
	 * 
	 * @param userid
	 * @throws Exception
	 */
	public void unlockUser(String userid) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Update User Set gesperrt = 0 where userid = '" + userid + "'");
		stmt.close();

	}

	/**
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public User showUserDataById(String userid) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from user where userid = '" + userid + "'");

		User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), Integer.parseInt(rs.getString(7)), rs.getString(8), rs.getString(9),
				Integer.parseInt(rs.getString(10)), rs.getString(11));
		stmt.close();
		return user;

	}

	public User showUserDataByMail(String mail) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from user where mail = '" + mail + "'");

		User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), Integer.parseInt(rs.getString(7)), rs.getString(8), rs.getString(9),
				Integer.parseInt(rs.getString(10)), rs.getString(11));
		stmt.close();
		return user;

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
	public void createArtikel(String artikelid, String bezeichnung, String beschreibung, double preis, String kategorie, File bild)
			throws Exception {

		Statement stmt = conn.createStatement();
		
		
		FileInputStream fis = null;
	    PreparedStatement ps = null;
	    
		String INSERT_ARTICLE = "insert into artikel(artikelid, bezeichnung, beschreibung, preis, kategorie, bild) values ('"+artikelid+"', '"+bezeichnung+"', '"+beschreibung+"', '"+preis+"', '"+kategorie+"', ?)";
		
		
		
	    try {
	      conn.setAutoCommit(false);
	      fis = new FileInputStream(bild);
	      ps = conn.prepareStatement(INSERT_ARTICLE);
	      ps.setBinaryStream(6, fis, (int) bild.length());
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
	public void updateArtikel(String artikelid, String bezeichnung, String beschreibung, double preis, String kategorie, File bild)
			throws Exception {

		Statement stmt = conn.createStatement();
		
		
		FileInputStream fis = null;
	    PreparedStatement ps = null;
	    
		String UPDATE_ARTICLE = "update artikel set bezeichnung = '"+bezeichnung+"', beschreibung = '"+beschreibung+"', preis = '"+preis+"', kategorie = '"+kategorie+"', bild = ?)";
		
		
		
	    try {
	      conn.setAutoCommit(false);
	      fis = new FileInputStream(bild);
	      ps = conn.prepareStatement(UPDATE_ARTICLE);
	      ps.setBinaryStream(5, fis, (int) bild.length());
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
	public void deleteArtikel(String artikelid) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("Delete from artikel where artikelid = '" + artikelid + "'");
		stmt.close();

	}

	/**
	 * 
	 * @param artikelid
	 * @return
	 * @throws Exception
	 */
	public Artikel showArtikelDataById(String artikelid) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel where artikelid = '" + artikelid + "'");
		
		File file = new File("C:/Users/Jannik/Desktop/bild.jpg");
		FileOutputStream output = new FileOutputStream(file);
		 
		    InputStream input = rs.getBinaryStream("bild");
		    byte[] buffer = new byte[1024];
		    while (input.read(buffer) > 0) {
		        output.write(buffer);
		    
		}
		

		Artikel artikel = new Artikel(rs.getString(2), rs.getString(3), Double.parseDouble(rs.getString(4)),
				rs.getString(5), file);
		stmt.close();
		return artikel;

	}

	/**
	 * 
	 * @param bezeichnung
	 * @return
	 * @throws Exception
	 */
	public Artikel showArtikelDataByName(String bezeichnung) throws Exception {

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel where bezeichnung = '" + bezeichnung + "'");
		
		File file = new File("C:/Users/Jannik/Desktop/bild.jpg");
		FileOutputStream output = new FileOutputStream(file);
		 
		    InputStream input = rs.getBinaryStream("bild");
		    byte[] buffer = new byte[1024];
		    while (input.read(buffer) > 0) {
		        output.write(buffer);
		    
		}

		Artikel artikel = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3), Double.parseDouble(rs.getString(4)),
				rs.getString(5), file);
		stmt.close();
		return artikel;

	}

	/**
	 * 
	 * @param kategorieid
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Artikel> showArtikelsInKategorie(String kategorieid) throws Exception {

		ArrayList<Artikel> artikels = new ArrayList<Artikel>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel where kategorie = '" + kategorieid + "'");

		while (rs.next()) {

			Artikel artikel = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5));

			artikels.add(artikel);
		}
		stmt.close();
		return artikels;
	}

	public ArrayList<Artikel> showAllArtikels() throws Exception {

		ArrayList<Artikel> artikels = new ArrayList<Artikel>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from artikel");

		while (rs.next()) {

			Artikel artikel = new Artikel(rs.getString(1), rs.getString(2), rs.getString(3),
					Double.parseDouble(rs.getString(4)), rs.getString(5));

			artikels.add(artikel);
		}
		stmt.close();
		return artikels;

	}

	/**
	 * 
	 * @param kategorieid
	 * @param bezeichnung
	 * @throws Exception
	 */
	public void createKategorie(String kategorieid, String bezeichnung) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate("INSERT INTO kategorie " + "VALUES ('" + kategorieid + "', '" + bezeichnung + "')");
		stmt.close();

	}

	/**
	 * 
	 * @param kategorieid
	 * @param bezeichnung
	 * @throws Exception
	 */
	public void updateKategorie(String kategorieid, String bezeichnung) throws Exception {

		Statement stmt = conn.createStatement();

		stmt.executeUpdate(
				"Update kategorie set bezeichnung = '" + bezeichnung + "'where kategorieid = '" + kategorieid + "'");
		stmt.close();

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Kategorie> showKategorien() throws Exception {

		ArrayList<Kategorie> kategorien = new ArrayList<Kategorie>();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from kategorie");

		while (rs.next()) {

			Kategorie kategorie = new Kategorie(rs.getString(1), rs.getString(2));

			kategorien.add(kategorie);
		}
		stmt.close();
		return kategorien;

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

		Statement stmtBes = conn.createStatement();

		stmtBes.executeUpdate("INSERT INTO bestellung " + "VALUES ('" + bestellungid + "', '" + user + "', '" + preis
				+ "', '" + menge + "')");
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
	public ArrayList<Bestellung> showUserBestellungen(String userid) throws NumberFormatException, Exception {

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
			Bestellung b = new Bestellung(rsBes.getString(1), rsBes.getString(2),
					Double.parseDouble(rsBes.getString(3)), Integer.parseInt(rsBes.getString(4)), positionen);
			stmtPos.close();
		}
		stmtBes.close();

		return bestellungen;
	}
	
	

}
