package classes;

import java.util.UUID;

public class Artikel {

	private SqlConnection jdbc;
	private String artikelid;
	private String bezeichnung;
	private String beschreibung;
	private double preis;
	private String kategorie;

	
	/**
	 * 
	 * @param bezeichnung
	 * @param beschreibung
	 * @param preis
	 * @param kategorie
	 * @throws Exception
	 */
	public Artikel(String bezeichnung, String beschreibung, double preis, String kategorie) throws Exception {
		super();
		this.artikelid = UUID.randomUUID().toString();
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.kategorie = kategorie;
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
	public Artikel(String artikelid, String bezeichnung, String beschreibung, double preis, String kategorie) throws Exception {
		super();
		this.artikelid = artikelid;
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.kategorie = kategorie;
	}
	
	
	/**
	 * 
	 * @param artikelid
	 * @throws Exception
	 */
	public Artikel(String artikelid) throws Exception {
		super();
		this.artikelid = artikelid;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getArtikelid() {
		return artikelid;
	}

	
	/**
	 * 
	 * @param artikelid
	 */
	public void setArtikelid(String artikelid) {
		this.artikelid = artikelid;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	
	/**
	 * 
	 * @param bezeichnung
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * 
	 * @return
	 */
	public String getBeschreibung() {
		return beschreibung;
	}
	

	/**
	 * 
	 * @param beschreibung
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
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
	public void setPreis(int preis) {
		this.preis = preis;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getKategorie() {
		return kategorie;
	}

	
	/**
	 * 
	 * @param kategorie
	 */
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	
	/**
	 * 
	 * @throws Exception
	 */
	public void createArtikelInDB() throws Exception {
		jdbc = new SqlConnection();
		jdbc.createArtikel(artikelid, bezeichnung, beschreibung, preis, kategorie);
		jdbc.closeConnection();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void deleteArtikel() throws Exception
	{
		jdbc = new SqlConnection();
		jdbc.deleteArtikel(artikelid);
		jdbc.closeConnection();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void showArtikelData() throws Exception
	{
		jdbc = new SqlConnection();
		Artikel tempArtikel = jdbc.showArtikelData(artikelid);
		this.bezeichnung = tempArtikel.getBezeichnung();
		this.beschreibung = tempArtikel.getBeschreibung();
		this.preis = tempArtikel.getPreis();
		this.kategorie = tempArtikel.getKategorie();
		jdbc.closeConnection();
	}

}
