package classes;


import java.util.UUID;

public class Kategorie {
	
	private SqlConnection jdbc;
	private String kategorieid;
	private String bezeichnung;
	
	/**
	 * 
	 * @param bezeichnung
	 * @throws Exception
	 */
	public Kategorie(String bezeichnung) throws Exception {
		super();
		this.kategorieid = UUID.randomUUID().toString();
		this.bezeichnung = bezeichnung;
	}
	
	
	/**
	 * 
	 * @param kategorieid
	 * @param bezeichnung
	 * @throws Exception
	 */
	public Kategorie(String kategorieid, String bezeichnung) throws Exception {
		super();
		this.kategorieid = kategorieid;
		this.bezeichnung = bezeichnung;
	}


	/**
	 * 
	 * @return
	 */
	public String getKategorieid() {
		return kategorieid;
	}


	/**
	 * 
	 * @param kategorieid
	 */
	public void setKategorieid(String kategorieid) {
		this.kategorieid = kategorieid;
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
	 * @throws Exception
	 */
	public void kategorieErzeugen() throws Exception
	{
		jdbc = new SqlConnection();
		jdbc.kategorieErzeugen(kategorieid, bezeichnung);
		jdbc.closeConnection();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void kategorieAktualisieren() throws Exception
	{
		jdbc = new SqlConnection();
		jdbc.kategorieAktualisieren(kategorieid, bezeichnung);
		jdbc.closeConnection();
	}
	
	
	

}
